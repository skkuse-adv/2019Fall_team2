package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

public interface ParentJob extends Job {
    @NotNull
    Throwable getChildJobCancellationCause();
}
