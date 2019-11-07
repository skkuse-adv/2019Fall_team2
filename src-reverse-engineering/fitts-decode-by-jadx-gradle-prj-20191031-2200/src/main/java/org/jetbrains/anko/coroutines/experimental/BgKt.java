package org.jetbrains.anko.coroutines.experimental;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import org.jetbrains.annotations.NotNull;

public final class BgKt {
    @NotNull
    private static ExecutorCoroutineDispatcher POOL = ThreadPoolDispatcherKt.newFixedThreadPoolContext(Runtime.getRuntime().availableProcessors() * 2, "bg");

    public static /* synthetic */ void POOL$annotations() {
    }

    @NotNull
    public static final ExecutorCoroutineDispatcher getPOOL() {
        return POOL;
    }

    public static final void setPOOL(@NotNull ExecutorCoroutineDispatcher executorCoroutineDispatcher) {
        Intrinsics.checkParameterIsNotNull(executorCoroutineDispatcher, "<set-?>");
        POOL = executorCoroutineDispatcher;
    }

    @NotNull
    public static final <T> Deferred<T> bg(@NotNull Function0<? extends T> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "block");
        return BuildersKt.async(GlobalScope.INSTANCE, getPOOL(), CoroutineStart.DEFAULT, new BgKt$bg$1(function0, null));
    }
}
