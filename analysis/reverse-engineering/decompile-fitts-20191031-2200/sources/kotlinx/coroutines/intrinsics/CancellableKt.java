package kotlinx.coroutines.intrinsics;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DispatchedKt;
import org.jetbrains.annotations.NotNull;

public final class CancellableKt {
    public static final <T> void startCoroutineCancellable(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function1, "receiver$0");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        DispatchedKt.resumeCancellable(IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function1, continuation)), Unit.INSTANCE);
    }

    public static final <R, T> void startCoroutineCancellable(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function2, "receiver$0");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        DispatchedKt.resumeCancellable(IntrinsicsKt__IntrinsicsJvmKt.intercepted(IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(function2, r, continuation)), Unit.INSTANCE);
    }
}
