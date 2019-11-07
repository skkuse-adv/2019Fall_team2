package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ChildContinuation extends JobCancellingNode<Job> {
    @NotNull
    public final AbstractContinuation<?> child;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public ChildContinuation(@NotNull Job job, @NotNull AbstractContinuation<?> abstractContinuation) {
        Intrinsics.checkParameterIsNotNull(job, "parent");
        Intrinsics.checkParameterIsNotNull(abstractContinuation, "child");
        super(job);
        this.child = abstractContinuation;
    }

    public void invoke(@Nullable Throwable th) {
        AbstractContinuation<?> abstractContinuation = this.child;
        abstractContinuation.cancelImpl(abstractContinuation.getContinuationCancellationCause(this.job));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChildContinuation[");
        sb.append(this.child);
        sb.append(']');
        return sb.toString();
    }
}
