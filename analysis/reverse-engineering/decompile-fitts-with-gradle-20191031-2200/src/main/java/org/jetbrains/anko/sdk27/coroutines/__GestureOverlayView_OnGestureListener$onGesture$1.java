package org.jetbrains.anko.sdk27.coroutines;

import android.gesture.GestureOverlayView;
import android.view.MotionEvent;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "org/jetbrains/anko/sdk27/coroutines/__GestureOverlayView_OnGestureListener$onGesture$1", f = "ListenersWithCoroutines.kt", i = {}, l = {158, 160}, m = "invokeSuspend", n = {}, s = {})
final class __GestureOverlayView_OnGestureListener$onGesture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MotionEvent $event;
    final /* synthetic */ Function4 $handler;
    final /* synthetic */ GestureOverlayView $overlay;
    int label;
    private CoroutineScope p$;

    __GestureOverlayView_OnGestureListener$onGesture$1(Function4 function4, GestureOverlayView gestureOverlayView, MotionEvent motionEvent, Continuation continuation) {
        this.$handler = function4;
        this.$overlay = gestureOverlayView;
        this.$event = motionEvent;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        __GestureOverlayView_OnGestureListener$onGesture$1 __gestureoverlayview_ongesturelistener_ongesture_1 = new __GestureOverlayView_OnGestureListener$onGesture$1(this.$handler, this.$overlay, this.$event, continuation);
        __gestureoverlayview_ongesturelistener_ongesture_1.p$ = (CoroutineScope) obj;
        return __gestureoverlayview_ongesturelistener_ongesture_1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((__GestureOverlayView_OnGestureListener$onGesture$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (obj instanceof Failure) {
                throw ((Failure) obj).exception;
            }
        } else if (!(obj instanceof Failure)) {
            CoroutineScope coroutineScope = this.p$;
            Function4 function4 = this.$handler;
            GestureOverlayView gestureOverlayView = this.$overlay;
            MotionEvent motionEvent = this.$event;
            this.label = 1;
            if (function4.invoke(coroutineScope, gestureOverlayView, motionEvent, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw ((Failure) obj).exception;
        }
        return Unit.INSTANCE;
    }
}
