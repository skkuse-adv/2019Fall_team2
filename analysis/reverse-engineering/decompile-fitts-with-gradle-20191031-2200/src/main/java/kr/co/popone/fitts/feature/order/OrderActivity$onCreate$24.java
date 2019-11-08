package kr.co.popone.fitts.feature.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.commerce.discount.Discount;
import kr.co.popone.fitts.viewmodel.order.OrderViewModel;
import org.jetbrains.annotations.NotNull;

final class OrderActivity$onCreate$24 extends FunctionReference implements Function1<Discount, Unit> {
    OrderActivity$onCreate$24(OrderViewModel orderViewModel) {
        super(1, orderViewModel);
    }

    public final String getName() {
        return "discountStateChanted";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(OrderViewModel.class);
    }

    public final String getSignature() {
        return "discountStateChanted(Lkr/co/popone/fitts/model/datamodel/commerce/discount/Discount;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Discount) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Discount discount) {
        Intrinsics.checkParameterIsNotNull(discount, "p1");
        ((OrderViewModel) this.receiver).discountStateChanted(discount);
    }
}
