package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ResumeOnCompletion extends JobNode<Job> {
    private final Continuation<Unit> continuation;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public ResumeOnCompletion(@NotNull Job job, @NotNull Continuation<? super Unit> continuation2) {
        Intrinsics.checkParameterIsNotNull(job, "job");
        Intrinsics.checkParameterIsNotNull(continuation2, "continuation");
        super(job);
        this.continuation = continuation2;
    }

    public void invoke(@Nullable Throwable th) {
        Continuation<Unit> continuation2 = this.continuation;
        Unit unit = Unit.INSTANCE;
        Companion companion = Result.Companion;
        continuation2.resumeWith(Result.m1constructorimpl(unit));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResumeOnCompletion[");
        sb.append(this.continuation);
        sb.append(']');
        return sb.toString();
    }
}
