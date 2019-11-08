package io.fabric.sdk.android.services.common;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryPolicy;
import io.fabric.sdk.android.services.concurrency.internal.RetryThreadPoolExecutor;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class ExecutorUtils {
    public static ExecutorService buildSingleThreadExecutorService(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(getNamedThreadFactory(str));
        addDelayedShutdownHook(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    public static RetryThreadPoolExecutor buildRetryThreadPoolExecutor(String str, int i, RetryPolicy retryPolicy, Backoff backoff) {
        RetryThreadPoolExecutor retryThreadPoolExecutor = new RetryThreadPoolExecutor(i, getNamedThreadFactory(str), retryPolicy, backoff);
        addDelayedShutdownHook(str, retryThreadPoolExecutor);
        return retryThreadPoolExecutor;
    }

    public static ScheduledExecutorService buildSingleThreadScheduledExecutorService(String str) {
        ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(getNamedThreadFactory(str));
        addDelayedShutdownHook(str, newSingleThreadScheduledExecutor);
        return newSingleThreadScheduledExecutor;
    }

    public static final ThreadFactory getNamedThreadFactory(final String str) {
        final AtomicLong atomicLong = new AtomicLong(1);
        return new ThreadFactory() {
            public Thread newThread(final Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable(this) {
                    public void onRun() {
                        runnable.run();
                    }
                });
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(atomicLong.getAndIncrement());
                newThread.setName(sb.toString());
                return newThread;
            }
        };
    }

    private static final void addDelayedShutdownHook(String str, ExecutorService executorService) {
        addDelayedShutdownHook(str, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void addDelayedShutdownHook(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime runtime = Runtime.getRuntime();
        final String str2 = str;
        final ExecutorService executorService2 = executorService;
        final long j2 = j;
        final TimeUnit timeUnit2 = timeUnit;
        AnonymousClass2 r2 = new BackgroundPriorityRunnable() {
            public void onRun() {
                String str = Fabric.TAG;
                try {
                    Logger logger = Fabric.getLogger();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Executing shutdown hook for ");
                    sb.append(str2);
                    logger.d(str, sb.toString());
                    executorService2.shutdown();
                    if (!executorService2.awaitTermination(j2, timeUnit2)) {
                        Logger logger2 = Fabric.getLogger();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append(" did not shut down in the allocated time. Requesting immediate shutdown.");
                        logger2.d(str, sb2.toString());
                        executorService2.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    Fabric.getLogger().d(str, String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[]{str2}));
                    executorService2.shutdownNow();
                }
            }
        };
        StringBuilder sb = new StringBuilder();
        sb.append("Crashlytics Shutdown Hook for ");
        sb.append(str);
        runtime.addShutdownHook(new Thread(r2, sb.toString()));
    }
}
