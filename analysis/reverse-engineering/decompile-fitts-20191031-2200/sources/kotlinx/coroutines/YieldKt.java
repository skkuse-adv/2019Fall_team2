package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class YieldKt {
    @Nullable
    public static final Object yield(@NotNull Continuation<? super Unit> continuation) {
        Object obj;
        CoroutineContext context = continuation.getContext();
        checkCompletion(context);
        Continuation intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        if (!(intercepted instanceof DispatchedContinuation)) {
            intercepted = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) intercepted;
        if (dispatchedContinuation == null) {
            obj = Unit.INSTANCE;
        } else if (!dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
            obj = DispatchedKt.yieldUndispatched(dispatchedContinuation) ? IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() : Unit.INSTANCE;
        } else {
            dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(Unit.INSTANCE);
            obj = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (obj == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return obj;
    }

    public static final void checkCompletion(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "receiver$0");
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null && !job.isActive()) {
            throw job.getCancellationException();
        }
    }
}
