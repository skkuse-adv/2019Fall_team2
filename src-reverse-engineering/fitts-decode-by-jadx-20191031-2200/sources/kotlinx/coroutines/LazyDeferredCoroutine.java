package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.jetbrains.annotations.NotNull;

final class LazyDeferredCoroutine<T> extends DeferredCoroutine<T> {
    private final Function2<CoroutineScope, Continuation<? super T>, Object> block;

    public LazyDeferredCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
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
