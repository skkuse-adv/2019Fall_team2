package kr.co.popone.fitts.feature.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderPrice;
import org.jetbrains.annotations.NotNull;

final class OrderActivity$onCreate$14 extends FunctionReference implements Function1<OrderPrice, Unit> {
    OrderActivity$onCreate$14(OrderActivity orderActivity) {
        super(1, orderActivity);
    }

    public final String getName() {
        return "updatePriceInfoView";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(OrderActivity.class);
    }

    public final String getSignature() {
        return "updatePriceInfoView(Lkr/co/popone/fitts/model/datamodel/commerce/discount/OrderPrice;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((OrderPrice) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull OrderPrice orderPrice) {
        Intrinsics.checkParameterIsNotNull(orderPrice, "p1");
        ((OrderActivity) this.receiver).updatePriceInfoView(orderPrice);
    }
}
