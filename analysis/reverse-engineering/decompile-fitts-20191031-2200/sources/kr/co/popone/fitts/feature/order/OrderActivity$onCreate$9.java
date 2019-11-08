package kr.co.popone.fitts.feature.order;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.ui.custom.DiscountChoiceSelector;
import org.jetbrains.annotations.NotNull;

final class OrderActivity$onCreate$9 extends FunctionReference implements Function1<List<? extends CouponInfo>, Unit> {
    OrderActivity$onCreate$9(DiscountChoiceSelector discountChoiceSelector) {
        super(1, discountChoiceSelector);
    }

    public final String getName() {
        return "setCouponList";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(DiscountChoiceSelector.class);
    }

    public final String getSignature() {
        return "setCouponList(Ljava/util/List;)V";
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull List<CouponInfo> list) {
        Intrinsics.checkParameterIsNotNull(list, "p1");
        ((DiscountChoiceSelector) this.receiver).setCouponList(list);
    }
}
