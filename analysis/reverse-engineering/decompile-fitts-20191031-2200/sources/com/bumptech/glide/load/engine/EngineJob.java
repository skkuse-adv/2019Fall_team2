package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

class EngineJob<R> implements Callback<R>, Poolable {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private final GlideExecutor animationExecutor;
    final ResourceCallbacksAndExecutors cbs;
    DataSource dataSource;
    private DecodeJob<R> decodeJob;
    private final GlideExecutor diskCacheExecutor;
    EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    GlideException exception;
    private boolean hasLoadFailed;
    private boolean hasResource;
    private boolean isCacheable;
    private volatile boolean isCancelled;
    private Key key;
    private final EngineJobListener listener;
    private boolean onlyRetrieveFromCache;
    private final AtomicInteger pendingCallbacks;
    private final Pool<EngineJob<?>> pool;
    private Resource<?> resource;
    private final GlideExecutor sourceExecutor;
    private final GlideExecutor sourceUnlimitedExecutor;
    private final StateVerifier stateVerifier;
    private boolean useAnimationPool;
    private boolean useUnlimitedSourceGeneratorPool;

    private class CallLoadFailed implements Runnable {
        private final ResourceCallback cb;

        CallLoadFailed(ResourceCallback resourceCallback) {
            this.cb = resourceCallback;
        }

        public void run() {
            synchronized (EngineJob.this) {
                if (EngineJob.this.cbs.contains(this.cb)) {
                    EngineJob.this.callCallbackOnLoadFailed(this.cb);
                }
                EngineJob.this.decrementPendingCallbacks();
            }
        }
    }

    private class CallResourceReady implements Runnable {
        private final ResourceCallback cb;

        CallResourceReady(ResourceCallback resourceCallback) {
            this.cb = resourceCallback;
        }

        public void run() {
            synchronized (EngineJob.this) {
                if (EngineJob.this.cbs.contains(this.cb)) {
                    EngineJob.this.engineResource.acquire();
                    EngineJob.this.callCallbackOnResourceReady(this.cb);
                    EngineJob.this.removeCallback(this.cb);
                }
                EngineJob.this.decrementPendingCallbacks();
            }
        }
    }

    @VisibleForTesting
    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> build(Resource<R> resource, boolean z) {
            return new EngineResource<>(resource, z, true);
        }
    }

    static final class ResourceCallbackAndExecutor {
        final ResourceCallback cb;
        final Executor executor;

        ResourceCallbackAndExecutor(ResourceCallback resourceCallback, Executor executor2) {
            this.cb = resourceCallback;
            this.executor = executor2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ResourceCallbackAndExecutor)) {
                return false;
            }
            return this.cb.equals(((ResourceCallbackAndExecutor) obj).cb);
        }

        public int hashCode() {
            return this.cb.hashCode();
        }
    }

    static final class ResourceCallbacksAndExecutors implements Iterable<ResourceCallbackAndExecutor> {
        private final List<ResourceCallbackAndExecutor> callbacksAndExecutors;

        ResourceCallbacksAndExecutors() {
            this(new ArrayList(2));
        }

        ResourceCallbacksAndExecutors(List<ResourceCallbackAndExecutor> list) {
            this.callbacksAndExecutors = list;
        }

        /* access modifiers changed from: 0000 */
        public void add(ResourceCallback resourceCallback, Executor executor) {
            this.callbacksAndExecutors.add(new ResourceCallbackAndExecutor(resourceCallback, executor));
        }

        /* access modifiers changed from: 0000 */
        public void remove(ResourceCallback resourceCallback) {
            this.callbacksAndExecutors.remove(defaultCallbackAndExecutor(resourceCallback));
        }

        /* access modifiers changed from: 0000 */
        public boolean contains(ResourceCallback resourceCallback) {
            return this.callbacksAndExecutors.contains(defaultCallbackAndExecutor(resourceCallback));
        }

        /* access modifiers changed from: 0000 */
        public boolean isEmpty() {
            return this.callbacksAndExecutors.isEmpty();
        }

        /* access modifiers changed from: 0000 */
        public int size() {
            return this.callbacksAndExecutors.size();
        }

        /* access modifiers changed from: 0000 */
        public void clear() {
            this.callbacksAndExecutors.clear();
        }

        /* access modifiers changed from: 0000 */
        public ResourceCallbacksAndExecutors copy() {
            return new ResourceCallbacksAndExecutors(new ArrayList(this.callbacksAndExecutors));
        }

        private static ResourceCallbackAndExecutor defaultCallbackAndExecutor(ResourceCallback resourceCallback) {
            return new ResourceCallbackAndExecutor(resourceCallback, Executors.directExecutor());
        }

        @NonNull
        public Iterator<ResourceCallbackAndExecutor> iterator() {
            return this.callbacksAndExecutors.iterator();
        }
    }

    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pool<EngineJob<?>> pool2) {
        this(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, engineJobListener, pool2, DEFAULT_FACTORY);
    }

    @VisibleForTesting
    EngineJob(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, Pool<EngineJob<?>> pool2, EngineResourceFactory engineResourceFactory2) {
        this.cbs = new ResourceCallbacksAndExecutors();
        this.stateVerifier = StateVerifier.newInstance();
        this.pendingCallbacks = new AtomicInteger();
        this.diskCacheExecutor = glideExecutor;
        this.sourceExecutor = glideExecutor2;
        this.sourceUnlimitedExecutor = glideExecutor3;
        this.animationExecutor = glideExecutor4;
        this.listener = engineJobListener;
        this.pool = pool2;
        this.engineResourceFactory = engineResourceFactory2;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public synchronized EngineJob<R> init(Key key2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.key = key2;
        this.isCacheable = z;
        this.useUnlimitedSourceGeneratorPool = z2;
        this.useAnimationPool = z3;
        this.onlyRetrieveFromCache = z4;
        return this;
    }

    public synchronized void start(DecodeJob<R> decodeJob2) {
        GlideExecutor glideExecutor;
        this.decodeJob = decodeJob2;
        if (decodeJob2.willDecodeFromCache()) {
            glideExecutor = this.diskCacheExecutor;
        } else {
            glideExecutor = getActiveSourceExecutor();
        }
        glideExecutor.execute(decodeJob2);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void addCallback(ResourceCallback resourceCallback, Executor executor) {
        this.stateVerifier.throwIfRecycled();
        this.cbs.add(resourceCallback, executor);
        boolean z = true;
        if (this.hasResource) {
            incrementPendingCallbacks(1);
            executor.execute(new CallResourceReady(resourceCallback));
        } else if (this.hasLoadFailed) {
            incrementPendingCallbacks(1);
            executor.execute(new CallLoadFailed(resourceCallback));
        } else {
            if (this.isCancelled) {
                z = false;
            }
            Preconditions.checkArgument(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void callCallbackOnResourceReady(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onResourceReady(this.engineResource, this.dataSource);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void callCallbackOnLoadFailed(ResourceCallback resourceCallback) {
        try {
            resourceCallback.onLoadFailed(this.exception);
        } catch (Throwable th) {
            throw new CallbackException(th);
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void removeCallback(ResourceCallback resourceCallback) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        this.cbs.remove(resourceCallback);
        if (this.cbs.isEmpty()) {
            cancel();
            if (!this.hasResource) {
                if (!this.hasLoadFailed) {
                    z = false;
                    if (z && this.pendingCallbacks.get() == 0) {
                        release();
                    }
                }
            }
            z = true;
            release();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean onlyRetrieveFromCache() {
        return this.onlyRetrieveFromCache;
    }

    private GlideExecutor getActiveSourceExecutor() {
        if (this.useUnlimitedSourceGeneratorPool) {
            return this.sourceUnlimitedExecutor;
        }
        return this.useAnimationPool ? this.animationExecutor : this.sourceExecutor;
    }

    /* access modifiers changed from: 0000 */
    public void cancel() {
        if (!isDone()) {
            this.isCancelled = true;
            this.decodeJob.cancel();
            this.listener.onEngineJobCancelled(this, this.key);
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    private boolean isDone() {
        return this.hasLoadFailed || this.hasResource || this.isCancelled;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        r4.listener.onEngineJobComplete(r4, r0, r2);
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (r0.hasNext() == false) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r0.next();
        r1.executor.execute(new com.bumptech.glide.load.engine.EngineJob.CallResourceReady(r4, r1.cb));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
        decrementPendingCallbacks();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0067, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyCallbacksOfResult() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bumptech.glide.util.pool.StateVerifier r0 = r4.stateVerifier     // Catch:{ all -> 0x0078 }
            r0.throwIfRecycled()     // Catch:{ all -> 0x0078 }
            boolean r0 = r4.isCancelled     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0014
            com.bumptech.glide.load.engine.Resource<?> r0 = r4.resource     // Catch:{ all -> 0x0078 }
            r0.recycle()     // Catch:{ all -> 0x0078 }
            r4.release()     // Catch:{ all -> 0x0078 }
            monitor-exit(r4)     // Catch:{ all -> 0x0078 }
            return
        L_0x0014:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r4.cbs     // Catch:{ all -> 0x0078 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0070
            boolean r0 = r4.hasResource     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0068
            com.bumptech.glide.load.engine.EngineJob$EngineResourceFactory r0 = r4.engineResourceFactory     // Catch:{ all -> 0x0078 }
            com.bumptech.glide.load.engine.Resource<?> r1 = r4.resource     // Catch:{ all -> 0x0078 }
            boolean r2 = r4.isCacheable     // Catch:{ all -> 0x0078 }
            com.bumptech.glide.load.engine.EngineResource r0 = r0.build(r1, r2)     // Catch:{ all -> 0x0078 }
            r4.engineResource = r0     // Catch:{ all -> 0x0078 }
            r0 = 1
            r4.hasResource = r0     // Catch:{ all -> 0x0078 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r4.cbs     // Catch:{ all -> 0x0078 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r1 = r1.copy()     // Catch:{ all -> 0x0078 }
            int r2 = r1.size()     // Catch:{ all -> 0x0078 }
            int r2 = r2 + r0
            r4.incrementPendingCallbacks(r2)     // Catch:{ all -> 0x0078 }
            com.bumptech.glide.load.Key r0 = r4.key     // Catch:{ all -> 0x0078 }
            com.bumptech.glide.load.engine.EngineResource<?> r2 = r4.engineResource     // Catch:{ all -> 0x0078 }
            monitor-exit(r4)     // Catch:{ all -> 0x0078 }
            com.bumptech.glide.load.engine.EngineJobListener r3 = r4.listener
            r3.onEngineJobComplete(r4, r0, r2)
            java.util.Iterator r0 = r1.iterator()
        L_0x004b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.executor
            com.bumptech.glide.load.engine.EngineJob$CallResourceReady r3 = new com.bumptech.glide.load.engine.EngineJob$CallResourceReady
            com.bumptech.glide.request.ResourceCallback r1 = r1.cb
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x004b
        L_0x0064:
            r4.decrementPendingCallbacks()
            return
        L_0x0068:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "Already have resource"
            r0.<init>(r1)     // Catch:{ all -> 0x0078 }
            throw r0     // Catch:{ all -> 0x0078 }
        L_0x0070:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "Received a resource without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0078 }
            throw r0     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0078 }
            goto L_0x007c
        L_0x007b:
            throw r0
        L_0x007c:
            goto L_0x007b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.notifyCallbacksOfResult():void");
    }

    /* access modifiers changed from: 0000 */
    public synchronized void incrementPendingCallbacks(int i) {
        Preconditions.checkArgument(isDone(), "Not yet complete!");
        if (this.pendingCallbacks.getAndAdd(i) == 0 && this.engineResource != null) {
            this.engineResource.acquire();
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void decrementPendingCallbacks() {
        this.stateVerifier.throwIfRecycled();
        Preconditions.checkArgument(isDone(), "Not yet complete!");
        int decrementAndGet = this.pendingCallbacks.decrementAndGet();
        Preconditions.checkArgument(decrementAndGet >= 0, "Can't decrement below 0");
        if (decrementAndGet == 0) {
            if (this.engineResource != null) {
                this.engineResource.release();
            }
            release();
        }
    }

    private synchronized void release() {
        if (this.key != null) {
            this.cbs.clear();
            this.key = null;
            this.engineResource = null;
            this.resource = null;
            this.hasLoadFailed = false;
            this.isCancelled = false;
            this.hasResource = false;
            this.decodeJob.release(false);
            this.decodeJob = null;
            this.exception = null;
            this.dataSource = null;
            this.pool.release(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onResourceReady(Resource<R> resource2, DataSource dataSource2) {
        synchronized (this) {
            this.resource = resource2;
            this.dataSource = dataSource2;
        }
        notifyCallbacksOfResult();
    }

    public void onLoadFailed(GlideException glideException) {
        synchronized (this) {
            this.exception = glideException;
        }
        notifyCallbacksOfException();
    }

    public void reschedule(DecodeJob<?> decodeJob2) {
        getActiveSourceExecutor().execute(decodeJob2);
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r4.listener.onEngineJobComplete(r4, r1, null);
        r0 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (r0.hasNext() == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r0.next();
        r1.executor.execute(new com.bumptech.glide.load.engine.EngineJob.CallLoadFailed(r4, r1.cb));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0052, code lost:
        decrementPendingCallbacks();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyCallbacksOfException() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.bumptech.glide.util.pool.StateVerifier r0 = r4.stateVerifier     // Catch:{ all -> 0x0066 }
            r0.throwIfRecycled()     // Catch:{ all -> 0x0066 }
            boolean r0 = r4.isCancelled     // Catch:{ all -> 0x0066 }
            if (r0 == 0) goto L_0x000f
            r4.release()     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            return
        L_0x000f:
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r0 = r4.cbs     // Catch:{ all -> 0x0066 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x005e
            boolean r0 = r4.hasLoadFailed     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0056
            r0 = 1
            r4.hasLoadFailed = r0     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.Key r1 = r4.key     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r4.cbs     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbacksAndExecutors r2 = r2.copy()     // Catch:{ all -> 0x0066 }
            int r3 = r2.size()     // Catch:{ all -> 0x0066 }
            int r3 = r3 + r0
            r4.incrementPendingCallbacks(r3)     // Catch:{ all -> 0x0066 }
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            com.bumptech.glide.load.engine.EngineJobListener r0 = r4.listener
            r3 = 0
            r0.onEngineJobComplete(r4, r1, r3)
            java.util.Iterator r0 = r2.iterator()
        L_0x0039:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0052
            java.lang.Object r1 = r0.next()
            com.bumptech.glide.load.engine.EngineJob$ResourceCallbackAndExecutor r1 = (com.bumptech.glide.load.engine.EngineJob.ResourceCallbackAndExecutor) r1
            java.util.concurrent.Executor r2 = r1.executor
            com.bumptech.glide.load.engine.EngineJob$CallLoadFailed r3 = new com.bumptech.glide.load.engine.EngineJob$CallLoadFailed
            com.bumptech.glide.request.ResourceCallback r1 = r1.cb
            r3.<init>(r1)
            r2.execute(r3)
            goto L_0x0039
        L_0x0052:
            r4.decrementPendingCallbacks()
            return
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Already failed once"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x005e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r1 = "Received an exception without any callbacks to notify"
            r0.<init>(r1)     // Catch:{ all -> 0x0066 }
            throw r0     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0066 }
            goto L_0x006a
        L_0x0069:
            throw r0
        L_0x006a:
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.EngineJob.notifyCallbacksOfException():void");
    }

    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }
}
