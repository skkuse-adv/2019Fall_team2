package kr.co.popone.fitts.ui.custom;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponInfo;
import kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Type;

final class DiscountChoiceSelector$setCouponList$$inlined$apply$lambda$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ List $coupons$inlined;
    final /* synthetic */ DiscountChoiceSelector this$0;

    DiscountChoiceSelector$setCouponList$$inlined$apply$lambda$2(DiscountChoiceSelector discountChoiceSelector, List list) {
        this.this$0 = discountChoiceSelector;
        this.$coupons$inlined = list;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.this$0.updateDiscount(Type.COUPON, null, (CouponInfo) this.$coupons$inlined.get(i - 1), null);
    }
}
