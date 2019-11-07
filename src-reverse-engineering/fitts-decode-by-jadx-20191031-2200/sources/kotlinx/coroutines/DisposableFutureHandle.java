package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final class DisposableFutureHandle implements DisposableHandle {
    private final Future<?> future;

    public DisposableFutureHandle(@NotNull Future<?> future2) {
        Intrinsics.checkParameterIsNotNull(future2, "future");
        this.future = future2;
    }

    public void dispose() {
        this.future.cancel(false);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DisposableFutureHandle[");
        sb.append(this.future);
        sb.append(']');
        return sb.toString();
    }
}
