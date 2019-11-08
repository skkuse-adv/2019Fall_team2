package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

public final class TasksKt {
    public static final int BLOCKING_DEFAULT_PARALLELISM = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, (Object) null);
    @NotNull
    private static final Task CLOSED_TASK = new Task(EMPTY_RUNNABLE, 0, NonBlockingContext.INSTANCE);
    public static final int CORE_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.core.pool.size", RangesKt___RangesKt.coerceAtLeast(SystemPropsKt.getAVAILABLE_PROCESSORS(), 2), 1, 0, 8, (Object) null);
    @NotNull
    public static final String DEFAULT_SCHEDULER_NAME = "DefaultDispatcher";
    private static final Runnable EMPTY_RUNNABLE = new TasksKt$$special$$inlined$Runnable$1();
    public static final long IDLE_WORKER_KEEP_ALIVE_NS = TimeUnit.SECONDS.toNanos(SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.keep.alive.sec", 5, 0, 0, 12, (Object) null));
    public static final int MAX_POOL_SIZE = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.max.pool.size", RangesKt___RangesKt.coerceIn(SystemPropsKt.getAVAILABLE_PROCESSORS() * 128, CORE_POOL_SIZE, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE), 0, (int) CoroutineScheduler.MAX_SUPPORTED_POOL_SIZE, 4, (Object) null);
    public static final int QUEUE_SIZE_OFFLOAD_THRESHOLD = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.offload.threshold", 96, 0, 128, 4, (Object) null);
    public static final long WORK_STEALING_TIME_RESOLUTION_NS = SystemPropsKt.systemProp$default("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, (Object) null);
    @NotNull
    public static TimeSource schedulerTimeSource = NanoTimeSource.INSTANCE;

    @NotNull
    public static final Task getCLOSED_TASK() {
        return CLOSED_TASK;
    }
}
