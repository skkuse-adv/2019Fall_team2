package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

final /* synthetic */ class JobKt__FutureKt {
    @NotNull
    public static final DisposableHandle cancelFutureOnCompletion(@NotNull Job job, @NotNull Future<?> future) {
        Intrinsics.checkParameterIsNotNull(job, "receiver$0");
        Intrinsics.checkParameterIsNotNull(future, "future");
        return job.invokeOnCompletion(new CancelFutureOnCompletion(job, future));
    }

    public static final void cancelFutureOnCancellation(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull Future<?> future) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "receiver$0");
        Intrinsics.checkParameterIsNotNull(future, "future");
        cancellableContinuation.invokeOnCancellation(new CancelFutureOnCancel(future));
    }
}
