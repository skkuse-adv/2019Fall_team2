package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface Delay {

    public static final class DefaultImpls {
        @Nullable
        public static Object delay(Delay delay, long j, @NotNull Continuation<? super Unit> continuation) {
            if (j <= 0) {
                return Unit.INSTANCE;
            }
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            delay.scheduleResumeAfterDelay(j, cancellableContinuationImpl);
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }

        @NotNull
        public static DisposableHandle invokeOnTimeout(Delay delay, long j, @NotNull Runnable runnable) {
            Intrinsics.checkParameterIsNotNull(runnable, "block");
            return DefaultExecutorKt.getDefaultDelay().invokeOnTimeout(j, runnable);
        }
    }

    @Nullable
    Object delay(long j, @NotNull Continuation<? super Unit> continuation);

    @NotNull
    DisposableHandle invokeOnTimeout(long j, @NotNull Runnable runnable);

    void scheduleResumeAfterDelay(long j, @NotNull CancellableContinuation<? super Unit> cancellableContinuation);
}
