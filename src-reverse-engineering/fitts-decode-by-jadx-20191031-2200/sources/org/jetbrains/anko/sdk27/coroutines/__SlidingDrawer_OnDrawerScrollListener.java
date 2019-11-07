package org.jetbrains.anko.sdk27.coroutines;

import android.widget.SlidingDrawer.OnDrawerScrollListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

public final class __SlidingDrawer_OnDrawerScrollListener implements OnDrawerScrollListener {
    private Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> _onScrollEnded;
    private Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> _onScrollStarted;
    private final CoroutineContext context;

    public __SlidingDrawer_OnDrawerScrollListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onScrollStarted() {
        Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2 = this._onScrollStarted;
        if (function2 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, function2, 2, null);
        }
    }

    public final void onScrollStarted(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "listener");
        this._onScrollStarted = function2;
    }

    public void onScrollEnded() {
        Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2 = this._onScrollEnded;
        if (function2 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, function2, 2, null);
        }
    }

    public final void onScrollEnded(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "listener");
        this._onScrollEnded = function2;
    }
}
