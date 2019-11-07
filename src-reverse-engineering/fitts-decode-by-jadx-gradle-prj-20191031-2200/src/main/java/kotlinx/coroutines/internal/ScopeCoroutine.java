package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CompletedExceptionally;
import kotlinx.coroutines.ResumeModeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ScopeCoroutine<T> extends AbstractCoroutine<T> {
    @NotNull
    public final Continuation<T> uCont;

    public int getDefaultResumeMode$kotlinx_coroutines_core() {
        return 2;
    }

    public ScopeCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(continuation, "uCont");
        super(coroutineContext, true);
        this.uCont = continuation;
    }

    public void onCompletionInternal$kotlinx_coroutines_core(@Nullable Object obj, int i, boolean z) {
        if (obj instanceof CompletedExceptionally) {
            ResumeModeKt.resumeUninterceptedWithExceptionMode(this.uCont, ((CompletedExceptionally) obj).cause, i);
        } else {
            ResumeModeKt.resumeUninterceptedMode(this.uCont, obj, i);
        }
    }
}
