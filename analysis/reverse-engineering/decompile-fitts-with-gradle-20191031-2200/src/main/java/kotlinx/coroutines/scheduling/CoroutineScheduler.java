package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.TimeSourceKt;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CoroutineScheduler implements Executor, Closeable {
    public static final Companion Companion = new Companion(null);
    /* access modifiers changed from: private */
    public static final int MAX_PARK_TIME_NS = ((int) TimeUnit.SECONDS.toNanos(1));
    public static final int MAX_SUPPORTED_POOL_SIZE = 2097150;
    /* access modifiers changed from: private */
    public static final int MIN_PARK_TIME_NS = ((int) RangesKt___RangesKt.coerceAtMost(RangesKt___RangesKt.coerceAtLeast(TasksKt.WORK_STEALING_TIME_RESOLUTION_NS / ((long) 4), 10), (long) MAX_PARK_TIME_NS));
    public static final int MIN_SUPPORTED_POOL_SIZE = 1;
    /* access modifiers changed from: private */
    public static final Symbol NOT_IN_STACK = new Symbol("NOT_IN_STACK");
    private static final AtomicIntegerFieldUpdater _isTerminated$FU = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");
    static final AtomicLongFieldUpdater controlState$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    private static final AtomicLongFieldUpdater parkedWorkersStack$FU = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    private volatile int _isTerminated;
    volatile long controlState;
    /* access modifiers changed from: private */
    public final int corePoolSize;
    /* access modifiers changed from: private */
    public final Semaphore cpuPermits;
    /* access modifiers changed from: private */
    public final GlobalQueue globalQueue;
    /* access modifiers changed from: private */
    public final long idleWorkerKeepAliveNs;
    private final int maxPoolSize;
    private volatile long parkedWorkersStack;
    /* access modifiers changed from: private */
    public final Random random;
    /* access modifiers changed from: private */
    public final String schedulerName;
    /* access modifiers changed from: private */
    public final Worker[] workers;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[WorkerState.values().length];

        static {
            $EnumSwitchMapping$0[WorkerState.PARKING.ordinal()] = 1;
            $EnumSwitchMapping$0[WorkerState.BLOCKING.ordinal()] = 2;
            $EnumSwitchMapping$0[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            $EnumSwitchMapping$0[WorkerState.RETIRING.ordinal()] = 4;
            $EnumSwitchMapping$0[WorkerState.TERMINATED.ordinal()] = 5;
        }
    }

    public final class Worker extends Thread {
        private static final AtomicIntegerFieldUpdater terminationState$FU = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "terminationState");
        private volatile int indexInArray;
        private long lastExhaustionTime;
        private int lastStealIndex;
        @NotNull
        private final WorkQueue localQueue;
        @Nullable
        private volatile Object nextParkedWorker;
        private int parkTimeNs;
        private int rngState;
        private volatile int spins;
        @NotNull
        private volatile WorkerState state;
        private long terminationDeadline;
        private volatile int terminationState;

        private Worker() {
            setDaemon(true);
            this.localQueue = new WorkQueue();
            this.state = WorkerState.RETIRING;
            this.terminationState = 0;
            this.nextParkedWorker = CoroutineScheduler.NOT_IN_STACK;
            this.parkTimeNs = CoroutineScheduler.MIN_PARK_TIME_NS;
            this.rngState = CoroutineScheduler.this.random.nextInt();
        }

        public final int getIndexInArray() {
            return this.indexInArray;
        }

        public final void setIndexInArray(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public Worker(CoroutineScheduler coroutineScheduler, int i) {
            this();
            setIndexInArray(i);
        }

        @NotNull
        public final CoroutineScheduler getScheduler() {
            return CoroutineScheduler.this;
        }

        @NotNull
        public final WorkQueue getLocalQueue() {
            return this.localQueue;
        }

        @NotNull
        public final WorkerState getState() {
            return this.state;
        }

        public final void setState(@NotNull WorkerState workerState) {
            Intrinsics.checkParameterIsNotNull(workerState, "<set-?>");
            this.state = workerState;
        }

        public final boolean isParking() {
            return this.state == WorkerState.PARKING;
        }

        public final boolean isBlocking() {
            return this.state == WorkerState.BLOCKING;
        }

        @Nullable
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void setNextParkedWorker(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean tryForbidTermination() {
            int i = this.terminationState;
            if (i == -1) {
                return false;
            }
            if (i == 0) {
                return terminationState$FU.compareAndSet(this, 0, -1);
            }
            if (i == 1) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid terminationState = ");
            sb.append(i);
            throw new IllegalStateException(sb.toString().toString());
        }

        public final boolean tryAcquireCpuPermit() {
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            if (!CoroutineScheduler.this.cpuPermits.tryAcquire()) {
                return false;
            }
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final boolean tryReleaseCpu$kotlinx_coroutines_core(@NotNull WorkerState workerState) {
            Intrinsics.checkParameterIsNotNull(workerState, "newState");
            WorkerState workerState2 = this.state;
            boolean z = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.this.cpuPermits.release();
            }
            if (workerState2 != workerState) {
                this.state = workerState;
            }
            return z;
        }

        public void run() {
            boolean z = false;
            while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                Task findTask$kotlinx_coroutines_core = findTask$kotlinx_coroutines_core();
                if (findTask$kotlinx_coroutines_core == null) {
                    if (this.state == WorkerState.CPU_ACQUIRED) {
                        cpuWorkerIdle();
                    } else {
                        blockingWorkerIdle();
                    }
                    z = true;
                } else {
                    if (z) {
                        idleReset(findTask$kotlinx_coroutines_core.getMode());
                        z = false;
                    }
                    beforeTask(findTask$kotlinx_coroutines_core);
                    CoroutineScheduler.this.runSafely(findTask$kotlinx_coroutines_core);
                    afterTask(findTask$kotlinx_coroutines_core);
                }
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.TERMINATED);
        }

        private final void beforeTask(Task task) {
            if (task.getMode() != TaskMode.NON_BLOCKING) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
                if (tryReleaseCpu$kotlinx_coroutines_core(WorkerState.BLOCKING)) {
                    CoroutineScheduler.this.requestCpuWorker();
                }
            } else if (CoroutineScheduler.this.cpuPermits.availablePermits() != 0) {
                long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
                long j = nanoTime - task.submissionTime;
                long j2 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
                if (j >= j2 && nanoTime - this.lastExhaustionTime >= j2 * ((long) 5)) {
                    this.lastExhaustionTime = nanoTime;
                    CoroutineScheduler.this.requestCpuWorker();
                }
            }
        }

        private final void afterTask(Task task) {
            if (task.getMode() != TaskMode.NON_BLOCKING) {
                CoroutineScheduler.controlState$FU.addAndGet(CoroutineScheduler.this, -2097152);
                WorkerState workerState = this.state;
                if (workerState != WorkerState.TERMINATED) {
                    boolean z = workerState == WorkerState.BLOCKING;
                    if (!_Assertions.ENABLED || z) {
                        this.state = WorkerState.RETIRING;
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expected BLOCKING state, but has ");
                    sb.append(workerState);
                    throw new AssertionError(sb.toString());
                }
            }
        }

        public final int nextInt$kotlinx_coroutines_core(int i) {
            int i2 = this.rngState;
            this.rngState = i2 ^ (i2 << 13);
            int i3 = this.rngState;
            this.rngState = i3 ^ (i3 >> 17);
            int i4 = this.rngState;
            this.rngState = i4 ^ (i4 << 5);
            int i5 = i - 1;
            if ((i5 & i) == 0) {
                return this.rngState & i5;
            }
            return (this.rngState & Integer.MAX_VALUE) % i;
        }

        private final void cpuWorkerIdle() {
            int i = this.spins;
            if (i <= 1500) {
                this.spins = i + 1;
                if (i >= 1000) {
                    Thread.yield();
                    return;
                }
                return;
            }
            if (this.parkTimeNs < CoroutineScheduler.MAX_PARK_TIME_NS) {
                this.parkTimeNs = RangesKt___RangesKt.coerceAtMost((this.parkTimeNs * 3) >>> 1, CoroutineScheduler.MAX_PARK_TIME_NS);
            }
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
            doPark((long) this.parkTimeNs);
        }

        private final void blockingWorkerIdle() {
            tryReleaseCpu$kotlinx_coroutines_core(WorkerState.PARKING);
            if (blockingQuiescence()) {
                this.terminationState = 0;
                if (this.terminationDeadline == 0) {
                    this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
                }
                doPark(CoroutineScheduler.this.idleWorkerKeepAliveNs);
                if (System.nanoTime() - this.terminationDeadline >= 0) {
                    this.terminationDeadline = 0;
                    tryTerminateWorker();
                }
            }
        }

        private final void doPark(long j) {
            CoroutineScheduler.this.parkedWorkersStackPush(this);
            LockSupport.parkNanos(j);
        }

        private final void tryTerminateWorker() {
            synchronized (CoroutineScheduler.this.workers) {
                if (!CoroutineScheduler.this.isTerminated()) {
                    if (CoroutineScheduler.this.getCreatedWorkers() > CoroutineScheduler.this.corePoolSize) {
                        if (blockingQuiescence()) {
                            if (terminationState$FU.compareAndSet(this, 0, 1)) {
                                int i = this.indexInArray;
                                setIndexInArray(0);
                                CoroutineScheduler.this.parkedWorkersStackTopUpdate(this, i, 0);
                                int andDecrement = (int) (CoroutineScheduler.controlState$FU.getAndDecrement(CoroutineScheduler.this) & 2097151);
                                if (andDecrement != i) {
                                    Worker worker = CoroutineScheduler.this.workers[andDecrement];
                                    if (worker == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    CoroutineScheduler.this.workers[i] = worker;
                                    worker.setIndexInArray(i);
                                    CoroutineScheduler.this.parkedWorkersStackTopUpdate(worker, andDecrement, i);
                                }
                                CoroutineScheduler.this.workers[andDecrement] = null;
                                Unit unit = Unit.INSTANCE;
                                this.state = WorkerState.TERMINATED;
                            }
                        }
                    }
                }
            }
        }

        private final boolean blockingQuiescence() {
            Task removeFirstBlockingModeOrNull = CoroutineScheduler.this.globalQueue.removeFirstBlockingModeOrNull();
            if (removeFirstBlockingModeOrNull == null) {
                return true;
            }
            this.localQueue.add(removeFirstBlockingModeOrNull, CoroutineScheduler.this.globalQueue);
            return false;
        }

        private final void idleReset(TaskMode taskMode) {
            this.terminationDeadline = 0;
            this.lastStealIndex = 0;
            if (this.state == WorkerState.PARKING) {
                boolean z = taskMode == TaskMode.PROBABLY_BLOCKING;
                if (!_Assertions.ENABLED || z) {
                    this.state = WorkerState.BLOCKING;
                    this.parkTimeNs = CoroutineScheduler.MIN_PARK_TIME_NS;
                } else {
                    throw new AssertionError("Assertion failed");
                }
            }
            this.spins = 0;
        }

        public final void idleResetBeforeUnpark() {
            this.parkTimeNs = CoroutineScheduler.MIN_PARK_TIME_NS;
            this.spins = 0;
        }

        @Nullable
        public final Task findTask$kotlinx_coroutines_core() {
            if (tryAcquireCpuPermit()) {
                return findTaskWithCpuPermit();
            }
            Task poll = this.localQueue.poll();
            if (poll == null) {
                poll = CoroutineScheduler.this.globalQueue.removeFirstBlockingModeOrNull();
            }
            return poll;
        }

        private final Task findTaskWithCpuPermit() {
            boolean z = nextInt$kotlinx_coroutines_core(CoroutineScheduler.this.corePoolSize * 2) == 0;
            if (z) {
                Task removeFirstIfNotClosed = CoroutineScheduler.this.globalQueue.removeFirstIfNotClosed();
                if (removeFirstIfNotClosed != null) {
                    return removeFirstIfNotClosed;
                }
            }
            Task poll = this.localQueue.poll();
            if (poll != null) {
                return poll;
            }
            if (!z) {
                Task removeFirstIfNotClosed2 = CoroutineScheduler.this.globalQueue.removeFirstIfNotClosed();
                if (removeFirstIfNotClosed2 != null) {
                    return removeFirstIfNotClosed2;
                }
            }
            return trySteal();
        }

        private final Task trySteal() {
            int access$getCreatedWorkers$p = CoroutineScheduler.this.getCreatedWorkers();
            if (access$getCreatedWorkers$p < 2) {
                return null;
            }
            int i = this.lastStealIndex;
            if (i == 0) {
                i = nextInt$kotlinx_coroutines_core(access$getCreatedWorkers$p);
            }
            int i2 = i + 1;
            if (i2 > access$getCreatedWorkers$p) {
                i2 = 1;
            }
            this.lastStealIndex = i2;
            Worker worker = CoroutineScheduler.this.workers[i2];
            if (worker == null || worker == this || !this.localQueue.trySteal(worker.localQueue, CoroutineScheduler.this.globalQueue)) {
                return null;
            }
            return this.localQueue.poll();
        }
    }

    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        RETIRING,
        TERMINATED
    }

    /* access modifiers changed from: private */
    public final int createdWorkers(long j) {
        return (int) (j & 2097151);
    }

    public CoroutineScheduler(int i, int i2, long j, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "schedulerName");
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
        if (this.corePoolSize >= 1) {
            String str2 = "Max pool size ";
            if (this.maxPoolSize >= this.corePoolSize) {
                if (this.maxPoolSize <= 2097150) {
                    if (this.idleWorkerKeepAliveNs > 0) {
                        this.globalQueue = new GlobalQueue();
                        this.cpuPermits = new Semaphore(this.corePoolSize, false);
                        this.parkedWorkersStack = 0;
                        this.workers = new Worker[(this.maxPoolSize + 1)];
                        this.controlState = 0;
                        this.random = new Random();
                        this._isTerminated = 0;
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Idle worker keep alive time ");
                    sb.append(this.idleWorkerKeepAliveNs);
                    sb.append(" must be positive");
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append(this.maxPoolSize);
                sb2.append(" should not exceed maximal supported number of threads 2097150");
                throw new IllegalArgumentException(sb2.toString().toString());
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(this.maxPoolSize);
            sb3.append(" should be greater than or equals to core pool size ");
            sb3.append(this.corePoolSize);
            throw new IllegalArgumentException(sb3.toString().toString());
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Core pool size ");
        sb4.append(this.corePoolSize);
        sb4.append(" should be at least 1");
        throw new IllegalArgumentException(sb4.toString().toString());
    }

    public /* synthetic */ CoroutineScheduler(int i, int i2, long j, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 4) != 0) {
            j = TasksKt.IDLE_WORKER_KEEP_ALIVE_NS;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            str = TasksKt.DEFAULT_SCHEDULER_NAME;
        }
        this(i, i2, j2, str);
    }

    /* access modifiers changed from: private */
    public final void parkedWorkersStackPush(Worker worker) {
        long j;
        long j2;
        int indexInArray;
        if (worker.getNextParkedWorker() == NOT_IN_STACK) {
            do {
                j = this.parkedWorkersStack;
                int i = (int) (2097151 & j);
                j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
                indexInArray = worker.getIndexInArray();
                boolean z = indexInArray != 0;
                if (!_Assertions.ENABLED || z) {
                    worker.setNextParkedWorker(this.workers[i]);
                } else {
                    throw new AssertionError("Assertion failed");
                }
            } while (!parkedWorkersStack$FU.compareAndSet(this, j, ((long) indexInArray) | j2));
        }
    }

    private final int parkedWorkersStackNextIndex(Worker worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != NOT_IN_STACK) {
            if (nextParkedWorker == null) {
                return 0;
            }
            Worker worker2 = (Worker) nextParkedWorker;
            int indexInArray = worker2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = worker2.getNextParkedWorker();
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final int getCreatedWorkers() {
        return (int) (this.controlState & 2097151);
    }

    /* access modifiers changed from: private */
    public final int decrementCreatedWorkers() {
        return (int) (controlState$FU.getAndDecrement(this) & 2097151);
    }

    /* access modifiers changed from: private */
    public final void incrementBlockingWorkers() {
        controlState$FU.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
    }

    /* access modifiers changed from: private */
    public final void decrementBlockingWorkers() {
        controlState$FU.addAndGet(this, -2097152);
    }

    /* access modifiers changed from: private */
    public final boolean isTerminated() {
        return this._isTerminated != 0;
    }

    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "command");
        dispatch$default(this, runnable, null, false, 6, null);
    }

    public void close() {
        shutdown(10000);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        if (r9 != null) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void shutdown(long r9) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = _isTerminated$FU
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r3 = r0 instanceof kotlinx.coroutines.scheduling.CoroutineScheduler.Worker
            if (r3 != 0) goto L_0x0014
            r0 = 0
        L_0x0014:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r0
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r3 = r8.workers
            monitor-enter(r3)
            long r4 = r8.controlState     // Catch:{ all -> 0x00c8 }
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r3)
            if (r2 > r5) goto L_0x0073
            r3 = 1
        L_0x0024:
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r4 = r8.workers
            r4 = r4[r3]
            if (r4 != 0) goto L_0x002d
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x002d:
            if (r4 == r0) goto L_0x006e
        L_0x002f:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L_0x003c
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r9)
            goto L_0x002f
        L_0x003c:
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = r4.getState()
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            if (r6 != r7) goto L_0x0046
            r7 = 1
            goto L_0x0047
        L_0x0046:
            r7 = 0
        L_0x0047:
            if (r7 == 0) goto L_0x0053
            kotlinx.coroutines.scheduling.WorkQueue r4 = r4.getLocalQueue()
            kotlinx.coroutines.scheduling.GlobalQueue r6 = r8.globalQueue
            r4.offloadAllWork$kotlinx_coroutines_core(r6)
            goto L_0x006e
        L_0x0053:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Expected TERMINATED state, but found "
            r9.append(r10)
            r9.append(r6)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L_0x006e:
            if (r3 == r5) goto L_0x0073
            int r3 = r3 + 1
            goto L_0x0024
        L_0x0073:
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalQueue
            kotlinx.coroutines.scheduling.Task r10 = kotlinx.coroutines.scheduling.TasksKt.getCLOSED_TASK()
            boolean r9 = r9.add(r10)
            if (r9 == 0) goto L_0x00bc
        L_0x007f:
            if (r0 == 0) goto L_0x0088
            kotlinx.coroutines.scheduling.Task r9 = r0.findTask$kotlinx_coroutines_core()
            if (r9 == 0) goto L_0x0088
            goto L_0x008e
        L_0x0088:
            kotlinx.coroutines.scheduling.GlobalQueue r9 = r8.globalQueue
            kotlinx.coroutines.scheduling.Task r9 = r9.removeFirstIfNotClosed()
        L_0x008e:
            if (r9 == 0) goto L_0x0094
            r8.runSafely(r9)
            goto L_0x007f
        L_0x0094:
            if (r0 == 0) goto L_0x009b
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.tryReleaseCpu$kotlinx_coroutines_core(r9)
        L_0x009b:
            java.util.concurrent.Semaphore r9 = r8.cpuPermits
            int r9 = r9.availablePermits()
            int r10 = r8.corePoolSize
            if (r9 != r10) goto L_0x00a6
            r1 = 1
        L_0x00a6:
            boolean r9 = kotlin._Assertions.ENABLED
            if (r9 == 0) goto L_0x00b5
            if (r1 == 0) goto L_0x00ad
            goto L_0x00b5
        L_0x00ad:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            java.lang.String r10 = "Assertion failed"
            r9.<init>(r10)
            throw r9
        L_0x00b5:
            r9 = 0
            r8.parkedWorkersStack = r9
            r8.controlState = r9
            return
        L_0x00bc:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "GlobalQueue could not be closed yet"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x00c8:
            r9 = move-exception
            monitor-exit(r3)
            goto L_0x00cc
        L_0x00cb:
            throw r9
        L_0x00cc:
            goto L_0x00cb
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.shutdown(long):void");
    }

    public static /* synthetic */ void dispatch$default(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            taskContext = NonBlockingContext.INSTANCE;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        coroutineScheduler.dispatch(runnable, taskContext, z);
    }

    public final void dispatch(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        Intrinsics.checkParameterIsNotNull(taskContext, "taskContext");
        TimeSourceKt.getTimeSource().trackTask();
        Task createTask$kotlinx_coroutines_core = createTask$kotlinx_coroutines_core(runnable, taskContext);
        int submitToLocalQueue = submitToLocalQueue(createTask$kotlinx_coroutines_core, z);
        if (submitToLocalQueue != -1) {
            if (submitToLocalQueue != 1) {
                requestCpuWorker();
            } else if (this.globalQueue.add(createTask$kotlinx_coroutines_core)) {
                requestCpuWorker();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(this.schedulerName);
                sb.append(" was terminated");
                throw new RejectedExecutionException(sb.toString());
            }
        }
    }

    @NotNull
    public final Task createTask$kotlinx_coroutines_core(@NotNull Runnable runnable, @NotNull TaskContext taskContext) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        Intrinsics.checkParameterIsNotNull(taskContext, "taskContext");
        return new Task(runnable, TasksKt.schedulerTimeSource.nanoTime(), taskContext);
    }

    /* access modifiers changed from: private */
    public final void requestCpuWorker() {
        if (this.cpuPermits.availablePermits() == 0) {
            tryUnpark();
        } else if (!tryUnpark()) {
            long j = this.controlState;
            if (((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)) < this.corePoolSize) {
                int createNewWorker = createNewWorker();
                if (createNewWorker == 1 && this.corePoolSize > 1) {
                    createNewWorker();
                }
                if (createNewWorker > 0) {
                    return;
                }
            }
            tryUnpark();
        }
    }

    private final boolean tryUnpark() {
        while (true) {
            Worker parkedWorkersStackPop = parkedWorkersStackPop();
            if (parkedWorkersStackPop == null) {
                return false;
            }
            parkedWorkersStackPop.idleResetBeforeUnpark();
            boolean isParking = parkedWorkersStackPop.isParking();
            LockSupport.unpark(parkedWorkersStackPop);
            if (isParking && parkedWorkersStackPop.tryForbidTermination()) {
                return true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int createNewWorker() {
        /*
            r9 = this;
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r0 = r9.workers
            monitor-enter(r0)
            boolean r1 = r9.isTerminated()     // Catch:{ all -> 0x0065 }
            if (r1 == 0) goto L_0x000c
            r1 = -1
            monitor-exit(r0)
            return r1
        L_0x000c:
            long r1 = r9.controlState     // Catch:{ all -> 0x0065 }
            r3 = 2097151(0x1fffff, double:1.0361303E-317)
            long r5 = r1 & r3
            int r6 = (int) r5     // Catch:{ all -> 0x0065 }
            r7 = 4398044413952(0x3ffffe00000, double:2.1729226538177E-311)
            long r1 = r1 & r7
            r5 = 21
            long r1 = r1 >> r5
            int r2 = (int) r1     // Catch:{ all -> 0x0065 }
            int r1 = r6 - r2
            int r2 = r9.corePoolSize     // Catch:{ all -> 0x0065 }
            r5 = 0
            if (r1 < r2) goto L_0x0027
            monitor-exit(r0)
            return r5
        L_0x0027:
            int r2 = r9.maxPoolSize     // Catch:{ all -> 0x0065 }
            if (r6 >= r2) goto L_0x0063
            java.util.concurrent.Semaphore r2 = r9.cpuPermits     // Catch:{ all -> 0x0065 }
            int r2 = r2.availablePermits()     // Catch:{ all -> 0x0065 }
            if (r2 != 0) goto L_0x0034
            goto L_0x0063
        L_0x0034:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = controlState$FU     // Catch:{ all -> 0x0065 }
            long r6 = r2.incrementAndGet(r9)     // Catch:{ all -> 0x0065 }
            long r3 = r3 & r6
            int r2 = (int) r3     // Catch:{ all -> 0x0065 }
            r3 = 1
            if (r2 <= 0) goto L_0x0046
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r4 = r9.workers     // Catch:{ all -> 0x0065 }
            r4 = r4[r2]     // Catch:{ all -> 0x0065 }
            if (r4 != 0) goto L_0x0046
            r5 = 1
        L_0x0046:
            if (r5 == 0) goto L_0x0057
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r4 = new kotlinx.coroutines.scheduling.CoroutineScheduler$Worker     // Catch:{ all -> 0x0065 }
            r4.<init>(r9, r2)     // Catch:{ all -> 0x0065 }
            r4.start()     // Catch:{ all -> 0x0065 }
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker[] r5 = r9.workers     // Catch:{ all -> 0x0065 }
            r5[r2] = r4     // Catch:{ all -> 0x0065 }
            int r1 = r1 + r3
            monitor-exit(r0)
            return r1
        L_0x0057:
            java.lang.String r1 = "Failed requirement."
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0065 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0065 }
            r2.<init>(r1)     // Catch:{ all -> 0x0065 }
            throw r2     // Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r0)
            return r5
        L_0x0065:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.createNewWorker():int");
    }

    private final int submitToLocalQueue(Task task, boolean z) {
        boolean z2;
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof Worker)) {
            currentThread = null;
        }
        Worker worker = (Worker) currentThread;
        if (worker == null || worker.getScheduler() != this || worker.getState() == WorkerState.TERMINATED) {
            return 1;
        }
        int i = -1;
        if (task.getMode() == TaskMode.NON_BLOCKING) {
            if (worker.isBlocking()) {
                i = 0;
            } else if (!worker.tryAcquireCpuPermit()) {
                return 1;
            }
        }
        if (z) {
            z2 = worker.getLocalQueue().addLast(task, this.globalQueue);
        } else {
            z2 = worker.getLocalQueue().add(task, this.globalQueue);
        }
        if (!z2 || worker.getLocalQueue().getBufferSize$kotlinx_coroutines_core() > TasksKt.QUEUE_SIZE_OFFLOAD_THRESHOLD) {
            return 0;
        }
        return i;
    }

    @NotNull
    public String toString() {
        Worker[] workerArr;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (Worker worker : this.workers) {
            if (worker != null) {
                int size$kotlinx_coroutines_core = worker.getLocalQueue().size$kotlinx_coroutines_core();
                int i6 = WhenMappings.$EnumSwitchMapping$0[worker.getState().ordinal()];
                if (i6 == 1) {
                    i3++;
                } else if (i6 == 2) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(String.valueOf(size$kotlinx_coroutines_core));
                    sb.append("b");
                    arrayList.add(sb.toString());
                } else if (i6 == 3) {
                    i++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(String.valueOf(size$kotlinx_coroutines_core));
                    sb2.append("c");
                    arrayList.add(sb2.toString());
                } else if (i6 == 4) {
                    i4++;
                    if (size$kotlinx_coroutines_core > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(String.valueOf(size$kotlinx_coroutines_core));
                        sb3.append("r");
                        arrayList.add(sb3.toString());
                    }
                } else if (i6 == 5) {
                    i5++;
                }
            }
        }
        long j = this.controlState;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.schedulerName);
        sb4.append('@');
        sb4.append(DebugKt.getHexAddress(this));
        sb4.append('[');
        sb4.append("Pool Size {");
        sb4.append("core = ");
        sb4.append(this.corePoolSize);
        String str = ", ";
        sb4.append(str);
        sb4.append("max = ");
        sb4.append(this.maxPoolSize);
        String str2 = "}, ";
        sb4.append(str2);
        sb4.append("Worker States {");
        sb4.append("CPU = ");
        sb4.append(i);
        sb4.append(str);
        String str3 = "blocking = ";
        sb4.append(str3);
        sb4.append(i2);
        sb4.append(str);
        sb4.append("parked = ");
        sb4.append(i3);
        sb4.append(str);
        sb4.append("retired = ");
        sb4.append(i4);
        sb4.append(str);
        sb4.append("terminated = ");
        sb4.append(i5);
        sb4.append(str2);
        sb4.append("running workers queues = ");
        sb4.append(arrayList);
        sb4.append(str);
        sb4.append("global queue size = ");
        sb4.append(this.globalQueue.getSize());
        sb4.append(str);
        sb4.append("Control State Workers {");
        sb4.append("created = ");
        sb4.append((int) (2097151 & j));
        sb4.append(str);
        sb4.append(str3);
        sb4.append((int) ((j & 4398044413952L) >> 21));
        sb4.append('}');
        sb4.append("]");
        return sb4.toString();
    }

    /* access modifiers changed from: private */
    public final void runSafely(Task task) {
        try {
            task.run();
        } catch (Throwable th) {
            TimeSourceKt.getTimeSource().unTrackTask();
            throw th;
        }
        TimeSourceKt.getTimeSource().unTrackTask();
    }

    /* access modifiers changed from: private */
    public final void parkedWorkersStackTopUpdate(Worker worker, int i, int i2) {
        while (true) {
            long j = this.parkedWorkersStack;
            int i3 = (int) (2097151 & j);
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            int i4 = i3 == i ? i2 == 0 ? parkedWorkersStackNextIndex(worker) : i2 : i3;
            if (i4 >= 0) {
                if (parkedWorkersStack$FU.compareAndSet(this, j, j2 | ((long) i4))) {
                    return;
                }
            }
        }
    }

    private final Worker parkedWorkersStackPop() {
        while (true) {
            long j = this.parkedWorkersStack;
            Worker worker = this.workers[(int) (2097151 & j)];
            if (worker == null) {
                return null;
            }
            long j2 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j) & -2097152;
            int parkedWorkersStackNextIndex = parkedWorkersStackNextIndex(worker);
            if (parkedWorkersStackNextIndex >= 0) {
                if (parkedWorkersStack$FU.compareAndSet(this, j, ((long) parkedWorkersStackNextIndex) | j2)) {
                    worker.setNextParkedWorker(NOT_IN_STACK);
                    return worker;
                }
            }
        }
    }
}
