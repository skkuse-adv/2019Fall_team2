package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

public interface ChildJob extends Job {
    void parentCancelled(@NotNull ParentJob parentJob);
}
