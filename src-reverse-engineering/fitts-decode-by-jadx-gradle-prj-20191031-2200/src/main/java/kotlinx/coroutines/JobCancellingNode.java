package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

public abstract class JobCancellingNode<J extends Job> extends JobNode<J> {
    public JobCancellingNode(@NotNull J j) {
        Intrinsics.checkParameterIsNotNull(j, "job");
        super(j);
    }
}
