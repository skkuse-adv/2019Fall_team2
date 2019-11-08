package kotlinx.coroutines.android;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class HandlerContext$scheduleResumeAfterDelay$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Runnable $block;
    final /* synthetic */ HandlerContext this$0;

    HandlerContext$scheduleResumeAfterDelay$1(HandlerContext handlerContext, Runnable runnable) {
        this.this$0 = handlerContext;
        this.$block = runnable;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th) {
        this.this$0.handler.removeCallbacks(this.$block);
    }
}
