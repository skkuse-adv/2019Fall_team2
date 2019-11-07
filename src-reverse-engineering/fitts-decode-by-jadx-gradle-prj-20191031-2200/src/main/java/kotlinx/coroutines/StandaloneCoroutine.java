package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    /* access modifiers changed from: protected */
    public boolean getCancelsParent() {
        return true;
    }

    public StandaloneCoroutine(@NotNull CoroutineContext coroutineContext, boolean z) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        super(coroutineContext, z);
    }

    /* access modifiers changed from: protected */
    public void handleJobException(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        CoroutineExceptionHandlerKt.handleExceptionViaHandler(this.parentContext, th);
    }
}
