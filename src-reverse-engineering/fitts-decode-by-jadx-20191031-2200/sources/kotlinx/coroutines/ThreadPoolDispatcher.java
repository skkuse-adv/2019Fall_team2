package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class ThreadPoolDispatcher extends ExecutorCoroutineDispatcherBase {
    @NotNull
    private final Executor executor;
    /* access modifiers changed from: private */
    public final int nThreads;
    /* access modifiers changed from: private */
    public final String name;
    /* access modifiers changed from: private */
    public final AtomicInteger threadNo = new AtomicInteger();

    public ThreadPoolDispatcher(int i, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.nThreads = i;
        this.name = str;
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(this.nThreads, new ThreadPoolDispatcher$executor$1(this));
        Intrinsics.checkExpressionValueIsNotNull(newScheduledThreadPool, "Executors.newScheduledTh….incrementAndGet())\n    }");
        this.executor = newScheduledThreadPool;
        initFutureCancellation$kotlinx_coroutines_core();
    }

    @NotNull
    public Executor getExecutor() {
        return this.executor;
    }

    public void close() {
        Executor executor2 = getExecutor();
        if (executor2 != null) {
            ((ExecutorService) executor2).shutdown();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.util.concurrent.ExecutorService");
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ThreadPoolDispatcher[");
        sb.append(this.nThreads);
        sb.append(", ");
        sb.append(this.name);
        sb.append(']');
        return sb.toString();
    }
}
