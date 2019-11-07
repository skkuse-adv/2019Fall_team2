package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class CancelFutureOnCompletion extends JobNode<Job> {
    private final Future<?> future;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public CancelFutureOnCompletion(@NotNull Job job, @NotNull Future<?> future2) {
        Intrinsics.checkParameterIsNotNull(job, "job");
        Intrinsics.checkParameterIsNotNull(future2, "future");
        super(job);
        this.future = future2;
    }

    public void invoke(@Nullable Throwable th) {
        this.future.cancel(false);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CancelFutureOnCompletion[");
        sb.append(this.future);
        sb.append(']');
        return sb.toString();
    }
}
