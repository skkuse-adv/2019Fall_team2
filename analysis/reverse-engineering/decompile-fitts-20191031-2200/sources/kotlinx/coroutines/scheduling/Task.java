package kotlinx.coroutines.scheduling;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.LockFreeMPMCQueueNode;
import org.jetbrains.annotations.NotNull;

public final class Task extends LockFreeMPMCQueueNode<Task> implements Runnable {
    @NotNull
    public final Runnable block;
    public final long submissionTime;
    @NotNull
    public final TaskContext taskContext;

    public Task(@NotNull Runnable runnable, long j, @NotNull TaskContext taskContext2) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        Intrinsics.checkParameterIsNotNull(taskContext2, "taskContext");
        this.block = runnable;
        this.submissionTime = j;
        this.taskContext = taskContext2;
    }

    @NotNull
    public final TaskMode getMode() {
        return this.taskContext.getTaskMode();
    }

    public void run() {
        try {
            this.block.run();
        } finally {
            this.taskContext.afterTask();
        }
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task[");
        sb.append(DebugKt.getClassSimpleName(this.block));
        sb.append('@');
        sb.append(DebugKt.getHexAddress(this.block));
        String str = ", ";
        sb.append(str);
        sb.append(this.submissionTime);
        sb.append(str);
        sb.append(this.taskContext);
        sb.append(']');
        return sb.toString();
    }
}
