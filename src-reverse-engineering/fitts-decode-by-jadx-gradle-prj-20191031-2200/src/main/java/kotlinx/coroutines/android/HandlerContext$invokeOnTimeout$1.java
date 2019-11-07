package kotlinx.coroutines.android;

import kotlinx.coroutines.DisposableHandle;

public final class HandlerContext$invokeOnTimeout$1 implements DisposableHandle {
    final /* synthetic */ Runnable $block;
    final /* synthetic */ HandlerContext this$0;

    HandlerContext$invokeOnTimeout$1(HandlerContext handlerContext, Runnable runnable) {
        this.this$0 = handlerContext;
        this.$block = runnable;
    }

    public void dispose() {
        this.this$0.handler.removeCallbacks(this.$block);
    }
}
