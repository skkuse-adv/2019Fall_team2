package kotlinx.coroutines.android;

import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

public final class HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $continuation$inlined;
    final /* synthetic */ HandlerContext this$0;

    public HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(HandlerContext handlerContext, CancellableContinuation cancellableContinuation) {
        this.this$0 = handlerContext;
        this.$continuation$inlined = cancellableContinuation;
    }

    public final void run() {
        this.$continuation$inlined.resumeUndispatched(this.this$0, Unit.INSTANCE);
    }
}
