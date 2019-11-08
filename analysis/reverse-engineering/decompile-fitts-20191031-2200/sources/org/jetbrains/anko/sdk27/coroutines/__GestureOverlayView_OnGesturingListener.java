package org.jetbrains.anko.sdk27.coroutines;

import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturingListener;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class __GestureOverlayView_OnGesturingListener implements OnGesturingListener {
    private Function3<? super CoroutineScope, ? super GestureOverlayView, ? super Continuation<? super Unit>, ? extends Object> _onGesturingEnded;
    private Function3<? super CoroutineScope, ? super GestureOverlayView, ? super Continuation<? super Unit>, ? extends Object> _onGesturingStarted;
    private final CoroutineContext context;

    public __GestureOverlayView_OnGesturingListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onGesturingStarted(@Nullable GestureOverlayView gestureOverlayView) {
        Function3<? super CoroutineScope, ? super GestureOverlayView, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onGesturingStarted;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __GestureOverlayView_OnGesturingListener$onGesturingStarted$1(function3, gestureOverlayView, null), 2, null);
        }
    }

    public final void onGesturingStarted(@NotNull Function3<? super CoroutineScope, ? super GestureOverlayView, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onGesturingStarted = function3;
    }

    public void onGesturingEnded(@Nullable GestureOverlayView gestureOverlayView) {
        Function3<? super CoroutineScope, ? super GestureOverlayView, ? super Continuation<? super Unit>, ? extends Object> function3 = this._onGesturingEnded;
        if (function3 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __GestureOverlayView_OnGesturingListener$onGesturingEnded$1(function3, gestureOverlayView, null), 2, null);
        }
    }

    public final void onGesturingEnded(@NotNull Function3<? super CoroutineScope, ? super GestureOverlayView, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkParameterIsNotNull(function3, "listener");
        this._onGesturingEnded = function3;
    }
}
