package org.jetbrains.anko.sdk27.coroutines;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

public final class __View_OnAttachStateChangeListener implements OnAttachStateChangeListener {
    private Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> _onViewAttachedToWindow;
    private Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> _onViewDetachedFromWindow;
    private final CoroutineContext context;

    public __View_OnAttachStateChangeListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onViewAttachedToWindow(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onViewAttachedToWindow;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __View_OnAttachStateChangeListener$onViewAttachedToWindow$1(function3, view, null), 2, null);
        }
    }

    public final void onViewAttachedToWindow(@NotNull Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onViewAttachedToWindow = function3;
    }

    public void onViewDetachedFromWindow(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onViewDetachedFromWindow;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __View_OnAttachStateChangeListener$onViewDetachedFromWindow$1(function3, view, null), 2, null);
        }
    }

    public final void onViewDetachedFromWindow(@NotNull Function3<? super CoroutineScope, ? super View, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onViewDetachedFromWindow = function3;
    }
}
