package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

public interface ChildHandle extends DisposableHandle {
    boolean childCancelled(@NotNull Throwable th);
}
