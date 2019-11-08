package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ChildHandleNode extends JobCancellingNode<JobSupport> implements ChildHandle {
    @NotNull
    public final ChildJob childJob;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public ChildHandleNode(@NotNull JobSupport jobSupport, @NotNull ChildJob childJob2) {
        Intrinsics.checkParameterIsNotNull(jobSupport, "parent");
        Intrinsics.checkParameterIsNotNull(childJob2, "childJob");
        super(jobSupport);
        this.childJob = childJob2;
    }

    public void invoke(@Nullable Throwable th) {
        this.childJob.parentCancelled((ParentJob) this.job);
    }

    public boolean childCancelled(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "cause");
        return ((JobSupport) this.job).childCancelled(th);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChildHandle[");
        sb.append(this.childJob);
        sb.append(']');
        return sb.toString();
    }
}
