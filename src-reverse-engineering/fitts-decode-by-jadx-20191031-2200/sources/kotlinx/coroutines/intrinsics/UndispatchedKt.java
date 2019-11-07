package kotlinx.coroutines.intrinsics;

import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UndispatchedKt {
    public static final <T> void startCoroutineUnintercepted(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function1, "receiver$0");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        try {
            Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(continuation);
            if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Companion companion = Result.Companion;
                continuation.resumeWith(Result.m1constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineUnintercepted(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function2, "receiver$0");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        try {
            Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuation);
            if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Companion companion = Result.Companion;
                continuation.resumeWith(Result.m1constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <T> void startCoroutineUndispatched(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        CoroutineContext context;
        Object updateThreadContext;
        Intrinsics.checkParameterIsNotNull(function1, "receiver$0");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        try {
            context = continuation.getContext();
            updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            Object invoke = ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(continuation);
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Companion companion = Result.Companion;
                continuation.resumeWith(Result.m1constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineUndispatched(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        CoroutineContext context;
        Object updateThreadContext;
        Intrinsics.checkParameterIsNotNull(function2, "receiver$0");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        try {
            context = continuation.getContext();
            updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            Object invoke = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuation);
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            if (invoke != IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                Companion companion = Result.Companion;
                continuation.resumeWith(Result.m1constructorimpl(invoke));
            }
        } catch (Throwable th) {
            Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m1constructorimpl(ResultKt.createFailure(th)));
        }
    }

    @Nullable
    public static final <T, R> Object startUndispatchedOrReturn(@NotNull AbstractCoroutine<? super T> abstractCoroutine, R r, @NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(abstractCoroutine, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        abstractCoroutine.initParentJob$kotlinx_coroutines_core();
        try {
            obj = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, abstractCoroutine);
        } catch (Throwable th) {
            obj = new CompletedExceptionally(th);
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!abstractCoroutine.makeCompletingOnce$kotlinx_coroutines_core(obj, 4)) {
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (!(obj instanceof CompletedExceptionally)) {
            return obj;
        }
        throw ((CompletedExceptionally) obj).cause;
    }
}
