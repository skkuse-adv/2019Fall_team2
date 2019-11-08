package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "kotlinx/coroutines/DeferredCoroutine", f = "Builders.common.kt", i = {0}, l = {99, 99}, m = "await$suspendImpl", n = {"this"}, s = {"L$0"})
final class DeferredCoroutine$await$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeferredCoroutine this$0;

    DeferredCoroutine$await$1(DeferredCoroutine deferredCoroutine, Continuation continuation) {
        this.this$0 = deferredCoroutine;
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DeferredCoroutine.await$suspendImpl(this.this$0, this);
    }
}
