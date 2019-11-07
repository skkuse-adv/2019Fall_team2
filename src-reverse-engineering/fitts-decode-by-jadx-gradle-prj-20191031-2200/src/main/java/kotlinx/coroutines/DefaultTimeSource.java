package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class DefaultTimeSource implements TimeSource {
    public static final DefaultTimeSource INSTANCE = new DefaultTimeSource();

    public void registerTimeLoopThread() {
    }

    public void trackTask() {
    }

    public void unTrackTask() {
    }

    public void unregisterTimeLoopThread() {
    }

    @NotNull
    public Runnable wrapTask(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        return runnable;
    }

    private DefaultTimeSource() {
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long nanoTime() {
        return System.nanoTime();
    }

    public void parkNanos(@NotNull Object obj, long j) {
        Intrinsics.checkParameterIsNotNull(obj, "blocker");
        LockSupport.parkNanos(obj, j);
    }

    public void unpark(@NotNull Thread thread) {
        Intrinsics.checkParameterIsNotNull(thread, "thread");
        LockSupport.unpark(thread);
    }
}
