package com.bumptech.glide.load.engine;

import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class ActiveResources {
    @VisibleForTesting
    final Map<Key, ResourceWeakReference> activeEngineResources;
    @Nullable
    private volatile DequeuedResourceCallback cb;
    private final boolean isActiveResourceRetentionAllowed;
    private volatile boolean isShutdown;
    private ResourceListener listener;
    private final Executor monitorClearedResourcesExecutor;
    private final ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    @VisibleForTesting
    interface DequeuedResourceCallback {
        void onResourceDequeued();
    }

    @VisibleForTesting
    static final class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        final boolean isCacheable;
        final Key key;
        @Nullable
        Resource<?> resource;

        ResourceWeakReference(@NonNull Key key2, @NonNull EngineResource<?> engineResource, @NonNull ReferenceQueue<? super EngineResource<?>> referenceQueue, boolean z) {
            super(engineResource, referenceQueue);
            this.key = (Key) Preconditions.checkNotNull(key2);
            this.resource = (!engineResource.isCacheable() || !z) ? null : (Resource) Preconditions.checkNotNull(engineResource.getResource());
            this.isCacheable = engineResource.isCacheable();
        }

        /* access modifiers changed from: 0000 */
        public void reset() {
            this.resource = null;
            clear();
        }
    }

    ActiveResources(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactory() {
            public Thread newThread(@NonNull final Runnable runnable) {
                return new Thread(new Runnable() {
                    public void run() {
                        Process.setThreadPriority(10);
                        runnable.run();
                    }
                }, "glide-active-resources");
            }
        }));
    }

    @VisibleForTesting
    ActiveResources(boolean z, Executor executor) {
        this.activeEngineResources = new HashMap();
        this.resourceReferenceQueue = new ReferenceQueue<>();
        this.isActiveResourceRetentionAllowed = z;
        this.monitorClearedResourcesExecutor = executor;
        executor.execute(new Runnable() {
            public void run() {
                ActiveResources.this.cleanReferenceQueue();
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void setListener(ResourceListener resourceListener) {
        synchronized (resourceListener) {
            synchronized (this) {
                this.listener = resourceListener;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void activate(Key key, EngineResource<?> engineResource) {
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.activeEngineResources.put(key, new ResourceWeakReference(key, engineResource, this.resourceReferenceQueue, this.isActiveResourceRetentionAllowed));
        if (resourceWeakReference != null) {
            resourceWeakReference.reset();
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void deactivate(Key key) {
        ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.activeEngineResources.remove(key);
        if (resourceWeakReference != null) {
            resourceWeakReference.reset();
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return r0;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.bumptech.glide.load.engine.EngineResource<?> get(com.bumptech.glide.load.Key r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.ActiveResources$ResourceWeakReference> r0 = r1.activeEngineResources     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.ActiveResources$ResourceWeakReference r2 = (com.bumptech.glide.load.engine.ActiveResources.ResourceWeakReference) r2     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x000e
            r2 = 0
            monitor-exit(r1)
            return r2
        L_0x000e:
            java.lang.Object r0 = r2.get()     // Catch:{ all -> 0x001b }
            com.bumptech.glide.load.engine.EngineResource r0 = (com.bumptech.glide.load.engine.EngineResource) r0     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0019
            r1.cleanupActiveReference(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return r0
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.ActiveResources.get(com.bumptech.glide.load.Key):com.bumptech.glide.load.engine.EngineResource");
    }

    /* access modifiers changed from: 0000 */
    public void cleanupActiveReference(@NonNull ResourceWeakReference resourceWeakReference) {
        synchronized (this.listener) {
            synchronized (this) {
                this.activeEngineResources.remove(resourceWeakReference.key);
                if (resourceWeakReference.isCacheable) {
                    if (resourceWeakReference.resource != null) {
                        EngineResource engineResource = new EngineResource(resourceWeakReference.resource, true, false);
                        engineResource.setResourceListener(resourceWeakReference.key, this.listener);
                        this.listener.onResourceReleased(resourceWeakReference.key, engineResource);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void cleanReferenceQueue() {
        while (!this.isShutdown) {
            try {
                cleanupActiveReference((ResourceWeakReference) this.resourceReferenceQueue.remove());
                DequeuedResourceCallback dequeuedResourceCallback = this.cb;
                if (dequeuedResourceCallback != null) {
                    dequeuedResourceCallback.onResourceDequeued();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public void setDequeuedResourceCallback(DequeuedResourceCallback dequeuedResourceCallback) {
        this.cb = dequeuedResourceCallback;
    }

    /* access modifiers changed from: 0000 */
    @VisibleForTesting
    public void shutdown() {
        this.isShutdown = true;
        Executor executor = this.monitorClearedResourcesExecutor;
        if (executor instanceof ExecutorService) {
            com.bumptech.glide.util.Executors.shutdownAndAwaitTermination((ExecutorService) executor);
        }
    }
}
