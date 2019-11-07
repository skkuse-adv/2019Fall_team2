package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CancellableContinuationImpl<T> extends AbstractContinuation<T> implements CancellableContinuation<T>, Runnable {
    @NotNull
    private final CoroutineContext context;

    public CancellableContinuationImpl(@NotNull Continuation<? super T> continuation, int i) {
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        super(continuation, i);
        this.context = continuation.getContext();
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    public void initCancellability() {
        initParentJobInternal$kotlinx_coroutines_core((Job) getDelegate().getContext().get(Job.Key));
    }

    public void completeResume(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "token");
        completeStateUpdate((NotCompleted) obj, getState$kotlinx_coroutines_core(), getResumeMode());
    }

    public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "receiver$0");
        Continuation delegate = getDelegate();
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (!(delegate instanceof DispatchedContinuation)) {
            delegate = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate;
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        resumeImpl(t, coroutineDispatcher2 == coroutineDispatcher ? 3 : getResumeMode());
    }

    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "receiver$0");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        Continuation delegate = getDelegate();
        CoroutineDispatcher coroutineDispatcher2 = null;
        if (!(delegate instanceof DispatchedContinuation)) {
            delegate = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate;
        CompletedExceptionally completedExceptionally = new CompletedExceptionally(th);
        if (dispatchedContinuation != null) {
            coroutineDispatcher2 = dispatchedContinuation.dispatcher;
        }
        resumeImpl(completedExceptionally, coroutineDispatcher2 == coroutineDispatcher ? 3 : getResumeMode());
    }

    public <T> T getSuccessfulResult(@Nullable Object obj) {
        return obj instanceof CompletedIdempotentResult ? ((CompletedIdempotentResult) obj).result : obj;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String nameString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CancellableContinuation(");
        sb.append(DebugKt.toDebugString(getDelegate()));
        sb.append(')');
        return sb.toString();
    }

    @Nullable
    public Object tryResume(T t, @Nullable Object obj) {
        Object state$kotlinx_coroutines_core;
        T t2;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof NotCompleted)) {
                if (state$kotlinx_coroutines_core instanceof CompletedIdempotentResult) {
                    CompletedIdempotentResult completedIdempotentResult = (CompletedIdempotentResult) state$kotlinx_coroutines_core;
                    if (completedIdempotentResult.idempotentResume == obj) {
                        if (completedIdempotentResult.result == t) {
                            return completedIdempotentResult.token;
                        }
                        throw new IllegalStateException("Non-idempotent resume".toString());
                    }
                }
                return null;
            } else if (obj == null) {
                t2 = t;
            } else {
                t2 = new CompletedIdempotentResult(obj, t, (NotCompleted) state$kotlinx_coroutines_core);
            }
        } while (!tryUpdateStateToFinal((NotCompleted) state$kotlinx_coroutines_core, t2));
        return state$kotlinx_coroutines_core;
    }

    @Nullable
    public Object tryResumeWithException(@NotNull Throwable th) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(th, "exception");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof NotCompleted)) {
                return null;
            }
        } while (!tryUpdateStateToFinal((NotCompleted) state$kotlinx_coroutines_core, new CompletedExceptionally(th)));
        return state$kotlinx_coroutines_core;
    }
}
