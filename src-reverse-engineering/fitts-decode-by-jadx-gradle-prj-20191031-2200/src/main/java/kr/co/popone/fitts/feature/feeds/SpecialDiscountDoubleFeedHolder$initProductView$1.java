package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount;

final class SpecialDiscountDoubleFeedHolder$initProductView$1 implements OnClickListener {
    final /* synthetic */ long $eventId;
    final /* synthetic */ SpecialDiscount $item;
    final /* synthetic */ SpecialDiscountDoubleFeedHolder this$0;

    SpecialDiscountDoubleFeedHolder$initProductView$1(SpecialDiscountDoubleFeedHolder specialDiscountDoubleFeedHolder, SpecialDiscount specialDiscount, long j) {
        this.this$0 = specialDiscountDoubleFeedHolder;
        this.$item = specialDiscount;
        this.$eventId = j;
    }

    public final void onClick(View view) {
        if (this.$item.getProduct() != null) {
            this.this$0.delegate.onSpecialDiscountClick(this.$item.getProduct().getId(), this.$eventId, this.$item.getProduct().getShopLinkUrl());
        }
    }
}
