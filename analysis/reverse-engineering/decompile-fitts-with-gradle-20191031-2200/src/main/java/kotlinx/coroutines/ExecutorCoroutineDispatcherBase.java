package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Delay.DefaultImpls;
import kotlinx.coroutines.internal.ConcurrentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ExecutorCoroutineDispatcherBase extends ExecutorCoroutineDispatcher implements Delay {
    private boolean removesFutureOnCancellation;

    @Nullable
    public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        return DefaultImpls.delay(this, j, continuation);
    }

    public final void initFutureCancellation$kotlinx_coroutines_core() {
        this.removesFutureOnCancellation = ConcurrentKt.removeFutureOnCancel(getExecutor());
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        try {
            getExecutor().execute(TimeSourceKt.getTimeSource().wrapTask(runnable));
        } catch (RejectedExecutionException unused) {
            TimeSourceKt.getTimeSource().unTrackTask();
            DefaultExecutor.INSTANCE.execute$kotlinx_coroutines_core(runnable);
        }
    }

    public void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
        ScheduledFuture scheduleBlock = this.removesFutureOnCancellation ? scheduleBlock(new ResumeUndispatchedRunnable(this, cancellableContinuation), j, TimeUnit.MILLISECONDS) : null;
        if (scheduleBlock != null) {
            JobKt.cancelFutureOnCancellation(cancellableContinuation, scheduleBlock);
        } else {
            DefaultExecutor.INSTANCE.scheduleResumeAfterDelay(j, cancellableContinuation);
        }
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        ScheduledFuture scheduleBlock = this.removesFutureOnCancellation ? scheduleBlock(runnable, j, TimeUnit.MILLISECONDS) : null;
        return scheduleBlock != null ? new DisposableFutureHandle(scheduleBlock) : DefaultExecutor.INSTANCE.invokeOnTimeout(j, runnable);
    }

    private final ScheduledFuture<?> scheduleBlock(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            Executor executor = getExecutor();
            if (!(executor instanceof ScheduledExecutorService)) {
                executor = null;
            }
            ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) executor;
            if (scheduledExecutorService != null) {
                return scheduledExecutorService.schedule(runnable, j, timeUnit);
            }
            return null;
        } catch (RejectedExecutionException unused) {
            return null;
        }
    }

    public void close() {
        Executor executor = getExecutor();
        if (!(executor instanceof ExecutorService)) {
            executor = null;
        }
        ExecutorService executorService = (ExecutorService) executor;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @NotNull
    public String toString() {
        return getExecutor().toString();
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof ExecutorCoroutineDispatcherBase) && ((ExecutorCoroutineDispatcherBase) obj).getExecutor() == getExecutor();
    }

    public int hashCode() {
        return System.identityHashCode(getExecutor());
    }
}
