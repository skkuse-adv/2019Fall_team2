package kotlinx.coroutines;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class ThreadEventLoop extends EventLoopBase {
    private final Thread thread;

    public ThreadEventLoop(@NotNull Thread thread2) {
        Intrinsics.checkParameterIsNotNull(thread2, "thread");
        this.thread = thread2;
    }

    /* access modifiers changed from: protected */
    public boolean isCorrectThread() {
        return Thread.currentThread() == this.thread;
    }

    /* access modifiers changed from: protected */
    public void unpark() {
        if (Thread.currentThread() != this.thread) {
            TimeSourceKt.getTimeSource().unpark(this.thread);
        }
    }

    public final void shutdown() {
        closeQueue();
        boolean isCorrectThread = isCorrectThread();
        if (!_Assertions.ENABLED || isCorrectThread) {
            do {
            } while (processNextEvent() <= 0);
            rescheduleAllDelayed();
            return;
        }
        throw new AssertionError("Assertion failed");
    }
}
