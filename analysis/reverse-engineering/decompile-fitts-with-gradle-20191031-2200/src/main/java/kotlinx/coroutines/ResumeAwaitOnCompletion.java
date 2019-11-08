package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ResumeAwaitOnCompletion<T> extends JobNode<JobSupport> {
    private final AbstractContinuation<T> continuation;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public ResumeAwaitOnCompletion(@NotNull JobSupport jobSupport, @NotNull AbstractContinuation<? super T> abstractContinuation) {
        Intrinsics.checkParameterIsNotNull(jobSupport, "job");
        Intrinsics.checkParameterIsNotNull(abstractContinuation, "continuation");
        super(jobSupport);
        this.continuation = abstractContinuation;
    }

    public void invoke(@Nullable Throwable th) {
        Object state$kotlinx_coroutines_core = ((JobSupport) this.job).getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            this.continuation.resumeWithExceptionMode$kotlinx_coroutines_core(((CompletedExceptionally) state$kotlinx_coroutines_core).cause, 0);
        } else {
            AbstractContinuation<T> abstractContinuation = this.continuation;
            Companion companion = Result.Companion;
            abstractContinuation.resumeWith(Result.m1constructorimpl(state$kotlinx_coroutines_core));
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResumeAwaitOnCompletion[");
        sb.append(this.continuation);
        sb.append(']');
        return sb.toString();
    }
}
