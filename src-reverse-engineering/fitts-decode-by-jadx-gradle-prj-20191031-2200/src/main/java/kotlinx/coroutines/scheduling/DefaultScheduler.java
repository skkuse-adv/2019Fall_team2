package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

public final class DefaultScheduler extends ExperimentalCoroutineDispatcher {
    public static final DefaultScheduler INSTANCE;
    @NotNull
    private static final CoroutineDispatcher IO;

    @NotNull
    public String toString() {
        return TasksKt.DEFAULT_SCHEDULER_NAME;
    }

    static {
        DefaultScheduler defaultScheduler = new DefaultScheduler();
        INSTANCE = defaultScheduler;
        IO = defaultScheduler.blocking(SystemPropsKt.systemProp$default("kotlinx.coroutines.io.parallelism", RangesKt___RangesKt.coerceAtLeast(64, SystemPropsKt.getAVAILABLE_PROCESSORS()), 0, 0, 12, (Object) null));
    }

    private DefaultScheduler() {
        super(0, 0, 3, null);
    }

    @NotNull
    public final CoroutineDispatcher getIO() {
        return IO;
    }

    public void close() {
        throw new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    }

    @NotNull
    public final String toDebugString() {
        return super.toString();
    }
}
