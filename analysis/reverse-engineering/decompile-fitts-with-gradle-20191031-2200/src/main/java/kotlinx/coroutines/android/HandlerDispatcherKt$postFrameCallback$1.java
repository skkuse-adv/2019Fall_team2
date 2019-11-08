package kotlinx.coroutines.android;

import android.view.Choreographer.FrameCallback;
import kotlinx.coroutines.CancellableContinuation;

final class HandlerDispatcherKt$postFrameCallback$1 implements FrameCallback {
    final /* synthetic */ CancellableContinuation $cont;

    HandlerDispatcherKt$postFrameCallback$1(CancellableContinuation cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    public final void doFrame(long j) {
        this.$cont.resumeUndispatched(HandlerDispatcherKt.Main, Long.valueOf(j));
    }
}
