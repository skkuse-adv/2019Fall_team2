package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    @Nullable
    private final Continuation<Object> completion;

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Object invokeSuspend(@NotNull Object obj);

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
    }

    public BaseContinuationImpl(@Nullable Continuation<Object> continuation) {
        this.completion = continuation;
    }

    @Nullable
    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    public final void resumeWith(@NotNull Object obj) {
        DebugProbesKt.probeCoroutineResumed(this);
        Object obj2 = obj;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            Continuation<Object> continuation = baseContinuationImpl.completion;
            if (continuation == null) {
                Intrinsics.throwNpe();
            }
            try {
                Object invokeSuspend = baseContinuationImpl.invokeSuspend(obj2);
                if (invokeSuspend != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    Companion companion = Result.Companion;
                    obj2 = Result.m1constructorimpl(invokeSuspend);
                    baseContinuationImpl.releaseIntercepted();
                    if (continuation instanceof BaseContinuationImpl) {
                        baseContinuationImpl = (BaseContinuationImpl) continuation;
                    } else {
                        continuation.resumeWith(obj2);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                Companion companion2 = Result.Companion;
                obj2 = Result.m1constructorimpl(ResultKt.createFailure(th));
            }
        }
    }

    @NotNull
    public Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @NotNull
    public Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return DebugMetadataKt.getStackTraceElement(this);
    }
}
