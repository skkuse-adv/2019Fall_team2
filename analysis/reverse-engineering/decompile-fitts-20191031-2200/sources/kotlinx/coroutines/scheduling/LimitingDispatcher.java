package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements TaskContext, Executor {
    private static final AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    @NotNull
    private final ExperimentalCoroutineDispatcher dispatcher;
    private volatile int inFlightTasks = 0;
    private final int parallelism;
    private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();
    @NotNull
    private final TaskMode taskMode;

    @NotNull
    public Executor getExecutor() {
        return this;
    }

    @NotNull
    public final ExperimentalCoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final int getParallelism() {
        return this.parallelism;
    }

    @NotNull
    public TaskMode getTaskMode() {
        return this.taskMode;
    }

    public LimitingDispatcher(@NotNull ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, @NotNull TaskMode taskMode2) {
        Intrinsics.checkParameterIsNotNull(experimentalCoroutineDispatcher, "dispatcher");
        Intrinsics.checkParameterIsNotNull(taskMode2, "taskMode");
        this.dispatcher = experimentalCoroutineDispatcher;
        this.parallelism = i;
        this.taskMode = taskMode2;
    }

    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "command");
        dispatch(runnable, false);
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        dispatch(runnable, false);
    }

    private final void dispatch(Runnable runnable, boolean z) {
        while (inFlightTasks$FU.incrementAndGet(this) > this.parallelism) {
            this.queue.add(runnable);
            if (inFlightTasks$FU.decrementAndGet(this) < this.parallelism) {
                runnable = (Runnable) this.queue.poll();
                if (runnable == null) {
                    return;
                }
            } else {
                return;
            }
        }
        this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(runnable, this, z);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[dispatcher = ");
        sb.append(this.dispatcher);
        sb.append(']');
        return sb.toString();
    }

    public void afterTask() {
        Runnable runnable = (Runnable) this.queue.poll();
        if (runnable != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(runnable, this, true);
            return;
        }
        inFlightTasks$FU.decrementAndGet(this);
        Runnable runnable2 = (Runnable) this.queue.poll();
        if (runnable2 != null) {
            dispatch(runnable2, true);
        }
    }
}
