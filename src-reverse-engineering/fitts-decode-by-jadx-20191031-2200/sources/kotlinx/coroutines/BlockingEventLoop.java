package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class BlockingEventLoop extends ThreadEventLoop {
    private volatile boolean isCompleted;

    public BlockingEventLoop(@NotNull Thread thread) {
        Intrinsics.checkParameterIsNotNull(thread, "thread");
        super(thread);
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void setCompleted(boolean z) {
        this.isCompleted = z;
    }
}
