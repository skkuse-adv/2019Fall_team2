package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PoolThread extends Thread {
    @NotNull
    public final ThreadPoolDispatcher dispatcher;

    public PoolThread(@NotNull ThreadPoolDispatcher threadPoolDispatcher, @NotNull Runnable runnable, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(threadPoolDispatcher, "dispatcher");
        Intrinsics.checkParameterIsNotNull(runnable, "target");
        Intrinsics.checkParameterIsNotNull(str, "name");
        super(runnable, str);
        this.dispatcher = threadPoolDispatcher;
        setDaemon(true);
    }
}
