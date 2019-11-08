package kotlinx.coroutines.scheduling;

import org.jetbrains.annotations.NotNull;

public final class NonBlockingContext implements TaskContext {
    public static final NonBlockingContext INSTANCE = new NonBlockingContext();
    @NotNull
    private static final TaskMode taskMode = TaskMode.NON_BLOCKING;

    public void afterTask() {
    }

    private NonBlockingContext() {
    }

    @NotNull
    public TaskMode getTaskMode() {
        return taskMode;
    }
}
