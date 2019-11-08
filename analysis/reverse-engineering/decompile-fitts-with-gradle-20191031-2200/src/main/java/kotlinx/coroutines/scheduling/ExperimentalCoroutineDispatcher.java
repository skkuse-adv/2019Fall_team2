package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DefaultExecutor;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

public class ExperimentalCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    private final int corePoolSize;
    private CoroutineScheduler coroutineScheduler;
    private final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;

    public ExperimentalCoroutineDispatcher(int i, int i2, long j) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.coroutineScheduler = createScheduler();
    }

    public /* synthetic */ ExperimentalCoroutineDispatcher(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            i = TasksKt.CORE_POOL_SIZE;
        }
        if ((i3 & 2) != 0) {
            i2 = TasksKt.MAX_POOL_SIZE;
        }
        this(i, i2);
    }

    public ExperimentalCoroutineDispatcher(int i, int i2) {
        this(i, i2, TasksKt.IDLE_WORKER_KEEP_ALIVE_NS);
    }

    @NotNull
    public Executor getExecutor() {
        return this.coroutineScheduler;
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatch(coroutineContext, runnable);
        }
    }

    public void dispatchYield(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        try {
            CoroutineScheduler.dispatch$default(this.coroutineScheduler, runnable, null, true, 2, null);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.dispatchYield(coroutineContext, runnable);
        }
    }

    public void close() {
        this.coroutineScheduler.close();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[scheduler = ");
        sb.append(this.coroutineScheduler);
        sb.append(']');
        return sb.toString();
    }

    @NotNull
    public static /* synthetic */ CoroutineDispatcher blocking$default(ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = TasksKt.BLOCKING_DEFAULT_PARALLELISM;
            }
            return experimentalCoroutineDispatcher.blocking(i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: blocking");
    }

    @NotNull
    public final CoroutineDispatcher blocking(int i) {
        if (i > 0) {
            return new LimitingDispatcher(this, i, TaskMode.PROBABLY_BLOCKING);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected positive parallelism level, but have ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    @NotNull
    public final CoroutineDispatcher limited(int i) {
        boolean z = true;
        if (i > 0) {
            if (i > this.corePoolSize) {
                z = false;
            }
            if (z) {
                return new LimitingDispatcher(this, i, TaskMode.NON_BLOCKING);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Expected parallelism level lesser than core pool size (");
            sb.append(this.corePoolSize);
            sb.append("), but have ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected positive parallelism level, but have ");
        sb2.append(i);
        throw new IllegalArgumentException(sb2.toString().toString());
    }

    public final void dispatchWithContext$kotlinx_coroutines_core(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        Intrinsics.checkParameterIsNotNull(taskContext, "context");
        try {
            this.coroutineScheduler.dispatch(runnable, taskContext, z);
        } catch (RejectedExecutionException unused) {
            DefaultExecutor.INSTANCE.execute$kotlinx_coroutines_core(this.coroutineScheduler.createTask$kotlinx_coroutines_core(runnable, taskContext));
        }
    }

    private final CoroutineScheduler createScheduler() {
        CoroutineScheduler coroutineScheduler2 = new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, null, 8, null);
        return coroutineScheduler2;
    }

    public final synchronized void usePrivateScheduler$kotlinx_coroutines_core() {
        this.coroutineScheduler.shutdown(10000);
        this.coroutineScheduler = createScheduler();
    }

    public final synchronized void shutdown$kotlinx_coroutines_core(long j) {
        this.coroutineScheduler.shutdown(j);
    }

    public final void restore$kotlinx_coroutines_core() {
        usePrivateScheduler$kotlinx_coroutines_core();
    }
}
