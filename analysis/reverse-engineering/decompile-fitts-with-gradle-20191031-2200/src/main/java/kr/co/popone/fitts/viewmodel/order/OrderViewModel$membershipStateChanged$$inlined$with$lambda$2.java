package kr.co.popone.fitts.viewmodel.order;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderPrice;
import kr.co.popone.fitts.model.datamodel.commerce.discount.OrderPrice.Companion;
import kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem;
import kr.co.popone.fitts.model.datamodel.social.membership.Membership;

final class OrderViewModel$membershipStateChanged$$inlined$with$lambda$2<T> implements Consumer<ProductLineItem> {
    final /* synthetic */ Membership $membership$inlined;
    final /* synthetic */ OrderViewModel this$0;

    OrderViewModel$membershipStateChanged$$inlined$with$lambda$2(OrderViewModel orderViewModel, Membership membership) {
        this.this$0 = orderViewModel;
        this.$membership$inlined = membership;
    }

    public final void accept(ProductLineItem productLineItem) {
        this.this$0._membershipLiveData.setValue(this.$membership$inlined);
        Companion companion = OrderPrice.Companion;
        Intrinsics.checkExpressionValueIsNotNull(productLineItem, "it");
        OrderPrice orderPrice = companion.m147new(productLineItem);
        this.this$0._haveToPaymentLiveData.setValue(Boolean.valueOf(orderPrice.haveToPay()));
        this.this$0._orderPriceLiveData.setValue(orderPrice);
        this.this$0._membershipNotUsableReasonLiveData.setValue("");
    }
}
