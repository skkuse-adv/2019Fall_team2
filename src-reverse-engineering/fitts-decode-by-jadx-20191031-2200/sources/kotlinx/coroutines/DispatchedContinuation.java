package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DispatchedTask.DefaultImpls;
import kotlinx.coroutines.UndispatchedEventLoop.EventLoop;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DispatchedContinuation<T> implements Continuation<T>, DispatchedTask<T> {
    @Nullable
    public Object _state = DispatchedKt.UNDEFINED;
    @NotNull
    public final Continuation<T> continuation;
    @NotNull
    public final Object countOrElement = ThreadContextKt.threadContextElements(getContext());
    @NotNull
    public final CoroutineDispatcher dispatcher;
    private int resumeMode;

    public static /* synthetic */ void _state$annotations() {
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @NotNull
    public Continuation<T> getDelegate() {
        return this;
    }

    public DispatchedContinuation(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Continuation<? super T> continuation2) {
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "dispatcher");
        Intrinsics.checkParameterIsNotNull(continuation2, "continuation");
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuation2;
    }

    @Nullable
    public Throwable getExceptionalResult(@Nullable Object obj) {
        return DefaultImpls.getExceptionalResult(this, obj);
    }

    public <T> T getSuccessfulResult(@Nullable Object obj) {
        return DefaultImpls.getSuccessfulResult(this, obj);
    }

    public void run() {
        DefaultImpls.run(this);
    }

    public int getResumeMode() {
        return this.resumeMode;
    }

    public void setResumeMode(int i) {
        this.resumeMode = i;
    }

    @Nullable
    public Object takeState() {
        Object obj = this._state;
        if (obj != DispatchedKt.UNDEFINED) {
            this._state = DispatchedKt.UNDEFINED;
            return obj;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public void resumeWith(@NotNull Object obj) {
        CoroutineContext context;
        Object updateThreadContext;
        CoroutineContext context2 = this.continuation.getContext();
        Object state = CompletedExceptionallyKt.toState(obj);
        if (this.dispatcher.isDispatchNeeded(context2)) {
            this._state = state;
            setResumeMode(0);
            this.dispatcher.dispatch(context2, this);
            return;
        }
        UndispatchedEventLoop undispatchedEventLoop = UndispatchedEventLoop.INSTANCE;
        EventLoop eventLoop = (EventLoop) UndispatchedEventLoop.threadLocalEventLoop.get();
        if (eventLoop.isActive) {
            this._state = state;
            setResumeMode(0);
            eventLoop.queue.addLast(this);
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(eventLoop, "eventLoop");
        try {
            eventLoop.isActive = true;
            context = getContext();
            updateThreadContext = ThreadContextKt.updateThreadContext(context, this.countOrElement);
            this.continuation.resumeWith(obj);
            Unit unit = Unit.INSTANCE;
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
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
    }

    public final void resumeCancellable(T t) {
        boolean z;
        CoroutineContext context;
        Object updateThreadContext;
        if (this.dispatcher.isDispatchNeeded(getContext())) {
            this._state = t;
            setResumeMode(1);
            this.dispatcher.dispatch(getContext(), this);
            return;
        }
        UndispatchedEventLoop undispatchedEventLoop = UndispatchedEventLoop.INSTANCE;
        EventLoop eventLoop = (EventLoop) UndispatchedEventLoop.threadLocalEventLoop.get();
        if (eventLoop.isActive) {
            this._state = t;
            setResumeMode(1);
            eventLoop.queue.addLast(this);
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(eventLoop, "eventLoop");
        try {
            eventLoop.isActive = true;
            Job job = (Job) getContext().get(Job.Key);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                CancellationException cancellationException = job.getCancellationException();
                Companion companion = Result.Companion;
                resumeWith(Result.m1constructorimpl(ResultKt.createFailure(cancellationException)));
                z = true;
            }
            if (!z) {
                context = getContext();
                updateThreadContext = ThreadContextKt.updateThreadContext(context, this.countOrElement);
                Continuation<T> continuation2 = this.continuation;
                Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m1constructorimpl(t));
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                InlineMarker.finallyEnd(1);
            }
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
            try {
                eventLoop.queue.clear();
                throw new DispatchException("Unexpected exception in undispatched event loop, clearing pending tasks", th);
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                eventLoop.isActive = false;
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    public final void resumeCancellableWithException(@NotNull Throwable th) {
        boolean z;
        CoroutineContext context;
        Object updateThreadContext;
        Intrinsics.checkParameterIsNotNull(th, "exception");
        CoroutineContext context2 = this.continuation.getContext();
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(th);
        if (this.dispatcher.isDispatchNeeded(context2)) {
            this._state = new CompletedExceptionally(th);
            setResumeMode(1);
            this.dispatcher.dispatch(context2, this);
            return;
        }
        UndispatchedEventLoop undispatchedEventLoop = UndispatchedEventLoop.INSTANCE;
        EventLoop eventLoop = (EventLoop) UndispatchedEventLoop.threadLocalEventLoop.get();
        if (eventLoop.isActive) {
            this._state = completedExceptionally;
            setResumeMode(1);
            eventLoop.queue.addLast(this);
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(eventLoop, "eventLoop");
        try {
            eventLoop.isActive = true;
            Job job = (Job) getContext().get(Job.Key);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                CancellationException cancellationException = job.getCancellationException();
                Companion companion = Result.Companion;
                resumeWith(Result.m1constructorimpl(ResultKt.createFailure(cancellationException)));
                z = true;
            }
            if (!z) {
                context = getContext();
                updateThreadContext = ThreadContextKt.updateThreadContext(context, this.countOrElement);
                Continuation<T> continuation2 = this.continuation;
                Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
                Unit unit = Unit.INSTANCE;
                InlineMarker.finallyStart(1);
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
                InlineMarker.finallyEnd(1);
            }
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
        } catch (Throwable th2) {
            try {
                eventLoop.queue.clear();
                throw new DispatchException("Unexpected exception in undispatched event loop, clearing pending tasks", th2);
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                eventLoop.isActive = false;
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    public final boolean resumeCancelled() {
        Job job = (Job) getContext().get(Job.Key);
        if (job == null || job.isActive()) {
            return false;
        }
        CancellationException cancellationException = job.getCancellationException();
        Companion companion = Result.Companion;
        resumeWith(Result.m1constructorimpl(ResultKt.createFailure(cancellationException)));
        return true;
    }

    public final void resumeUndispatched(T t) {
        CoroutineContext context = getContext();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, this.countOrElement);
        try {
            Continuation<T> continuation2 = this.continuation;
            Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m1constructorimpl(t));
            Unit unit = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void resumeUndispatchedWithException(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        CoroutineContext context = getContext();
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, this.countOrElement);
        try {
            Continuation<T> continuation2 = this.continuation;
            Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
            Unit unit = Unit.INSTANCE;
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public final void dispatchYield$kotlinx_coroutines_core(T t) {
        CoroutineContext context = this.continuation.getContext();
        this._state = t;
        setResumeMode(1);
        this.dispatcher.dispatchYield(context, this);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DispatchedContinuation[");
        sb.append(this.dispatcher);
        sb.append(", ");
        sb.append(DebugKt.toDebugString(this.continuation));
        sb.append(']');
        return sb.toString();
    }
}
