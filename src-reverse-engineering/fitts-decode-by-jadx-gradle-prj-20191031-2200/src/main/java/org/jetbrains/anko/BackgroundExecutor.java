package org.jetbrains.anko;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class BackgroundExecutor {
    public static final BackgroundExecutor INSTANCE = new BackgroundExecutor();
    @NotNull
    private static ExecutorService executor;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);
        Intrinsics.checkExpressionValueIsNotNull(newScheduledThreadPool, "Executors.newScheduledTh…().availableProcessors())");
        executor = newScheduledThreadPool;
    }

    private BackgroundExecutor() {
    }

    @NotNull
    public final ExecutorService getExecutor() {
        return executor;
    }

    public final void setExecutor(@NotNull ExecutorService executorService) {
        Intrinsics.checkParameterIsNotNull(executorService, "<set-?>");
        executor = executorService;
    }

    @NotNull
    public final <T> Future<T> submit(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "task");
        Future<T> submit = executor.submit(new AsyncKt$sam$java_util_concurrent_Callable$0(function0));
        Intrinsics.checkExpressionValueIsNotNull(submit, "executor.submit(task)");
        return submit;
    }
}
