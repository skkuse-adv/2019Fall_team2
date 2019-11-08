package org.jetbrains.anko.sdk27.coroutines;

import android.view.View;
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

@DebugMetadata(c = "org/jetbrains/anko/sdk27/coroutines/__ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1", f = "ListenersWithCoroutines.kt", i = {}, l = {456, 458}, m = "invokeSuspend", n = {}, s = {})
final class __ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $child;
    final /* synthetic */ Function4 $handler;
    final /* synthetic */ View $parent;
    int label;
    private CoroutineScope p$;

    __ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1(Function4 function4, View view, View view2, Continuation continuation) {
        this.$handler = function4;
        this.$parent = view;
        this.$child = view2;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        __ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1 __viewgroup_onhierarchychangelistener_onchildviewadded_1 = new __ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1(this.$handler, this.$parent, this.$child, continuation);
        __viewgroup_onhierarchychangelistener_onchildviewadded_1.p$ = (CoroutineScope) obj;
        return __viewgroup_onhierarchychangelistener_onchildviewadded_1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((__ViewGroup_OnHierarchyChangeListener$onChildViewAdded$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
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
            View view = this.$parent;
            View view2 = this.$child;
            this.label = 1;
            if (function4.invoke(coroutineScope, view, view2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw ((Failure) obj).exception;
        }
        return Unit.INSTANCE;
    }
}
