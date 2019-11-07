package kr.co.popone.fitts.feature.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.viewmodel.order.OrderViewModel.PaymentType;
import org.jetbrains.annotations.NotNull;

final class OrderActivity$onCreate$8 extends FunctionReference implements Function1<PaymentType, Unit> {
    OrderActivity$onCreate$8(OrderActivity orderActivity) {
        super(1, orderActivity);
    }

    public final String getName() {
        return "updatePaymentTypeView";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(OrderActivity.class);
    }

    public final String getSignature() {
        return "updatePaymentTypeView(Lkr/co/popone/fitts/viewmodel/order/OrderViewModel$PaymentType;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PaymentType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PaymentType paymentType) {
        Intrinsics.checkParameterIsNotNull(paymentType, "p1");
        ((OrderActivity) this.receiver).updatePaymentTypeView(paymentType);
    }
}
