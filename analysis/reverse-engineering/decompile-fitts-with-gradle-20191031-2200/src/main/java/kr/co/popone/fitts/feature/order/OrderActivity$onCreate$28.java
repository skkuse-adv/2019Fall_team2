package kr.co.popone.fitts.feature.order;

import android.widget.CompoundButton;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "kr.co.popone.fitts.feature.order.OrderActivity$onCreate$28", f = "OrderActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OrderActivity$onCreate$28 extends SuspendLambda implements Function4<CoroutineScope, CompoundButton, Boolean, Continuation<? super Unit>, Object> {
    int label;
    private CoroutineScope p$;
    private CompoundButton p$0;
    private boolean p$1;
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$28(OrderActivity orderActivity, Continuation continuation) {
        this.this$0 = orderActivity;
        super(4, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @Nullable CompoundButton compoundButton, boolean z, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "receiver$0");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        OrderActivity$onCreate$28 orderActivity$onCreate$28 = new OrderActivity$onCreate$28(this.this$0, continuation);
        orderActivity$onCreate$28.p$ = coroutineScope;
        orderActivity$onCreate$28.p$0 = compoundButton;
        orderActivity$onCreate$28.p$1 = z;
        return orderActivity$onCreate$28;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return ((OrderActivity$onCreate$28) create((CoroutineScope) obj, (CompoundButton) obj2, ((Boolean) obj3).booleanValue(), (Continuation) obj4)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof Failure)) {
            boolean z = this.p$1;
            this.this$0.getViewModel().addressInfoCheckChanged(z);
            if (z) {
                this.this$0.updateNameAndContact();
            }
            return Unit.INSTANCE;
        } else {
            throw ((Failure) obj).exception;
        }
    }
}
