package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class WorkQueue {
    static final AtomicIntegerFieldUpdater consumerIndex$FU;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU;
    static final AtomicIntegerFieldUpdater producerIndex$FU;
    /* access modifiers changed from: private */
    public final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(128);
    volatile int consumerIndex = 0;
    private volatile Object lastScheduledTask = null;
    volatile int producerIndex = 0;

    static {
        Class<WorkQueue> cls = WorkQueue.class;
        lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
    }

    public final int getBufferSize$kotlinx_coroutines_core() {
        return this.producerIndex - this.consumerIndex;
    }

    @Nullable
    public final Task poll() {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (task != null) {
            return task;
        }
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (((Task) this.buffer.get(i2)) != null && consumerIndex$FU.compareAndSet(this, i, i + 1)) {
                return (Task) this.buffer.getAndSet(i2, null);
            }
        }
    }

    public final boolean add(@NotNull Task task, @NotNull GlobalQueue globalQueue) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, task);
        if (task2 != null) {
            return addLast(task2, globalQueue);
        }
        return true;
    }

    public final boolean addLast(@NotNull Task task, @NotNull GlobalQueue globalQueue) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        boolean z = true;
        while (!tryAddLast(task)) {
            offloadWork(globalQueue);
            z = false;
        }
        return z;
    }

    public final boolean trySteal(@NotNull WorkQueue workQueue, @NotNull GlobalQueue globalQueue) {
        Task task;
        WorkQueue workQueue2 = workQueue;
        GlobalQueue globalQueue2 = globalQueue;
        Intrinsics.checkParameterIsNotNull(workQueue2, "victim");
        Intrinsics.checkParameterIsNotNull(globalQueue2, "globalQueue");
        long nanoTime = TasksKt.schedulerTimeSource.nanoTime();
        int bufferSize$kotlinx_coroutines_core = workQueue.getBufferSize$kotlinx_coroutines_core();
        if (bufferSize$kotlinx_coroutines_core == 0) {
            return tryStealLastScheduled(nanoTime, workQueue2, globalQueue2);
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(bufferSize$kotlinx_coroutines_core / 2, 1);
        int i = 0;
        boolean z = false;
        while (i < coerceAtLeast) {
            while (true) {
                int i2 = workQueue2.consumerIndex;
                task = null;
                if (i2 - workQueue2.producerIndex != 0) {
                    int i3 = i2 & 127;
                    Task task2 = (Task) workQueue.buffer.get(i3);
                    if (task2 != null) {
                        if (!(nanoTime - task2.submissionTime >= TasksKt.WORK_STEALING_TIME_RESOLUTION_NS || workQueue.getBufferSize$kotlinx_coroutines_core() > TasksKt.QUEUE_SIZE_OFFLOAD_THRESHOLD)) {
                            break;
                        } else if (consumerIndex$FU.compareAndSet(workQueue2, i2, i2 + 1)) {
                            task = (Task) workQueue.buffer.getAndSet(i3, null);
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
            if (task == null) {
                break;
            }
            add(task, globalQueue2);
            i++;
            z = true;
        }
        return z;
    }

    private final boolean tryStealLastScheduled(long j, WorkQueue workQueue, GlobalQueue globalQueue) {
        Task task = (Task) workQueue.lastScheduledTask;
        if (task == null || j - task.submissionTime < TasksKt.WORK_STEALING_TIME_RESOLUTION_NS || !lastScheduledTask$FU.compareAndSet(workQueue, task, null)) {
            return false;
        }
        add(task, globalQueue);
        return true;
    }

    public final int size$kotlinx_coroutines_core() {
        return this.lastScheduledTask != null ? getBufferSize$kotlinx_coroutines_core() + 1 : getBufferSize$kotlinx_coroutines_core();
    }

    private final void offloadWork(GlobalQueue globalQueue) {
        Task task;
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(getBufferSize$kotlinx_coroutines_core() / 2, 1);
        int i = 0;
        while (i < coerceAtLeast) {
            while (true) {
                int i2 = this.consumerIndex;
                task = null;
                if (i2 - this.producerIndex != 0) {
                    int i3 = i2 & 127;
                    if (((Task) this.buffer.get(i3)) != null && consumerIndex$FU.compareAndSet(this, i2, i2 + 1)) {
                        task = (Task) this.buffer.getAndSet(i3, null);
                        break;
                    }
                } else {
                    break;
                }
            }
            if (task != null) {
                addToGlobalQueue(globalQueue, task);
                i++;
            } else {
                return;
            }
        }
    }

    private final void addToGlobalQueue(GlobalQueue globalQueue, Task task) {
        if (!globalQueue.add(task)) {
            throw new IllegalStateException("GlobalQueue could not be closed yet".toString());
        }
    }

    public final void offloadAllWork$kotlinx_coroutines_core(@NotNull GlobalQueue globalQueue) {
        Task task;
        Intrinsics.checkParameterIsNotNull(globalQueue, "globalQueue");
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (task2 != null) {
            addToGlobalQueue(globalQueue, task2);
        }
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                task = null;
            } else {
                int i2 = i & 127;
                if (((Task) this.buffer.get(i2)) != null && consumerIndex$FU.compareAndSet(this, i, i + 1)) {
                    task = (Task) this.buffer.getAndSet(i2, null);
                }
            }
            if (task != null) {
                addToGlobalQueue(globalQueue, task);
            } else {
                return;
            }
        }
    }

    private final boolean tryAddLast(Task task) {
        if (getBufferSize$kotlinx_coroutines_core() == 127) {
            return false;
        }
        int i = this.producerIndex & 127;
        if (this.buffer.get(i) != null) {
            return false;
        }
        this.buffer.lazySet(i, task);
        producerIndex$FU.incrementAndGet(this);
        return true;
    }
}
