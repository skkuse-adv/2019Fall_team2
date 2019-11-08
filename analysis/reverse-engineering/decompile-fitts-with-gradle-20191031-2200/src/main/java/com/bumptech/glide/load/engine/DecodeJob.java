package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools.Poolable;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R> implements FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, Poolable {
    private static final String TAG = "DecodeJob";
    private Callback<R> callback;
    private Key currentAttemptingKey;
    private Object currentData;
    private DataSource currentDataSource;
    private DataFetcher<?> currentFetcher;
    private volatile DataFetcherGenerator currentGenerator;
    private Key currentSourceKey;
    private Thread currentThread;
    private final DecodeHelper<R> decodeHelper = new DecodeHelper<>();
    private final DeferredEncodeManager<?> deferredEncodeManager = new DeferredEncodeManager<>();
    private final DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private volatile boolean isCallbackNotified;
    private volatile boolean isCancelled;
    private EngineKey loadKey;
    private Object model;
    private boolean onlyRetrieveFromCache;
    private Options options;
    private int order;
    private final Pool<DecodeJob<?>> pool;
    private Priority priority;
    private final ReleaseManager releaseManager = new ReleaseManager();
    private RunReason runReason;
    private Key signature;
    private Stage stage;
    private long startFetchTime;
    private final StateVerifier stateVerifier = StateVerifier.newInstance();
    private final List<Throwable> throwables = new ArrayList();
    private int width;

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1 reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$EncodeStrategy = new int[EncodeStrategy.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = new int[RunReason.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = new int[Stage.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0070 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007a */
        static {
            /*
                com.bumptech.glide.load.EncodeStrategy[] r0 = com.bumptech.glide.load.EncodeStrategy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$bumptech$glide$load$EncodeStrategy = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$bumptech$glide$load$EncodeStrategy     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.bumptech.glide.load.EncodeStrategy r2 = com.bumptech.glide.load.EncodeStrategy.SOURCE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$bumptech$glide$load$EncodeStrategy     // Catch:{ NoSuchFieldError -> 0x001f }
                com.bumptech.glide.load.EncodeStrategy r3 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                com.bumptech.glide.load.engine.DecodeJob$Stage[] r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = r2
                int[] r2 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r2 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x003c }
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x003c }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                r2 = 3
                int[] r3 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r3 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r3 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x005d }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x005d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                com.bumptech.glide.load.engine.DecodeJob$RunReason[] r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = r3
                int[] r3 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason     // Catch:{ NoSuchFieldError -> 0x0070 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r4 = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0070 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0070 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0070 }
            L_0x0070:
                int[] r0 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason     // Catch:{ NoSuchFieldError -> 0x007a }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x007a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r0 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r1 = com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.<clinit>():void");
        }
    }

    interface Callback<R> {
        void onLoadFailed(GlideException glideException);

        void onResourceReady(Resource<R> resource, DataSource dataSource);

        void reschedule(DecodeJob<?> decodeJob);
    }

    private final class DecodeCallback<Z> implements DecodeCallback<Z> {
        private final DataSource dataSource;

        DecodeCallback(DataSource dataSource2) {
            this.dataSource = dataSource2;
        }

        @NonNull
        public Resource<Z> onResourceDecoded(@NonNull Resource<Z> resource) {
            return DecodeJob.this.onResourceDecoded(this.dataSource, resource);
        }
    }

    private static class DeferredEncodeManager<Z> {
        private ResourceEncoder<Z> encoder;
        private Key key;
        private LockedResource<Z> toEncode;

        DeferredEncodeManager() {
        }

        /* access modifiers changed from: 0000 */
        public <X> void init(Key key2, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.key = key2;
            this.encoder = resourceEncoder;
            this.toEncode = lockedResource;
        }

        /* access modifiers changed from: 0000 */
        public void encode(DiskCacheProvider diskCacheProvider, Options options) {
            GlideTrace.beginSection("DecodeJob.encode");
            try {
                diskCacheProvider.getDiskCache().put(this.key, new DataCacheWriter(this.encoder, this.toEncode, options));
            } finally {
                this.toEncode.unlock();
                GlideTrace.endSection();
            }
        }

        /* access modifiers changed from: 0000 */
        public boolean hasResourceToEncode() {
            return this.toEncode != null;
        }

        /* access modifiers changed from: 0000 */
        public void clear() {
            this.key = null;
            this.encoder = null;
            this.toEncode = null;
        }
    }

    interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    private static class ReleaseManager {
        private boolean isEncodeComplete;
        private boolean isFailed;
        private boolean isReleased;

        ReleaseManager() {
        }

        /* access modifiers changed from: 0000 */
        public synchronized boolean release(boolean z) {
            this.isReleased = true;
            return isComplete(z);
        }

        /* access modifiers changed from: 0000 */
        public synchronized boolean onEncodeComplete() {
            this.isEncodeComplete = true;
            return isComplete(false);
        }

        /* access modifiers changed from: 0000 */
        public synchronized boolean onFailed() {
            this.isFailed = true;
            return isComplete(false);
        }

        /* access modifiers changed from: 0000 */
        public synchronized void reset() {
            this.isEncodeComplete = false;
            this.isReleased = false;
            this.isFailed = false;
        }

        private boolean isComplete(boolean z) {
            return (this.isFailed || z || this.isEncodeComplete) && this.isReleased;
        }
    }

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    DecodeJob(DiskCacheProvider diskCacheProvider2, Pool<DecodeJob<?>> pool2) {
        this.diskCacheProvider = diskCacheProvider2;
        this.pool = pool2;
    }

    /* access modifiers changed from: 0000 */
    public DecodeJob<R> init(GlideContext glideContext2, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority2, DiskCacheStrategy diskCacheStrategy2, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options2, Callback<R> callback2, int i3) {
        this.decodeHelper.init(glideContext2, obj, key, i, i2, diskCacheStrategy2, cls, cls2, priority2, options2, map, z, z2, this.diskCacheProvider);
        this.glideContext = glideContext2;
        this.signature = key;
        this.priority = priority2;
        this.loadKey = engineKey;
        this.width = i;
        this.height = i2;
        this.diskCacheStrategy = diskCacheStrategy2;
        this.onlyRetrieveFromCache = z3;
        this.options = options2;
        this.callback = callback2;
        this.order = i3;
        this.runReason = RunReason.INITIALIZE;
        this.model = obj;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public boolean willDecodeFromCache() {
        Stage nextStage = getNextStage(Stage.INITIALIZE);
        return nextStage == Stage.RESOURCE_CACHE || nextStage == Stage.DATA_CACHE;
    }

    /* access modifiers changed from: 0000 */
    public void release(boolean z) {
        if (this.releaseManager.release(z)) {
            releaseInternal();
        }
    }

    private void onEncodeComplete() {
        if (this.releaseManager.onEncodeComplete()) {
            releaseInternal();
        }
    }

    private void onLoadFailed() {
        if (this.releaseManager.onFailed()) {
            releaseInternal();
        }
    }

    private void releaseInternal() {
        this.releaseManager.reset();
        this.deferredEncodeManager.clear();
        this.decodeHelper.clear();
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0;
        this.isCancelled = false;
        this.model = null;
        this.throwables.clear();
        this.pool.release(this);
    }

    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int priority2 = getPriority() - decodeJob.getPriority();
        return priority2 == 0 ? this.order - decodeJob.order : priority2;
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    public void cancel() {
        this.isCancelled = true;
        DataFetcherGenerator dataFetcherGenerator = this.currentGenerator;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    public void run() {
        GlideTrace.beginSectionFormat("DecodeJob#run(model=%s)", this.model);
        DataFetcher<?> dataFetcher = this.currentFetcher;
        try {
            if (this.isCancelled) {
                notifyFailed();
                if (dataFetcher != null) {
                    dataFetcher.cleanup();
                }
                GlideTrace.endSection();
                return;
            }
            runWrapped();
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            GlideTrace.endSection();
        } catch (CallbackException e) {
            throw e;
        } catch (Throwable th) {
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            GlideTrace.endSection();
            throw th;
        }
    }

    private void runWrapped() {
        int i = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[this.runReason.ordinal()];
        if (i == 1) {
            this.stage = getNextStage(Stage.INITIALIZE);
            this.currentGenerator = getNextGenerator();
            runGenerators();
        } else if (i == 2) {
            runGenerators();
        } else if (i == 3) {
            decodeFromRetrievedData();
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized run reason: ");
            sb.append(this.runReason);
            throw new IllegalStateException(sb.toString());
        }
    }

    private DataFetcherGenerator getNextGenerator() {
        int i = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[this.stage.ordinal()];
        if (i == 1) {
            return new ResourceCacheGenerator(this.decodeHelper, this);
        }
        if (i == 2) {
            return new DataCacheGenerator(this.decodeHelper, this);
        }
        if (i == 3) {
            return new SourceGenerator(this.decodeHelper, this);
        }
        if (i == 4) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized stage: ");
        sb.append(this.stage);
        throw new IllegalStateException(sb.toString());
    }

    private void runGenerators() {
        this.currentThread = Thread.currentThread();
        this.startFetchTime = LogTime.getLogTime();
        boolean z = false;
        while (!this.isCancelled && this.currentGenerator != null) {
            z = this.currentGenerator.startNext();
            if (z) {
                break;
            }
            this.stage = getNextStage(this.stage);
            this.currentGenerator = getNextGenerator();
            if (this.stage == Stage.SOURCE) {
                reschedule();
                return;
            }
        }
        if ((this.stage == Stage.FINISHED || this.isCancelled) && !z) {
            notifyFailed();
        }
    }

    private void notifyFailed() {
        setNotifiedOrThrow();
        this.callback.onLoadFailed(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList<Throwable>(this.throwables)));
        onLoadFailed();
    }

    private void notifyComplete(Resource<R> resource, DataSource dataSource) {
        setNotifiedOrThrow();
        this.callback.onResourceReady(resource, dataSource);
    }

    private void setNotifiedOrThrow() {
        Throwable th;
        this.stateVerifier.throwIfRecycled();
        if (this.isCallbackNotified) {
            if (this.throwables.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.throwables;
                th = (Throwable) list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.isCallbackNotified = true;
    }

    private Stage getNextStage(Stage stage2) {
        Stage stage3;
        int i = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[stage2.ordinal()];
        if (i == 1) {
            return this.diskCacheStrategy.decodeCachedData() ? Stage.DATA_CACHE : getNextStage(Stage.DATA_CACHE);
        } else if (i == 2) {
            return this.onlyRetrieveFromCache ? Stage.FINISHED : Stage.SOURCE;
        } else if (i == 3 || i == 4) {
            return Stage.FINISHED;
        } else {
            if (i == 5) {
                if (this.diskCacheStrategy.decodeCachedResource()) {
                    stage3 = Stage.RESOURCE_CACHE;
                } else {
                    stage3 = getNextStage(Stage.RESOURCE_CACHE);
                }
                return stage3;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized stage: ");
            sb.append(stage2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public void reschedule() {
        this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.callback.reschedule(this);
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.currentSourceKey = key;
        this.currentData = obj;
        this.currentFetcher = dataFetcher;
        this.currentDataSource = dataSource;
        this.currentAttemptingKey = key2;
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.DECODE_DATA;
            this.callback.reschedule(this);
            return;
        }
        GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
        try {
            decodeFromRetrievedData();
        } finally {
            GlideTrace.endSection();
        }
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.getDataClass());
        this.throwables.add(glideException);
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.callback.reschedule(this);
            return;
        }
        runGenerators();
    }

    private void decodeFromRetrievedData() {
        if (Log.isLoggable(TAG, 2)) {
            long j = this.startFetchTime;
            StringBuilder sb = new StringBuilder();
            sb.append("data: ");
            sb.append(this.currentData);
            sb.append(", cache key: ");
            sb.append(this.currentSourceKey);
            sb.append(", fetcher: ");
            sb.append(this.currentFetcher);
            logWithTimeAndKey("Retrieved data", j, sb.toString());
        }
        Resource resource = null;
        try {
            resource = decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);
        } catch (GlideException e) {
            e.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
            this.throwables.add(e);
        }
        if (resource != null) {
            notifyEncodeAndRelease(resource, this.currentDataSource);
        } else {
            runGenerators();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r3v1, types: [com.bumptech.glide.load.engine.Resource] */
    /* JADX WARNING: type inference failed for: r3v7, types: [com.bumptech.glide.load.engine.LockedResource] */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void notifyEncodeAndRelease(com.bumptech.glide.load.engine.Resource<R> r3, com.bumptech.glide.load.DataSource r4) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof com.bumptech.glide.load.engine.Initializable
            if (r0 == 0) goto L_0x000a
            r0 = r3
            com.bumptech.glide.load.engine.Initializable r0 = (com.bumptech.glide.load.engine.Initializable) r0
            r0.initialize()
        L_0x000a:
            r0 = 0
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager<?> r1 = r2.deferredEncodeManager
            boolean r1 = r1.hasResourceToEncode()
            if (r1 == 0) goto L_0x0018
            com.bumptech.glide.load.engine.LockedResource r3 = com.bumptech.glide.load.engine.LockedResource.obtain(r3)
            r0 = r3
        L_0x0018:
            r2.notifyComplete(r3, r4)
            com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.ENCODE
            r2.stage = r3
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager<?> r3 = r2.deferredEncodeManager     // Catch:{ all -> 0x0039 }
            boolean r3 = r3.hasResourceToEncode()     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x0030
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager<?> r3 = r2.deferredEncodeManager     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider r4 = r2.diskCacheProvider     // Catch:{ all -> 0x0039 }
            com.bumptech.glide.load.Options r1 = r2.options     // Catch:{ all -> 0x0039 }
            r3.encode(r4, r1)     // Catch:{ all -> 0x0039 }
        L_0x0030:
            if (r0 == 0) goto L_0x0035
            r0.unlock()
        L_0x0035:
            r2.onEncodeComplete()
            return
        L_0x0039:
            r3 = move-exception
            if (r0 == 0) goto L_0x003f
            r0.unlock()
        L_0x003f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.notifyEncodeAndRelease(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource):void");
    }

    private <Data> Resource<R> decodeFromData(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.cleanup();
            return null;
        }
        try {
            long logTime = LogTime.getLogTime();
            Resource<R> decodeFromFetcher = decodeFromFetcher(data, dataSource);
            if (Log.isLoggable(TAG, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Decoded result ");
                sb.append(decodeFromFetcher);
                logWithTimeAndKey(sb.toString(), logTime);
            }
            return decodeFromFetcher;
        } finally {
            dataFetcher.cleanup();
        }
    }

    private <Data> Resource<R> decodeFromFetcher(Data data, DataSource dataSource) throws GlideException {
        return runLoadPath(data, dataSource, this.decodeHelper.getLoadPath(data.getClass()));
    }

    @NonNull
    private Options getOptionsWithHardwareConfig(DataSource dataSource) {
        Options options2 = this.options;
        if (VERSION.SDK_INT < 26) {
            return options2;
        }
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.decodeHelper.isScaleOnlyOrNoTransform();
        Boolean bool = (Boolean) options2.get(Downsampler.ALLOW_HARDWARE_CONFIG);
        if (bool != null && (!bool.booleanValue() || z)) {
            return options2;
        }
        Options options3 = new Options();
        options3.putAll(this.options);
        options3.set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.valueOf(z));
        return options3;
    }

    private <Data, ResourceType> Resource<R> runLoadPath(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options optionsWithHardwareConfig = getOptionsWithHardwareConfig(dataSource);
        DataRewinder rewinder = this.glideContext.getRegistry().getRewinder(data);
        try {
            return loadPath.load(rewinder, optionsWithHardwareConfig, this.width, this.height, new DecodeCallback(dataSource));
        } finally {
            rewinder.cleanup();
        }
    }

    private void logWithTimeAndKey(String str, long j) {
        logWithTimeAndKey(str, j, null);
    }

    private void logWithTimeAndKey(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.getElapsedMillis(j));
        sb.append(", load key: ");
        sb.append(this.loadKey);
        if (str2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(", ");
            sb2.append(str2);
            str3 = sb2.toString();
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        sb.toString();
    }

    @NonNull
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    /* JADX WARNING: type inference failed for: r12v6, types: [com.bumptech.glide.load.engine.DataCacheKey] */
    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Z> com.bumptech.glide.load.engine.Resource<Z> onResourceDecoded(com.bumptech.glide.load.DataSource r12, @androidx.annotation.NonNull com.bumptech.glide.load.engine.Resource<Z> r13) {
        /*
            r11 = this;
            java.lang.Object r0 = r13.get()
            java.lang.Class r8 = r0.getClass()
            com.bumptech.glide.load.DataSource r0 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
            r1 = 0
            if (r12 == r0) goto L_0x0020
            com.bumptech.glide.load.engine.DecodeHelper<R> r0 = r11.decodeHelper
            com.bumptech.glide.load.Transformation r0 = r0.getTransformation(r8)
            com.bumptech.glide.GlideContext r2 = r11.glideContext
            int r3 = r11.width
            int r4 = r11.height
            com.bumptech.glide.load.engine.Resource r2 = r0.transform(r2, r13, r3, r4)
            r7 = r0
            r0 = r2
            goto L_0x0022
        L_0x0020:
            r0 = r13
            r7 = r1
        L_0x0022:
            boolean r2 = r13.equals(r0)
            if (r2 != 0) goto L_0x002b
            r13.recycle()
        L_0x002b:
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r11.decodeHelper
            boolean r13 = r13.isResourceEncoderAvailable(r0)
            if (r13 == 0) goto L_0x0040
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r11.decodeHelper
            com.bumptech.glide.load.ResourceEncoder r1 = r13.getResultEncoder(r0)
            com.bumptech.glide.load.Options r13 = r11.options
            com.bumptech.glide.load.EncodeStrategy r13 = r1.getEncodeStrategy(r13)
            goto L_0x0042
        L_0x0040:
            com.bumptech.glide.load.EncodeStrategy r13 = com.bumptech.glide.load.EncodeStrategy.NONE
        L_0x0042:
            r10 = r1
            com.bumptech.glide.load.engine.DecodeHelper<R> r1 = r11.decodeHelper
            com.bumptech.glide.load.Key r2 = r11.currentSourceKey
            boolean r1 = r1.isSourceKey(r2)
            r2 = 1
            r1 = r1 ^ r2
            com.bumptech.glide.load.engine.DiskCacheStrategy r3 = r11.diskCacheStrategy
            boolean r12 = r3.isResourceCacheable(r1, r12, r13)
            if (r12 == 0) goto L_0x00b3
            if (r10 == 0) goto L_0x00a5
            int[] r12 = com.bumptech.glide.load.engine.DecodeJob.AnonymousClass1.$SwitchMap$com$bumptech$glide$load$EncodeStrategy
            int r1 = r13.ordinal()
            r12 = r12[r1]
            if (r12 == r2) goto L_0x0092
            r1 = 2
            if (r12 != r1) goto L_0x007b
            com.bumptech.glide.load.engine.ResourceCacheKey r12 = new com.bumptech.glide.load.engine.ResourceCacheKey
            com.bumptech.glide.load.engine.DecodeHelper<R> r13 = r11.decodeHelper
            com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r2 = r13.getArrayPool()
            com.bumptech.glide.load.Key r3 = r11.currentSourceKey
            com.bumptech.glide.load.Key r4 = r11.signature
            int r5 = r11.width
            int r6 = r11.height
            com.bumptech.glide.load.Options r9 = r11.options
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x009b
        L_0x007b:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown strategy: "
            r0.append(r1)
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0092:
            com.bumptech.glide.load.engine.DataCacheKey r12 = new com.bumptech.glide.load.engine.DataCacheKey
            com.bumptech.glide.load.Key r13 = r11.currentSourceKey
            com.bumptech.glide.load.Key r1 = r11.signature
            r12.<init>(r13, r1)
        L_0x009b:
            com.bumptech.glide.load.engine.LockedResource r0 = com.bumptech.glide.load.engine.LockedResource.obtain(r0)
            com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager<?> r13 = r11.deferredEncodeManager
            r13.init(r12, r10, r0)
            goto L_0x00b3
        L_0x00a5:
            com.bumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
            java.lang.Object r13 = r0.get()
            java.lang.Class r13 = r13.getClass()
            r12.<init>(r13)
            throw r12
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.onResourceDecoded(com.bumptech.glide.load.DataSource, com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource");
    }
}
