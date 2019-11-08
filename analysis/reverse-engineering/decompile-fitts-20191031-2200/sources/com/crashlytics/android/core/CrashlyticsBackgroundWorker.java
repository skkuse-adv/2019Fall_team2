package com.crashlytics.android.core;

import android.os.Looper;
import io.fabric.sdk.android.Fabric;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class CrashlyticsBackgroundWorker {
    private final ExecutorService executorService;

    public CrashlyticsBackgroundWorker(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    /* access modifiers changed from: 0000 */
    public <T> T submitAndWait(Callable<T> callable) {
        String str = CrashlyticsCore.TAG;
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.executorService.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.executorService.submit(callable).get();
        } catch (RejectedExecutionException unused) {
            Fabric.getLogger().d(str, "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Exception e) {
            Fabric.getLogger().e(str, "Failed to execute task.", e);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public Future<?> submit(final Runnable runnable) {
        try {
            return this.executorService.submit(new Runnable() {
                public void run() {
                    try {
                        runnable.run();
                    } catch (Exception e) {
                        Fabric.getLogger().e(CrashlyticsCore.TAG, "Failed to execute task.", e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public <T> Future<T> submit(final Callable<T> callable) {
        try {
            return this.executorService.submit(new Callable<T>() {
                public T call() throws Exception {
                    try {
                        return callable.call();
                    } catch (Exception e) {
                        Fabric.getLogger().e(CrashlyticsCore.TAG, "Failed to execute task.", e);
                        return null;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            Fabric.getLogger().d(CrashlyticsCore.TAG, "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
