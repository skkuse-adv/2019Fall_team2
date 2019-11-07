package kotlinx.coroutines.scheduling;

import org.jetbrains.annotations.NotNull;

public interface TaskContext {
    void afterTask();

    @NotNull
    TaskMode getTaskMode();
}
