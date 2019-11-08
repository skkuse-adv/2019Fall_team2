package kr.co.popone.fitts.feature.order;

import android.widget.RadioGroup;
import kotlin.Result.Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DebugMetadata(c = "kr.co.popone.fitts.feature.order.OrderActivity$onCreate$33$1", f = "OrderActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class OrderActivity$onCreate$$inlined$apply$lambda$1 extends SuspendLambda implements Function4<CoroutineScope, RadioGroup, Integer, Continuation<? super Unit>, Object> {
    int label;
    private CoroutineScope p$;
    private RadioGroup p$0;
    private int p$1;
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$$inlined$apply$lambda$1(Continuation continuation, OrderActivity orderActivity) {
        this.this$0 = orderActivity;
        super(4, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @Nullable RadioGroup radioGroup, int i, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "receiver$0");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        OrderActivity$onCreate$$inlined$apply$lambda$1 orderActivity$onCreate$$inlined$apply$lambda$1 = new OrderActivity$onCreate$$inlined$apply$lambda$1(continuation, this.this$0);
        orderActivity$onCreate$$inlined$apply$lambda$1.p$ = coroutineScope;
        orderActivity$onCreate$$inlined$apply$lambda$1.p$0 = radioGroup;
        orderActivity$onCreate$$inlined$apply$lambda$1.p$1 = i;
        return orderActivity$onCreate$$inlined$apply$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return ((OrderActivity$onCreate$$inlined$apply$lambda$1) create((CoroutineScope) obj, (RadioGroup) obj2, ((Number) obj3).intValue(), (Continuation) obj4)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof Failure)) {
            switch (this.p$1) {
                case C0010R$id.radioCreditCard /*2131362741*/:
                    this.this$0.getViewModel().updatePaymentType(PaymentType.CREDIT_CARD);
                    break;
                case C0010R$id.radioDepositlessPay /*2131362742*/:
                    this.this$0.getViewModel().updatePaymentType(PaymentType.DIRECT_DEPOSIT);
                    break;
                case C0010R$id.radioKakaoPay /*2131362747*/:
                    this.this$0.getViewModel().updatePaymentType(PaymentType.KAKAO);
                    break;
            }
            return Unit.INSTANCE;
        } else {
            throw ((Failure) obj).exception;
        }
    }
}
