package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.ThreadLocalWithInitialValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UndispatchedEventLoop {
    public static final UndispatchedEventLoop INSTANCE = new UndispatchedEventLoop();
    @NotNull
    public static final ThreadLocalWithInitialValue<EventLoop> threadLocalEventLoop = new ThreadLocalWithInitialValue<>(UndispatchedEventLoop$threadLocalEventLoop$1.INSTANCE);

    public static final class EventLoop {
        public boolean isActive;
        @NotNull
        public final ArrayQueue<Runnable> queue;

        public EventLoop() {
            this(false, null, 3, null);
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=kotlinx.coroutines.internal.ArrayQueue, code=kotlinx.coroutines.internal.ArrayQueue<java.lang.Runnable>, for r2v0, types: [kotlinx.coroutines.internal.ArrayQueue] */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static /* synthetic */ kotlinx.coroutines.UndispatchedEventLoop.EventLoop copy$default(kotlinx.coroutines.UndispatchedEventLoop.EventLoop r0, boolean r1, kotlinx.coroutines.internal.ArrayQueue<java.lang.Runnable> r2, int r3, java.lang.Object r4) {
            /*
                r4 = r3 & 1
                if (r4 == 0) goto L_0x0006
                boolean r1 = r0.isActive
            L_0x0006:
                r3 = r3 & 2
                if (r3 == 0) goto L_0x000c
                kotlinx.coroutines.internal.ArrayQueue<java.lang.Runnable> r2 = r0.queue
            L_0x000c:
                kotlinx.coroutines.UndispatchedEventLoop$EventLoop r0 = r0.copy(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.UndispatchedEventLoop.EventLoop.copy$default(kotlinx.coroutines.UndispatchedEventLoop$EventLoop, boolean, kotlinx.coroutines.internal.ArrayQueue, int, java.lang.Object):kotlinx.coroutines.UndispatchedEventLoop$EventLoop");
        }

        public final boolean component1() {
            return this.isActive;
        }

        @NotNull
        public final ArrayQueue<Runnable> component2() {
            return this.queue;
        }

        @NotNull
        public final EventLoop copy(boolean z, @NotNull ArrayQueue<Runnable> arrayQueue) {
            Intrinsics.checkParameterIsNotNull(arrayQueue, "queue");
            return new EventLoop(z, arrayQueue);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                if (obj instanceof EventLoop) {
                    EventLoop eventLoop = (EventLoop) obj;
                    if (!(this.isActive == eventLoop.isActive) || !Intrinsics.areEqual((Object) this.queue, (Object) eventLoop.queue)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.isActive;
            if (z) {
                z = true;
            }
            int i = (z ? 1 : 0) * true;
            ArrayQueue<Runnable> arrayQueue = this.queue;
            return i + (arrayQueue != null ? arrayQueue.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("EventLoop(isActive=");
            sb.append(this.isActive);
            sb.append(", queue=");
            sb.append(this.queue);
            sb.append(")");
            return sb.toString();
        }

        public EventLoop(boolean z, @NotNull ArrayQueue<Runnable> arrayQueue) {
            Intrinsics.checkParameterIsNotNull(arrayQueue, "queue");
            this.isActive = z;
            this.queue = arrayQueue;
        }

        public /* synthetic */ EventLoop(boolean z, ArrayQueue arrayQueue, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                arrayQueue = new ArrayQueue();
            }
            this(z, arrayQueue);
        }
    }

    private UndispatchedEventLoop() {
    }

    public static /* synthetic */ boolean execute$default(UndispatchedEventLoop undispatchedEventLoop, DispatchedContinuation dispatchedContinuation, Object obj, int i, boolean z, Function0 function0, int i2, Object obj2) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(dispatchedContinuation, "continuation");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        EventLoop eventLoop = (EventLoop) threadLocalEventLoop.get();
        if (!eventLoop.isActive) {
            Intrinsics.checkExpressionValueIsNotNull(eventLoop, "eventLoop");
            try {
                eventLoop.isActive = true;
                function0.invoke();
                while (true) {
                    Runnable runnable = (Runnable) eventLoop.queue.removeFirstOrNull();
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        InlineMarker.finallyStart(1);
                        eventLoop.isActive = false;
                        InlineMarker.finallyEnd(1);
                        return false;
                    }
                }
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                eventLoop.isActive = false;
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } else if (z && eventLoop.queue.isEmpty()) {
            return false;
        } else {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.setResumeMode(i);
            eventLoop.queue.addLast(dispatchedContinuation);
            return true;
        }
    }

    public final boolean execute(@NotNull DispatchedContinuation<?> dispatchedContinuation, @Nullable Object obj, int i, boolean z, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(dispatchedContinuation, "continuation");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        EventLoop eventLoop = (EventLoop) threadLocalEventLoop.get();
        if (!eventLoop.isActive) {
            Intrinsics.checkExpressionValueIsNotNull(eventLoop, "eventLoop");
            try {
                eventLoop.isActive = true;
                function0.invoke();
                while (true) {
                    Runnable runnable = (Runnable) eventLoop.queue.removeFirstOrNull();
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        InlineMarker.finallyStart(1);
                        eventLoop.isActive = false;
                        InlineMarker.finallyEnd(1);
                        return false;
                    }
                }
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                eventLoop.isActive = false;
                InlineMarker.finallyEnd(1);
                throw th;
            }
        } else if (z && eventLoop.queue.isEmpty()) {
            return false;
        } else {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.setResumeMode(i);
            eventLoop.queue.addLast(dispatchedContinuation);
            return true;
        }
    }

    public final boolean resumeUndispatched(@NotNull DispatchedTask<?> dispatchedTask) {
        Intrinsics.checkParameterIsNotNull(dispatchedTask, "task");
        EventLoop eventLoop = (EventLoop) threadLocalEventLoop.get();
        if (eventLoop.isActive) {
            eventLoop.queue.addLast(dispatchedTask);
            return true;
        }
        Intrinsics.checkExpressionValueIsNotNull(eventLoop, "eventLoop");
        try {
            eventLoop.isActive = true;
            DispatchedKt.resume(dispatchedTask, dispatchedTask.getDelegate(), 3);
            while (true) {
                Runnable runnable = (Runnable) eventLoop.queue.removeFirstOrNull();
                if (runnable != null) {
                    runnable.run();
                } else {
                    eventLoop.isActive = false;
                    return false;
                }
            }
        } catch (Throwable th) {
            eventLoop.isActive = false;
            throw th;
        }
    }

    public final void runEventLoop(@NotNull EventLoop eventLoop, @NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(eventLoop, "eventLoop");
        Intrinsics.checkParameterIsNotNull(function0, "block");
        try {
            eventLoop.isActive = true;
            function0.invoke();
            while (true) {
                Runnable runnable = (Runnable) eventLoop.queue.removeFirstOrNull();
                if (runnable != null) {
                    runnable.run();
                } else {
                    InlineMarker.finallyStart(1);
                    eventLoop.isActive = false;
                    InlineMarker.finallyEnd(1);
                    return;
                }
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            eventLoop.isActive = false;
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
