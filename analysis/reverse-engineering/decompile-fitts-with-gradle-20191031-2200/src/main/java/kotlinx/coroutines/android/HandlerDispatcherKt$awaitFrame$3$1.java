package kotlinx.coroutines.android;

import kotlinx.coroutines.CancellableContinuation;

final class HandlerDispatcherKt$awaitFrame$3$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $cont;

    HandlerDispatcherKt$awaitFrame$3$1(CancellableContinuation cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    public final void run() {
        HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(this.$cont);
    }
}
