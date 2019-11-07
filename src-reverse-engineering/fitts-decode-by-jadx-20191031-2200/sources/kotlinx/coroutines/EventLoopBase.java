package kotlinx.coroutines;

import com.facebook.internal.FacebookRequestErrorClassification;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Delay.DefaultImpls;
import kotlinx.coroutines.internal.LockFreeMPSCQueueCore;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class EventLoopBase extends CoroutineDispatcher implements Delay, EventLoop {
    private static final AtomicReferenceFieldUpdater _delayed$FU;
    private static final AtomicReferenceFieldUpdater _queue$FU;
    private volatile Object _delayed = null;
    private volatile Object _queue = null;

    private final class DelayedResumeTask extends DelayedTask {
        private final CancellableContinuation<Unit> cont;
        final /* synthetic */ EventLoopBase this$0;

        public DelayedResumeTask(EventLoopBase eventLoopBase, @NotNull long j, CancellableContinuation<? super Unit> cancellableContinuation) {
            Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
            this.this$0 = eventLoopBase;
            super(j);
            this.cont = cancellableContinuation;
            CancellableContinuationKt.disposeOnCancellation(this.cont, this);
        }

        public void run() {
            this.cont.resumeUndispatched(this.this$0, Unit.INSTANCE);
        }
    }

    public static final class DelayedRunnableTask extends DelayedTask {
        private final Runnable block;

        public DelayedRunnableTask(long j, @NotNull Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(runnable, "block");
            super(j);
            this.block = runnable;
        }

        public void run() {
            this.block.run();
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(this.block.toString());
            return sb.toString();
        }
    }

    public static abstract class DelayedTask implements Runnable, Comparable<DelayedTask>, DisposableHandle, ThreadSafeHeapNode {
        private Object _heap;
        private int index = -1;
        public final long nanoTime;

        public DelayedTask(long j) {
            this.nanoTime = TimeSourceKt.getTimeSource().nanoTime() + EventLoopKt.delayToNanos(j);
        }

        @Nullable
        public ThreadSafeHeap<?> getHeap() {
            Object obj = this._heap;
            if (!(obj instanceof ThreadSafeHeap)) {
                obj = null;
            }
            return (ThreadSafeHeap) obj;
        }

        public void setHeap(@Nullable ThreadSafeHeap<?> threadSafeHeap) {
            if (this._heap != EventLoopKt.DISPOSED_TASK) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public int compareTo(@NotNull DelayedTask delayedTask) {
            Intrinsics.checkParameterIsNotNull(delayedTask, FacebookRequestErrorClassification.KEY_OTHER);
            long j = this.nanoTime - delayedTask.nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        public final boolean timeToExecute(long j) {
            return j - this.nanoTime >= 0;
        }

        public final synchronized int schedule(@NotNull ThreadSafeHeap<DelayedTask> threadSafeHeap, @NotNull EventLoopBase eventLoopBase) {
            int i;
            Intrinsics.checkParameterIsNotNull(threadSafeHeap, "delayed");
            Intrinsics.checkParameterIsNotNull(eventLoopBase, "eventLoop");
            if (this._heap == EventLoopKt.DISPOSED_TASK) {
                return 2;
            }
            synchronized (threadSafeHeap) {
                if (!eventLoopBase.isCompleted()) {
                    threadSafeHeap.addImpl(this);
                    i = 1;
                } else {
                    i = 0;
                }
            }
            return i ^ 1;
        }

        public final void rescheduleOnShutdown() {
            DefaultExecutor.INSTANCE.schedule$kotlinx_coroutines_core(this);
        }

        public final synchronized void dispose() {
            Object obj = this._heap;
            if (obj != EventLoopKt.DISPOSED_TASK) {
                if (!(obj instanceof ThreadSafeHeap)) {
                    obj = null;
                }
                ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) obj;
                if (threadSafeHeap != null) {
                    threadSafeHeap.remove(this);
                }
                this._heap = EventLoopKt.DISPOSED_TASK;
            }
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Delayed[nanos=");
            sb.append(this.nanoTime);
            sb.append(']');
            return sb.toString();
        }
    }

    static {
        Class<Object> cls = Object.class;
        Class<EventLoopBase> cls2 = EventLoopBase.class;
        _queue$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_queue");
        _delayed$FU = AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "_delayed");
    }

    /* access modifiers changed from: protected */
    public abstract boolean isCompleted();

    /* access modifiers changed from: protected */
    public abstract boolean isCorrectThread();

    /* access modifiers changed from: protected */
    public abstract void unpark();

    @Nullable
    public Object delay(long j, @NotNull Continuation<? super Unit> continuation) {
        return DefaultImpls.delay(this, j, continuation);
    }

    @NotNull
    public DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        return DefaultImpls.invokeOnTimeout(this, j, runnable);
    }

    /* access modifiers changed from: protected */
    public final boolean isEmpty() {
        return isQueueEmpty() && isDelayedEmpty();
    }

    private final boolean isQueueEmpty() {
        Object obj = this._queue;
        if (obj == null) {
            return true;
        }
        if (obj instanceof LockFreeMPSCQueueCore) {
            return ((LockFreeMPSCQueueCore) obj).isEmpty();
        }
        if (obj == EventLoopKt.CLOSED_EMPTY) {
            return true;
        }
        return false;
    }

    private final boolean isDelayedEmpty() {
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        return threadSafeHeap == null || threadSafeHeap.isEmpty();
    }

    private final long getNextTime() {
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeMPSCQueueCore)) {
                return obj == EventLoopKt.CLOSED_EMPTY ? Long.MAX_VALUE : 0;
            }
            if (!((LockFreeMPSCQueueCore) obj).isEmpty()) {
                return 0;
            }
        }
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap != null) {
            DelayedTask delayedTask = (DelayedTask) threadSafeHeap.peek();
            if (delayedTask != null) {
                return RangesKt___RangesKt.coerceAtLeast(delayedTask.nanoTime - TimeSourceKt.getTimeSource().nanoTime(), 0);
            }
        }
        return Long.MAX_VALUE;
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, "block");
        execute$kotlinx_coroutines_core(runnable);
    }

    public void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "continuation");
        schedule$kotlinx_coroutines_core(new DelayedResumeTask(this, j, cancellableContinuation));
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long processNextEvent() {
        /*
            r7 = this;
            boolean r0 = r7.isCorrectThread()
            if (r0 != 0) goto L_0x000c
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            return r0
        L_0x000c:
            java.lang.Object r0 = r7._delayed
            kotlinx.coroutines.internal.ThreadSafeHeap r0 = (kotlinx.coroutines.internal.ThreadSafeHeap) r0
            if (r0 == 0) goto L_0x0049
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0049
            kotlinx.coroutines.TimeSource r1 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            long r1 = r1.nanoTime()
        L_0x0020:
            monitor-enter(r0)
            kotlinx.coroutines.internal.ThreadSafeHeapNode r3 = r0.firstImpl()     // Catch:{ all -> 0x0046 }
            r4 = 0
            if (r3 == 0) goto L_0x0040
            kotlinx.coroutines.EventLoopBase$DelayedTask r3 = (kotlinx.coroutines.EventLoopBase.DelayedTask) r3     // Catch:{ all -> 0x0046 }
            boolean r5 = r3.timeToExecute(r1)     // Catch:{ all -> 0x0046 }
            r6 = 0
            if (r5 == 0) goto L_0x0036
            boolean r3 = r7.enqueueImpl(r3)     // Catch:{ all -> 0x0046 }
            goto L_0x0037
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x003e
            kotlinx.coroutines.internal.ThreadSafeHeapNode r3 = r0.removeAtImpl(r6)     // Catch:{ all -> 0x0046 }
            r4 = r3
        L_0x003e:
            monitor-exit(r0)
            goto L_0x0041
        L_0x0040:
            monitor-exit(r0)
        L_0x0041:
            kotlinx.coroutines.EventLoopBase$DelayedTask r4 = (kotlinx.coroutines.EventLoopBase.DelayedTask) r4
            if (r4 == 0) goto L_0x0049
            goto L_0x0020
        L_0x0046:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0049:
            java.lang.Runnable r0 = r7.dequeue()
            if (r0 == 0) goto L_0x0052
            r0.run()
        L_0x0052:
            long r0 = r7.getNextTime()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.EventLoopBase.processNextEvent():long");
    }

    public final void execute$kotlinx_coroutines_core(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "task");
        if (enqueueImpl(runnable)) {
            unpark();
        } else {
            DefaultExecutor.INSTANCE.execute$kotlinx_coroutines_core(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public final void closeQueue() {
        boolean isCompleted = isCompleted();
        if (!_Assertions.ENABLED || isCompleted) {
            while (true) {
                Object obj = this._queue;
                if (obj == null) {
                    if (_queue$FU.compareAndSet(this, null, EventLoopKt.CLOSED_EMPTY)) {
                        return;
                    }
                } else if (obj instanceof LockFreeMPSCQueueCore) {
                    ((LockFreeMPSCQueueCore) obj).close();
                    return;
                } else if (obj != EventLoopKt.CLOSED_EMPTY) {
                    LockFreeMPSCQueueCore lockFreeMPSCQueueCore = new LockFreeMPSCQueueCore(8);
                    if (obj != null) {
                        lockFreeMPSCQueueCore.addLast((Runnable) obj);
                        if (_queue$FU.compareAndSet(this, obj, lockFreeMPSCQueueCore)) {
                            return;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError("Assertion failed");
        }
    }

    public final void schedule$kotlinx_coroutines_core(@NotNull DelayedTask delayedTask) {
        Intrinsics.checkParameterIsNotNull(delayedTask, "delayedTask");
        int scheduleImpl = scheduleImpl(delayedTask);
        if (scheduleImpl != 0) {
            if (scheduleImpl == 1) {
                DefaultExecutor.INSTANCE.schedule$kotlinx_coroutines_core(delayedTask);
            } else if (scheduleImpl != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (shouldUnpark(delayedTask)) {
            unpark();
        }
    }

    private final boolean shouldUnpark(DelayedTask delayedTask) {
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        return (threadSafeHeap != null ? (DelayedTask) threadSafeHeap.peek() : null) == delayedTask;
    }

    private final int scheduleImpl(DelayedTask delayedTask) {
        if (isCompleted()) {
            return 1;
        }
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap == null) {
            _delayed$FU.compareAndSet(this, null, new ThreadSafeHeap());
            Object obj = this._delayed;
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            threadSafeHeap = (ThreadSafeHeap) obj;
        }
        return delayedTask.schedule(threadSafeHeap, this);
    }

    public final void removeDelayedImpl$kotlinx_coroutines_core(@NotNull DelayedTask delayedTask) {
        Intrinsics.checkParameterIsNotNull(delayedTask, "delayedTask");
        ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
        if (threadSafeHeap != null) {
            threadSafeHeap.remove(delayedTask);
        }
    }

    /* access modifiers changed from: protected */
    public final void resetAll() {
        this._queue = null;
        this._delayed = null;
    }

    /* access modifiers changed from: protected */
    public final void rescheduleAllDelayed() {
        while (true) {
            ThreadSafeHeap threadSafeHeap = (ThreadSafeHeap) this._delayed;
            if (threadSafeHeap != null) {
                DelayedTask delayedTask = (DelayedTask) threadSafeHeap.removeFirstOrNull();
                if (delayedTask != null) {
                    delayedTask.rescheduleOnShutdown();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private final boolean enqueueImpl(Runnable runnable) {
        while (true) {
            Object obj = this._queue;
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (_queue$FU.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof LockFreeMPSCQueueCore) {
                if (obj != null) {
                    LockFreeMPSCQueueCore lockFreeMPSCQueueCore = (LockFreeMPSCQueueCore) obj;
                    int addLast = lockFreeMPSCQueueCore.addLast(runnable);
                    if (addLast == 0) {
                        return true;
                    }
                    if (addLast == 1) {
                        _queue$FU.compareAndSet(this, obj, lockFreeMPSCQueueCore.next());
                    } else if (addLast == 2) {
                        return false;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeMPSCQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (obj == EventLoopKt.CLOSED_EMPTY) {
                return false;
            } else {
                LockFreeMPSCQueueCore lockFreeMPSCQueueCore2 = new LockFreeMPSCQueueCore(8);
                if (obj != null) {
                    lockFreeMPSCQueueCore2.addLast((Runnable) obj);
                    lockFreeMPSCQueueCore2.addLast(runnable);
                    if (_queue$FU.compareAndSet(this, obj, lockFreeMPSCQueueCore2)) {
                        return true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }

    private final Runnable dequeue() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof LockFreeMPSCQueueCore) {
                if (obj != null) {
                    LockFreeMPSCQueueCore lockFreeMPSCQueueCore = (LockFreeMPSCQueueCore) obj;
                    Object removeFirstOrNull = lockFreeMPSCQueueCore.removeFirstOrNull();
                    if (removeFirstOrNull != LockFreeMPSCQueueCore.REMOVE_FROZEN) {
                        return (Runnable) removeFirstOrNull;
                    }
                    _queue$FU.compareAndSet(this, obj, lockFreeMPSCQueueCore.next());
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Queue<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> /* = kotlinx.coroutines.internal.LockFreeMPSCQueueCore<kotlinx.coroutines.Runnable /* = java.lang.Runnable */> */");
                }
            } else if (obj == EventLoopKt.CLOSED_EMPTY) {
                return null;
            } else {
                if (_queue$FU.compareAndSet(this, obj, null)) {
                    if (obj != null) {
                        return (Runnable) obj;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.Runnable /* = java.lang.Runnable */");
                }
            }
        }
    }
}
