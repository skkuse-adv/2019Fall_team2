package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result.Failure;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SafeContinuation<T> implements Continuation<T>, CoroutineStackFrame {
    @Deprecated
    public static final Companion Companion = new Companion(null);
    private static final AtomicReferenceFieldUpdater<SafeContinuation<?>, Object> RESULT = AtomicReferenceFieldUpdater.newUpdater(SafeContinuation.class, Object.class, "result");
    private final Continuation<T> delegate;
    private volatile Object result;

    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public SafeContinuation(@NotNull Continuation<? super T> continuation, @Nullable Object obj) {
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        this.delegate = continuation;
        this.result = obj;
    }

    public SafeContinuation(@NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "delegate");
        this(continuation, CoroutineSingletons.UNDECIDED);
    }

    @NotNull
    public CoroutineContext getContext() {
        return this.delegate.getContext();
    }

    public void resumeWith(@NotNull Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
            if (obj2 == coroutineSingletons) {
                if (RESULT.compareAndSet(this, coroutineSingletons, obj)) {
                    return;
                }
            } else if (obj2 != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                throw new IllegalStateException("Already resumed");
            } else if (RESULT.compareAndSet(this, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED(), CoroutineSingletons.RESUMED)) {
                this.delegate.resumeWith(obj);
                return;
            }
        }
    }

    @Nullable
    public final Object getOrThrow() {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        if (obj == coroutineSingletons) {
            if (RESULT.compareAndSet(this, coroutineSingletons, IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED())) {
                return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.RESUMED) {
            obj = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        } else if (obj instanceof Failure) {
            throw ((Failure) obj).exception;
        }
        return obj;
    }

    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SafeContinuation for ");
        sb.append(this.delegate);
        return sb.toString();
    }
}
