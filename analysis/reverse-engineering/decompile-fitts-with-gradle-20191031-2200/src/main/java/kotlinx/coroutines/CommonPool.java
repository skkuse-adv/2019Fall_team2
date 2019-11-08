package kotlinx.coroutines;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class CommonPool extends ExecutorCoroutineDispatcher {
    @NotNull
    public static final String DEFAULT_PARALLELISM_PROPERTY_NAME = "kotlinx.coroutines.default.parallelism";
    public static final CommonPool INSTANCE = new CommonPool();
    private static volatile Executor pool;
    private static final int requestedParallelism;
    private static boolean usePrivatePool;

    @NotNull
    public String toString() {
        return "CommonPool";
    }

    static {
        String str;
        int i;
        try {
            str = System.getProperty(DEFAULT_PARALLELISM_PROPERTY_NAME);
        } catch (Throwable unused) {
            str = null;
        }
        if (str != null) {
            Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            if (intOrNull == null || intOrNull.intValue() < 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected positive number in kotlinx.coroutines.default.parallelism, but has ");
                sb.append(str);
                throw new IllegalStateException(sb.toString().toString());
            }
            i = intOrNull.intValue();
        } else {
            i = -1;
        }
        requestedParallelism = i;
    }

    private CommonPool() {
    }

    @NotNull
    public Executor getExecutor() {
        Executor executor = pool;
        return executor != null ? executor : getOrCreatePoolSync();
    }

    private final int getParallelism() {
        Integer valueOf = Integer.valueOf(requestedParallelism);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return RangesKt___RangesKt.coerceAtLeast(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    private final ExecutorService createPool() {
        Class cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return createPlainPool();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return createPlainPool();
        }
        if (!usePrivatePool && requestedParallelism < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object invoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(invoke instanceof ExecutorService)) {
                    invoke = null;
                }
                executorService = (ExecutorService) invoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                if (!INSTANCE.isGoodCommonPool$kotlinx_coroutines_core(cls, executorService)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object newInstance = cls.getConstructor(new Class[]{Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(INSTANCE.getParallelism())});
            if (!(newInstance instanceof ExecutorService)) {
                newInstance = null;
            }
            executorService2 = (ExecutorService) newInstance;
        } catch (Throwable unused3) {
        }
        if (executorService2 != null) {
            return executorService2;
        }
        return createPlainPool();
    }

    public final boolean isGoodCommonPool$kotlinx_coroutines_core(@NotNull Class<?> cls, @NotNull ExecutorService executorService) {
        Integer num;
        Intrinsics.checkParameterIsNotNull(cls, "fjpClass");
        Intrinsics.checkParameterIsNotNull(executorService, "executor");
        executorService.submit(CommonPool$isGoodCommonPool$1.INSTANCE);
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(invoke instanceof Integer)) {
                invoke = null;
            }
            num = (Integer) invoke;
        } catch (Throwable unused) {
            num = null;
        }
        if (num == null) {
            return false;
        }
        boolean z = true;
        if (num.intValue() < 1) {
            z = false;
        }
        return z;
    }

    private final ExecutorService createPlainPool() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(getParallelism(), new CommonPool$createPlainPool$1(new AtomicInteger()));
        Intrinsics.checkExpressionValueIsNotNull(newFixedThreadPool, "Executors.newFixedThread…Daemon = true }\n        }");
        return newFixedThreadPool;
    }

    private final synchronized Executor getOrCreatePoolSync() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = createPool();
            pool = executor;
        }
        return executor;
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = getOrCreatePoolSync();
            }
            executor.execute(TimeSourceKt.getTimeSource().wrapTask(runnable));
        } catch (RejectedExecutionException unused) {
            TimeSourceKt.getTimeSource().unTrackTask();
            DefaultExecutor.INSTANCE.execute$kotlinx_coroutines_core(runnable);
        }
    }

    public final synchronized void usePrivatePool$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0);
        usePrivatePool = true;
        pool = null;
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long j) {
        Executor executor = pool;
        if (!(executor instanceof ExecutorService)) {
            executor = null;
        }
        ExecutorService executorService = (ExecutorService) executor;
        if (executorService != null) {
            executorService.shutdown();
            if (j > 0) {
                executorService.awaitTermination(j, TimeUnit.MILLISECONDS);
            }
            List<Runnable> shutdownNow = executorService.shutdownNow();
            Intrinsics.checkExpressionValueIsNotNull(shutdownNow, "shutdownNow()");
            for (Runnable runnable : shutdownNow) {
                DefaultExecutor defaultExecutor = DefaultExecutor.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(runnable, "it");
                defaultExecutor.execute$kotlinx_coroutines_core(runnable);
            }
        }
        pool = CommonPool$shutdown$2.INSTANCE;
    }

    public final synchronized void restore$kotlinx_coroutines_core() {
        shutdown$kotlinx_coroutines_core(0);
        usePrivatePool = false;
        pool = null;
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }
}
