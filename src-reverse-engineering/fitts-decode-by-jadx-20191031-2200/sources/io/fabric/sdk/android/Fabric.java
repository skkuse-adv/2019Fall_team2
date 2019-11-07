package io.fabric.sdk.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;
import io.fabric.sdk.android.services.common.DataCollectionArbiter;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.PriorityThreadPoolExecutor;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class Fabric {
    static final Logger DEFAULT_LOGGER = new DefaultLogger();
    public static final String TAG = "Fabric";
    static volatile Fabric singleton;
    private WeakReference<Activity> activity;
    private ActivityLifecycleManager activityLifecycleManager;
    private final Context context;
    final boolean debuggable;
    private final ExecutorService executorService;
    private final IdManager idManager;
    /* access modifiers changed from: private */
    public final InitializationCallback<Fabric> initializationCallback;
    /* access modifiers changed from: private */
    public AtomicBoolean initialized = new AtomicBoolean(false);
    private final InitializationCallback<?> kitInitializationCallback;
    private final Map<Class<? extends Kit>, Kit> kits;
    final Logger logger;
    private final Handler mainHandler;

    public static class Builder {
        private String appIdentifier;
        private String appInstallIdentifier;
        private final Context context;
        private boolean debuggable;
        private Handler handler;
        private InitializationCallback<Fabric> initializationCallback;
        private Kit[] kits;
        private Logger logger;
        private PriorityThreadPoolExecutor threadPoolExecutor;

        @Deprecated
        public Builder executorService(ExecutorService executorService) {
            return this;
        }

        @Deprecated
        public Builder handler(Handler handler2) {
            return this;
        }

        public Builder(Context context2) {
            if (context2 != null) {
                this.context = context2;
                return;
            }
            throw new IllegalArgumentException("Context must not be null.");
        }

        public Builder kits(Kit... kitArr) {
            if (this.kits == null) {
                if (!DataCollectionArbiter.getInstance(this.context).isDataCollectionEnabled()) {
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (Kit kit : kitArr) {
                        String identifier = kit.getIdentifier();
                        char c = 65535;
                        int hashCode = identifier.hashCode();
                        if (hashCode != 607220212) {
                            if (hashCode == 1830452504 && identifier.equals("com.crashlytics.sdk.android:crashlytics")) {
                                c = 0;
                            }
                        } else if (identifier.equals("com.crashlytics.sdk.android:answers")) {
                            c = 1;
                        }
                        if (c == 0 || c == 1) {
                            arrayList.add(kit);
                        } else if (!z) {
                            Fabric.getLogger().w(Fabric.TAG, "Fabric will not initialize any kits when Firebase automatic data collection is disabled; to use Third-party kits with automatic data collection disabled, initialize these kits via non-Fabric means.");
                            z = true;
                        }
                    }
                    kitArr = (Kit[]) arrayList.toArray(new Kit[0]);
                }
                this.kits = kitArr;
                return this;
            }
            throw new IllegalStateException("Kits already set.");
        }

        public Builder threadPoolExecutor(PriorityThreadPoolExecutor priorityThreadPoolExecutor) {
            if (priorityThreadPoolExecutor == null) {
                throw new IllegalArgumentException("PriorityThreadPoolExecutor must not be null.");
            } else if (this.threadPoolExecutor == null) {
                this.threadPoolExecutor = priorityThreadPoolExecutor;
                return this;
            } else {
                throw new IllegalStateException("PriorityThreadPoolExecutor already set.");
            }
        }

        public Builder logger(Logger logger2) {
            if (logger2 == null) {
                throw new IllegalArgumentException("Logger must not be null.");
            } else if (this.logger == null) {
                this.logger = logger2;
                return this;
            } else {
                throw new IllegalStateException("Logger already set.");
            }
        }

        public Builder appIdentifier(String str) {
            if (str == null) {
                throw new IllegalArgumentException("appIdentifier must not be null.");
            } else if (this.appIdentifier == null) {
                this.appIdentifier = str;
                return this;
            } else {
                throw new IllegalStateException("appIdentifier already set.");
            }
        }

        public Builder appInstallIdentifier(String str) {
            if (str == null) {
                throw new IllegalArgumentException("appInstallIdentifier must not be null.");
            } else if (this.appInstallIdentifier == null) {
                this.appInstallIdentifier = str;
                return this;
            } else {
                throw new IllegalStateException("appInstallIdentifier already set.");
            }
        }

        public Builder debuggable(boolean z) {
            this.debuggable = z;
            return this;
        }

        public Builder initializationCallback(InitializationCallback<Fabric> initializationCallback2) {
            if (initializationCallback2 == null) {
                throw new IllegalArgumentException("initializationCallback must not be null.");
            } else if (this.initializationCallback == null) {
                this.initializationCallback = initializationCallback2;
                return this;
            } else {
                throw new IllegalStateException("initializationCallback already set.");
            }
        }

        public Fabric build() {
            Map map;
            if (this.threadPoolExecutor == null) {
                this.threadPoolExecutor = PriorityThreadPoolExecutor.create();
            }
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            if (this.logger == null) {
                if (this.debuggable) {
                    this.logger = new DefaultLogger(3);
                } else {
                    this.logger = new DefaultLogger();
                }
            }
            if (this.appIdentifier == null) {
                this.appIdentifier = this.context.getPackageName();
            }
            if (this.initializationCallback == null) {
                this.initializationCallback = InitializationCallback.EMPTY;
            }
            Kit[] kitArr = this.kits;
            if (kitArr == null) {
                map = new HashMap();
            } else {
                map = Fabric.getKitMap(Arrays.asList(kitArr));
            }
            Map map2 = map;
            Context applicationContext = this.context.getApplicationContext();
            Fabric fabric = new Fabric(applicationContext, map2, this.threadPoolExecutor, this.handler, this.logger, this.debuggable, this.initializationCallback, new IdManager(applicationContext, this.appIdentifier, this.appInstallIdentifier, map2.values()), Fabric.extractActivity(this.context));
            return fabric;
        }
    }

    public String getIdentifier() {
        return "io.fabric.sdk.android:fabric";
    }

    public String getVersion() {
        return "1.4.8.32";
    }

    static Fabric singleton() {
        if (singleton != null) {
            return singleton;
        }
        throw new IllegalStateException("Must Initialize Fabric before using singleton()");
    }

    Fabric(Context context2, Map<Class<? extends Kit>, Kit> map, PriorityThreadPoolExecutor priorityThreadPoolExecutor, Handler handler, Logger logger2, boolean z, InitializationCallback initializationCallback2, IdManager idManager2, Activity activity2) {
        this.context = context2;
        this.kits = map;
        this.executorService = priorityThreadPoolExecutor;
        this.mainHandler = handler;
        this.logger = logger2;
        this.debuggable = z;
        this.initializationCallback = initializationCallback2;
        this.kitInitializationCallback = createKitInitializationCallback(map.size());
        this.idManager = idManager2;
        setCurrentActivity(activity2);
    }

    public static Fabric with(Context context2, Kit... kitArr) {
        if (singleton == null) {
            synchronized (Fabric.class) {
                if (singleton == null) {
                    setFabric(new Builder(context2).kits(kitArr).build());
                }
            }
        }
        return singleton;
    }

    public static Fabric with(Fabric fabric) {
        if (singleton == null) {
            synchronized (Fabric.class) {
                if (singleton == null) {
                    setFabric(fabric);
                }
            }
        }
        return singleton;
    }

    private static void setFabric(Fabric fabric) {
        singleton = fabric;
        fabric.init();
    }

    public Fabric setCurrentActivity(Activity activity2) {
        this.activity = new WeakReference<>(activity2);
        return this;
    }

    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.activity;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    private void init() {
        this.activityLifecycleManager = new ActivityLifecycleManager(this.context);
        this.activityLifecycleManager.registerCallbacks(new Callbacks() {
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Fabric.this.setCurrentActivity(activity);
            }

            public void onActivityStarted(Activity activity) {
                Fabric.this.setCurrentActivity(activity);
            }

            public void onActivityResumed(Activity activity) {
                Fabric.this.setCurrentActivity(activity);
            }
        });
        initializeKits(this.context);
    }

    /* access modifiers changed from: 0000 */
    public void initializeKits(Context context2) {
        StringBuilder sb;
        Future kitsFinderFuture = getKitsFinderFuture(context2);
        Collection kits2 = getKits();
        Onboarding onboarding = new Onboarding(kitsFinderFuture, kits2);
        ArrayList<Kit> arrayList = new ArrayList<>(kits2);
        Collections.sort(arrayList);
        onboarding.injectParameters(context2, this, InitializationCallback.EMPTY, this.idManager);
        for (Kit injectParameters : arrayList) {
            injectParameters.injectParameters(context2, this, this.kitInitializationCallback, this.idManager);
        }
        onboarding.initialize();
        Logger logger2 = getLogger();
        String str = TAG;
        String str2 = " [Version: ";
        if (logger2.isLoggable(str, 3)) {
            sb = new StringBuilder("Initializing ");
            sb.append(getIdentifier());
            sb.append(str2);
            sb.append(getVersion());
            sb.append("], with the following kits:\n");
        } else {
            sb = null;
        }
        for (Kit kit : arrayList) {
            kit.initializationTask.addDependency((Task) onboarding.initializationTask);
            addAnnotatedDependencies(this.kits, kit);
            kit.initialize();
            if (sb != null) {
                sb.append(kit.getIdentifier());
                sb.append(str2);
                sb.append(kit.getVersion());
                sb.append("]\n");
            }
        }
        if (sb != null) {
            getLogger().d(str, sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public void addAnnotatedDependencies(Map<Class<? extends Kit>, Kit> map, Kit kit) {
        Class[] value;
        DependsOn dependsOn = kit.dependsOnAnnotation;
        if (dependsOn != null) {
            for (Class cls : dependsOn.value()) {
                if (cls.isInterface()) {
                    for (Kit kit2 : map.values()) {
                        if (cls.isAssignableFrom(kit2.getClass())) {
                            kit.initializationTask.addDependency((Task) kit2.initializationTask);
                        }
                    }
                } else if (((Kit) map.get(cls)) != null) {
                    kit.initializationTask.addDependency((Task) ((Kit) map.get(cls)).initializationTask);
                } else {
                    throw new UnmetDependencyException("Referenced Kit was null, does the kit exist?");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static Activity extractActivity(Context context2) {
        if (context2 instanceof Activity) {
            return (Activity) context2;
        }
        return null;
    }

    public ActivityLifecycleManager getActivityLifecycleManager() {
        return this.activityLifecycleManager;
    }

    public ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Handler getMainHandler() {
        return this.mainHandler;
    }

    public Collection<Kit> getKits() {
        return this.kits.values();
    }

    public static <T extends Kit> T getKit(Class<T> cls) {
        return (Kit) singleton().kits.get(cls);
    }

    public static Logger getLogger() {
        if (singleton == null) {
            return DEFAULT_LOGGER;
        }
        return singleton.logger;
    }

    public static boolean isDebuggable() {
        if (singleton == null) {
            return false;
        }
        return singleton.debuggable;
    }

    public static boolean isInitialized() {
        return singleton != null && singleton.initialized.get();
    }

    public String getAppIdentifier() {
        return this.idManager.getAppIdentifier();
    }

    public String getAppInstallIdentifier() {
        return this.idManager.getAppInstallIdentifier();
    }

    /* access modifiers changed from: private */
    public static Map<Class<? extends Kit>, Kit> getKitMap(Collection<? extends Kit> collection) {
        HashMap hashMap = new HashMap(collection.size());
        addToKitMap(hashMap, collection);
        return hashMap;
    }

    private static void addToKitMap(Map<Class<? extends Kit>, Kit> map, Collection<? extends Kit> collection) {
        for (Kit kit : collection) {
            map.put(kit.getClass(), kit);
            if (kit instanceof KitGroup) {
                addToKitMap(map, ((KitGroup) kit).getKits());
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public InitializationCallback<?> createKitInitializationCallback(final int i) {
        return new InitializationCallback() {
            final CountDownLatch kitInitializedLatch = new CountDownLatch(i);

            public void success(Object obj) {
                this.kitInitializedLatch.countDown();
                if (this.kitInitializedLatch.getCount() == 0) {
                    Fabric.this.initialized.set(true);
                    Fabric.this.initializationCallback.success(Fabric.this);
                }
            }

            public void failure(Exception exc) {
                Fabric.this.initializationCallback.failure(exc);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public Future<Map<String, KitInfo>> getKitsFinderFuture(Context context2) {
        return getExecutorService().submit(new FabricKitsFinder(context2.getPackageCodePath()));
    }
}
