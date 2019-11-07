package kotlinx.coroutines;

import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import org.jetbrains.annotations.NotNull;

public enum CoroutineStart {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            $EnumSwitchMapping$0 = new int[CoroutineStart.values().length];
            $EnumSwitchMapping$0[CoroutineStart.DEFAULT.ordinal()] = 1;
            $EnumSwitchMapping$0[CoroutineStart.ATOMIC.ordinal()] = 2;
            $EnumSwitchMapping$0[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            $EnumSwitchMapping$0[CoroutineStart.LAZY.ordinal()] = 4;
            $EnumSwitchMapping$1 = new int[CoroutineStart.values().length];
            $EnumSwitchMapping$1[CoroutineStart.DEFAULT.ordinal()] = 1;
            $EnumSwitchMapping$1[CoroutineStart.ATOMIC.ordinal()] = 2;
            $EnumSwitchMapping$1[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            $EnumSwitchMapping$1[CoroutineStart.LAZY.ordinal()] = 4;
        }
    }

    public final <T> void invoke(@NotNull Function1<? super Continuation<? super T>, ? extends Object> function1, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            CancellableKt.startCoroutineCancellable(function1, continuation);
        } else if (i == 2) {
            ContinuationKt.startCoroutine(function1, continuation);
        } else if (i == 3) {
            UndispatchedKt.startCoroutineUndispatched(function1, continuation);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final <R, T> void invoke(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(function2, "block");
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        int i = WhenMappings.$EnumSwitchMapping$1[ordinal()];
        if (i == 1) {
            CancellableKt.startCoroutineCancellable(function2, r, continuation);
        } else if (i == 2) {
            ContinuationKt.startCoroutine(function2, r, continuation);
        } else if (i == 3) {
            UndispatchedKt.startCoroutineUndispatched(function2, r, continuation);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        return this == LAZY;
    }
}
