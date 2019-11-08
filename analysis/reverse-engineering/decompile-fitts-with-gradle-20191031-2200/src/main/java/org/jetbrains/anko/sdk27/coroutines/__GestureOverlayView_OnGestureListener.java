package org.jetbrains.anko.sdk27.coroutines;

import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.view.MotionEvent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class __GestureOverlayView_OnGestureListener implements OnGestureListener {
    private Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> _onGesture;
    private Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> _onGestureCancelled;
    private Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> _onGestureEnded;
    private Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> _onGestureStarted;
    private final CoroutineContext context;

    public __GestureOverlayView_OnGestureListener(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        this.context = coroutineContext;
    }

    public void onGestureStarted(@Nullable GestureOverlayView gestureOverlayView, @Nullable MotionEvent motionEvent) {
        Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4 = this._onGestureStarted;
        if (function4 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __GestureOverlayView_OnGestureListener$onGestureStarted$1(function4, gestureOverlayView, motionEvent, null), 2, null);
        }
    }

    public final void onGestureStarted(@NotNull Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "listener");
        this._onGestureStarted = function4;
    }

    public void onGesture(@Nullable GestureOverlayView gestureOverlayView, @Nullable MotionEvent motionEvent) {
        Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4 = this._onGesture;
        if (function4 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __GestureOverlayView_OnGestureListener$onGesture$1(function4, gestureOverlayView, motionEvent, null), 2, null);
        }
    }

    public final void onGesture(@NotNull Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "listener");
        this._onGesture = function4;
    }

    public void onGestureEnded(@Nullable GestureOverlayView gestureOverlayView, @Nullable MotionEvent motionEvent) {
        Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4 = this._onGestureEnded;
        if (function4 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __GestureOverlayView_OnGestureListener$onGestureEnded$1(function4, gestureOverlayView, motionEvent, null), 2, null);
        }
    }

    public final void onGestureEnded(@NotNull Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "listener");
        this._onGestureEnded = function4;
    }

    public void onGestureCancelled(@Nullable GestureOverlayView gestureOverlayView, @Nullable MotionEvent motionEvent) {
        Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4 = this._onGestureCancelled;
        if (function4 != null) {
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, this.context, null, new __GestureOverlayView_OnGestureListener$onGestureCancelled$1(function4, gestureOverlayView, motionEvent, null), 2, null);
        }
    }

    public final void onGestureCancelled(@NotNull Function4<? super CoroutineScope, ? super GestureOverlayView, ? super MotionEvent, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Intrinsics.checkParameterIsNotNull(function4, "listener");
        this._onGestureCancelled = function4;
    }
}
