package org.jetbrains.anko.sdk27.coroutines;

import android.view.View;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "org/jetbrains/anko/sdk27/coroutines/__View_OnAttachStateChangeListener$onViewAttachedToWindow$1", f = "ListenersWithCoroutines.kt", i = {}, l = {40, 42}, m = "invokeSuspend", n = {}, s = {})
final class __View_OnAttachStateChangeListener$onViewAttachedToWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3 $handler;
    final /* synthetic */ View $v;
    int label;
    private CoroutineScope p$;

    __View_OnAttachStateChangeListener$onViewAttachedToWindow$1(Function3 function3, View view, Continuation continuation) {
        this.$handler = function3;
        this.$v = view;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        __View_OnAttachStateChangeListener$onViewAttachedToWindow$1 __view_onattachstatechangelistener_onviewattachedtowindow_1 = new __View_OnAttachStateChangeListener$onViewAttachedToWindow$1(this.$handler, this.$v, continuation);
        __view_onattachstatechangelistener_onviewattachedtowindow_1.p$ = (CoroutineScope) obj;
        return __view_onattachstatechangelistener_onviewattachedtowindow_1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((__View_OnAttachStateChangeListener$onViewAttachedToWindow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
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
            Function3 function3 = this.$handler;
            View view = this.$v;
            this.label = 1;
            if (function3.invoke(coroutineScope, view, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw ((Failure) obj).exception;
        }
        return Unit.INSTANCE;
    }
}
