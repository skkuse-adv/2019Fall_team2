package kr.co.popone.fitts.feature.order;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

final class OrderActivity$onCreate$16 extends FunctionReference implements Function1<Boolean, Unit> {
    OrderActivity$onCreate$16(OrderActivity orderActivity) {
        super(1, orderActivity);
    }

    public final String getName() {
        return "updateDiscountView";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(OrderActivity.class);
    }

    public final String getSignature() {
        return "updateDiscountView(Z)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ((OrderActivity) this.receiver).updateDiscountView(z);
    }
}
