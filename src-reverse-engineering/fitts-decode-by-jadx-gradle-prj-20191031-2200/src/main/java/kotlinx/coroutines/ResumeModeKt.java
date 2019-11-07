package kotlinx.coroutines;

import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

public final class ResumeModeKt {
    public static final int MODE_ATOMIC_DEFAULT = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_DIRECT = 2;
    public static final int MODE_IGNORE = 4;
    public static final int MODE_UNDISPATCHED = 3;

    public static /* synthetic */ void MODE_ATOMIC_DEFAULT$annotations() {
    }

    public static /* synthetic */ void MODE_CANCELLABLE$annotations() {
    }

    public static /* synthetic */ void MODE_DIRECT$annotations() {
    }

    public static /* synthetic */ void MODE_IGNORE$annotations() {
    }

    public static /* synthetic */ void MODE_UNDISPATCHED$annotations() {
    }

    public static final boolean isCancellableMode(int i) {
        return i == 1;
    }

    public static final boolean isDispatchedMode(int i) {
        return i == 0 || i == 1;
    }

    public static final <T> void resumeMode(@NotNull Continuation<? super T> continuation, T t, int i) {
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        if (i == 0) {
            Companion companion = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(t));
        } else if (i == 1) {
            DispatchedKt.resumeCancellable(continuation, t);
        } else if (i == 2) {
            DispatchedKt.resumeDirect(continuation, t);
        } else if (i == 3) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            CoroutineContext context = dispatchedContinuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            try {
                Continuation<T> continuation2 = dispatchedContinuation.continuation;
                Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m1constructorimpl(t));
                Unit unit = Unit.INSTANCE;
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } else if (i != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid mode ");
            sb.append(i);
            throw new IllegalStateException(sb.toString().toString());
        }
    }

    public static final <T> void resumeWithExceptionMode(@NotNull Continuation<? super T> continuation, @NotNull Throwable th, int i) {
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (i == 0) {
            Companion companion = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
        } else if (i == 1) {
            DispatchedKt.resumeCancellableWithException(continuation, th);
        } else if (i == 2) {
            DispatchedKt.resumeDirectWithException(continuation, th);
        } else if (i == 3) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            CoroutineContext context = dispatchedContinuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            try {
                Continuation<T> continuation2 = dispatchedContinuation.continuation;
                Companion companion2 = Result.Companion;
                continuation2.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
                Unit unit = Unit.INSTANCE;
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } else if (i != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid mode ");
            sb.append(i);
            throw new IllegalStateException(sb.toString().toString());
        }
    }

    public static final <T> void resumeUninterceptedMode(@NotNull Continuation<? super T> continuation, T t, int i) {
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        if (i == 0) {
            Continuation intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            Companion companion = Result.Companion;
            intercepted.resumeWith(Result.m1constructorimpl(t));
        } else if (i == 1) {
            DispatchedKt.resumeCancellable(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), t);
        } else if (i == 2) {
            Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(t));
        } else if (i == 3) {
            CoroutineContext context = continuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                Companion companion3 = Result.Companion;
                continuation.resumeWith(Result.m1constructorimpl(t));
                Unit unit = Unit.INSTANCE;
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } else if (i != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid mode ");
            sb.append(i);
            throw new IllegalStateException(sb.toString().toString());
        }
    }

    public static final <T> void resumeUninterceptedWithExceptionMode(@NotNull Continuation<? super T> continuation, @NotNull Throwable th, int i) {
        Intrinsics.checkParameterIsNotNull(continuation, "receiver$0");
        Intrinsics.checkParameterIsNotNull(th, "exception");
        if (i == 0) {
            Continuation intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            Companion companion = Result.Companion;
            intercepted.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
        } else if (i == 1) {
            DispatchedKt.resumeCancellableWithException(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), th);
        } else if (i == 2) {
            Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
        } else if (i == 3) {
            CoroutineContext context = continuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                Companion companion3 = Result.Companion;
                continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
                Unit unit = Unit.INSTANCE;
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        } else if (i != 4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid mode ");
            sb.append(i);
            throw new IllegalStateException(sb.toString().toString());
        }
    }
}
