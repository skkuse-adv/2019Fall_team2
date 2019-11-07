package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.UndispatchedEventLoop.EventLoop;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

public final class DispatchedKt {
    /* access modifiers changed from: private */
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED");

    public static final <T> void resumeCancellable(@NotNull Continuation<? super T> continuation, T t) {
        CoroutineContext context;
        Object updateThreadContext;
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            boolean z = true;
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
                dispatchedContinuation._state = t;
                dispatchedContinuation.setResumeMode(1);
                dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            UndispatchedEventLoop undispatchedEventLoop = UndispatchedEventLoop.INSTANCE;
            EventLoop eventLoop = (EventLoop) UndispatchedEventLoop.threadLocalEventLoop.get();
            if (eventLoop.isActive) {
                dispatchedContinuation._state = t;
                dispatchedContinuation.setResumeMode(1);
                eventLoop.queue.addLast(dispatchedContinuation);
                return;
            }
            Intrinsics.checkExpressionValueIsNotNull(eventLoop, "eventLoop");
            try {
                eventLoop.isActive = true;
                Job job = (Job) dispatchedContinuation.getContext().get(Job.Key);
                if (job == null || job.isActive()) {
                    z = false;
                } else {
                    CancellationException cancellationException = job.getCancellationException();
                    Companion companion = Result.Companion;
                    dispatchedContinuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(cancellationException)));
                }
                if (!z) {
                    context = dispatchedContinuation.getContext();
                    updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
                    Continuation<T> continuation2 = dispatchedContinuation.continuation;
                    Companion companion2 = Result.Companion;
                    continuation2.resumeWith(Result.m1constructorimpl(t));
                    Unit unit = Unit.INSTANCE;
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                }
                while (true) {
                    Runnable runnable = (Runnable) eventLoop.queue.removeFirstOrNull();
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        eventLoop.isActive = false;
                        return;
                    }
                }
            } catch (Throwable th) {
                try {
                    eventLoop.queue.clear();
                    throw new DispatchException("Unexpected exception in undispatched event loop, clearing pending tasks", th);
                } catch (Throwable th2) {
                    eventLoop.isActive = false;
                    throw th2;
                }
            }
        } else {
            Companion companion3 = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(t));
        }
    }

    public static final <T> void resumeCancellableWithException(@NotNull Continuation<? super T> continuation, @NotNull Throwable th) {
        CoroutineContext context;
        Object updateThreadContext;
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            CoroutineContext context2 = dispatchedContinuation.continuation.getContext();
            CompletedExceptionally completedExceptionally = new CompletedExceptionally(th);
            boolean z = true;
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context2)) {
                dispatchedContinuation._state = new CompletedExceptionally(th);
                dispatchedContinuation.setResumeMode(1);
                dispatchedContinuation.dispatcher.dispatch(context2, dispatchedContinuation);
                return;
            }
            UndispatchedEventLoop undispatchedEventLoop = UndispatchedEventLoop.INSTANCE;
            EventLoop eventLoop = (EventLoop) UndispatchedEventLoop.threadLocalEventLoop.get();
            if (eventLoop.isActive) {
                dispatchedContinuation._state = completedExceptionally;
                dispatchedContinuation.setResumeMode(1);
                eventLoop.queue.addLast(dispatchedContinuation);
                return;
            }
            Intrinsics.checkExpressionValueIsNotNull(eventLoop, "eventLoop");
            try {
                eventLoop.isActive = true;
                Job job = (Job) dispatchedContinuation.getContext().get(Job.Key);
                if (job == null || job.isActive()) {
                    z = false;
                } else {
                    CancellationException cancellationException = job.getCancellationException();
                    Companion companion = Result.Companion;
                    dispatchedContinuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(cancellationException)));
                }
                if (!z) {
                    context = dispatchedContinuation.getContext();
                    updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
                    Continuation<T> continuation2 = dispatchedContinuation.continuation;
                    Companion companion2 = Result.Companion;
                    continuation2.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
                    Unit unit = Unit.INSTANCE;
                    ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                }
                while (true) {
                    Runnable runnable = (Runnable) eventLoop.queue.removeFirstOrNull();
                    if (runnable != null) {
                        runnable.run();
                    } else {
                        eventLoop.isActive = false;
                        return;
                    }
                }
            } catch (Throwable th2) {
                try {
                    eventLoop.queue.clear();
                    throw new DispatchException("Unexpected exception in undispatched event loop, clearing pending tasks", th2);
                } catch (Throwable th3) {
                    eventLoop.isActive = false;
                    throw th3;
                }
            }
        } else {
            Companion companion3 = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <T> void resumeDirect(@NotNull Continuation<? super T> continuation, T t) {
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        if (continuation instanceof DispatchedContinuation) {
            Continuation<T> continuation2 = ((DispatchedContinuation) continuation).continuation;
            Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m1constructorimpl(t));
            return;
        }
        Companion companion2 = Result.Companion;
        continuation.resumeWith(Result.m1constructorimpl(t));
    }

    public static final <T> void resumeDirectWithException(@NotNull Continuation<? super T> continuation, @NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (continuation instanceof DispatchedContinuation) {
            Continuation<T> continuation2 = ((DispatchedContinuation) continuation).continuation;
            Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
            return;
        }
        Companion companion2 = Result.Companion;
        continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
    }

    public static final boolean yieldUndispatched(@NotNull DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Intrinsics.checkParameterIsNotNull(dispatchedContinuation, "receiver$0");
        UndispatchedEventLoop undispatchedEventLoop = UndispatchedEventLoop.INSTANCE;
        Unit unit = Unit.INSTANCE;
        EventLoop eventLoop = (EventLoop) UndispatchedEventLoop.threadLocalEventLoop.get();
        if (!eventLoop.isActive) {
            Intrinsics.checkExpressionValueIsNotNull(eventLoop, "eventLoop");
            try {
                eventLoop.isActive = true;
                dispatchedContinuation.run();
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
        } else if (eventLoop.queue.isEmpty()) {
            return false;
        } else {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.setResumeMode(1);
            eventLoop.queue.addLast(dispatchedContinuation);
            return true;
        }
    }

    public static /* synthetic */ void dispatch$default(DispatchedTask dispatchedTask, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        dispatch(dispatchedTask, i);
    }

    public static final <T> void dispatch(@NotNull DispatchedTask<? super T> dispatchedTask, int i) {
        Intrinsics.checkParameterIsNotNull(dispatchedTask, "receiver$0");
        Continuation delegate = dispatchedTask.getDelegate();
        if (!ResumeModeKt.isDispatchedMode(i) || !(delegate instanceof DispatchedContinuation) || ResumeModeKt.isCancellableMode(i) != ResumeModeKt.isCancellableMode(dispatchedTask.getResumeMode())) {
            resume(dispatchedTask, delegate, i);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate).dispatcher;
        CoroutineContext context = delegate.getContext();
        if (coroutineDispatcher.isDispatchNeeded(context)) {
            coroutineDispatcher.dispatch(context, dispatchedTask);
        } else {
            UndispatchedEventLoop.INSTANCE.resumeUndispatched(dispatchedTask);
        }
    }

    public static final <T> void resume(@NotNull DispatchedTask<? super T> dispatchedTask, @NotNull Continuation<? super T> continuation, int i) {
        Intrinsics.checkParameterIsNotNull(dispatchedTask, "receiver$0");
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        Object takeState = dispatchedTask.takeState();
        Throwable exceptionalResult = dispatchedTask.getExceptionalResult(takeState);
        if (exceptionalResult != null) {
            ResumeModeKt.resumeWithExceptionMode(continuation, exceptionalResult, i);
        } else {
            ResumeModeKt.resumeMode(continuation, dispatchedTask.getSuccessfulResult(takeState), i);
        }
    }
}
