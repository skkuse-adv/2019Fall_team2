package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

public interface TimeSource {
    long currentTimeMillis();

    long nanoTime();

    void parkNanos(@NotNull Object obj, long j);

    void registerTimeLoopThread();

    void trackTask();

    void unTrackTask();

    void unpark(@NotNull Thread thread);

    void unregisterTimeLoopThread();

    @NotNull
    Runnable wrapTask(@NotNull Runnable runnable);
}
