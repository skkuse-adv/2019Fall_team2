package org.jetbrains.anko.sdk27.coroutines;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "org/jetbrains/anko/sdk27/coroutines/__AdapterView_OnItemSelectedListener$onItemSelected$1", f = "ListenersWithCoroutines.kt", i = {}, l = {590, 592}, m = "invokeSuspend", n = {}, s = {})
final class __AdapterView_OnItemSelectedListener$onItemSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function6 $handler;
    final /* synthetic */ AdapterView $p0;
    final /* synthetic */ View $p1;
    final /* synthetic */ int $p2;
    final /* synthetic */ long $p3;
    int label;
    private CoroutineScope p$;

    __AdapterView_OnItemSelectedListener$onItemSelected$1(Function6 function6, AdapterView adapterView, View view, int i, long j, Continuation continuation) {
        this.$handler = function6;
        this.$p0 = adapterView;
        this.$p1 = view;
        this.$p2 = i;
        this.$p3 = j;
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        __AdapterView_OnItemSelectedListener$onItemSelected$1 __adapterview_onitemselectedlistener_onitemselected_1 = new __AdapterView_OnItemSelectedListener$onItemSelected$1(this.$handler, this.$p0, this.$p1, this.$p2, this.$p3, continuation);
        __adapterview_onitemselectedlistener_onitemselected_1.p$ = (CoroutineScope) obj;
        return __adapterview_onitemselectedlistener_onitemselected_1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((__AdapterView_OnItemSelectedListener$onItemSelected$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
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
            Function6 function6 = this.$handler;
            AdapterView adapterView = this.$p0;
            View view = this.$p1;
            Integer boxInt = Boxing.boxInt(this.$p2);
            Long boxLong = Boxing.boxLong(this.$p3);
            this.label = 1;
            if (function6.invoke(coroutineScope, adapterView, view, boxInt, boxLong, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            throw ((Failure) obj).exception;
        }
        return Unit.INSTANCE;
    }
}
