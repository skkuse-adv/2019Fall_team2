package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.jetbrains.annotations.NotNull;

final class LazyStandaloneCoroutine extends StandaloneCoroutine {
    private final Function2<CoroutineScope, Continuation<? super Unit>, Object> block;

    public LazyStandaloneCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
        Intrinsics.checkParameterIsNotNull(function2, "block");
        super(coroutineContext, false);
        this.block = function2;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        CancellableKt.startCoroutineCancellable(this.block, this, this);
    }
}
