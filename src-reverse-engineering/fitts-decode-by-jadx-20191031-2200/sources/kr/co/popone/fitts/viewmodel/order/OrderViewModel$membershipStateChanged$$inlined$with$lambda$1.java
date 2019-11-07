package kr.co.popone.fitts.viewmodel.order;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.datamodel.commerce.discount.Discount;
import kr.co.popone.fitts.model.datamodel.commerce.discount.Discount.Type;
import kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;

final class OrderViewModel$membershipStateChanged$$inlined$with$lambda$1<T> implements Consumer<ProductLineItem> {
    final /* synthetic */ Membership $membership$inlined;
    final /* synthetic */ OrderViewModel this$0;

    OrderViewModel$membershipStateChanged$$inlined$with$lambda$1(OrderViewModel orderViewModel, Membership membership) {
        this.this$0 = orderViewModel;
        this.$membership$inlined = membership;
    }

    public final void accept(ProductLineItem productLineItem) {
        this.this$0.getExpectedReceivablePoint(Discount.Companion.m146new(Type.MEMBERSHIP, null, null, this.$membership$inlined));
    }
}
