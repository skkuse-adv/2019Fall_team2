package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    private final Thread blockedThread;
    private final EventLoop eventLoop;
    private final boolean privateEventLoop;

    public BlockingCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable EventLoop eventLoop2, boolean z) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(thread, "blockedThread");
        super(coroutineContext, true);
        this.blockedThread = thread;
        this.eventLoop = eventLoop2;
        this.privateEventLoop = z;
        if (this.privateEventLoop && !(this.eventLoop instanceof BlockingEventLoop)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public void onCompletionInternal$kotlinx_coroutines_core(@Nullable Object obj, int i, boolean z) {
        if (!Intrinsics.areEqual((Object) Thread.currentThread(), (Object) this.blockedThread)) {
            LockSupport.unpark(this.blockedThread);
        }
    }

    public final T joinBlocking() {
        TimeSourceKt.getTimeSource().registerTimeLoopThread();
        while (!Thread.interrupted()) {
            EventLoop eventLoop2 = this.eventLoop;
            long processNextEvent = eventLoop2 != null ? eventLoop2.processNextEvent() : Long.MAX_VALUE;
            if (isCompleted()) {
                if (this.privateEventLoop) {
                    EventLoop eventLoop3 = this.eventLoop;
                    if (eventLoop3 != null) {
                        BlockingEventLoop blockingEventLoop = (BlockingEventLoop) eventLoop3;
                        blockingEventLoop.setCompleted(true);
                        blockingEventLoop.shutdown();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.BlockingEventLoop");
                    }
                }
                TimeSourceKt.getTimeSource().unregisterTimeLoopThread();
                T state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
                CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally) ? null : state$kotlinx_coroutines_core);
                if (completedExceptionally == null) {
                    return state$kotlinx_coroutines_core;
                }
                throw completedExceptionally.cause;
            }
            TimeSourceKt.getTimeSource().parkNanos(this, processNextEvent);
        }
        InterruptedException interruptedException = new InterruptedException();
        cancel(interruptedException);
        throw interruptedException;
    }
}
