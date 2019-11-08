package kr.co.popone.fitts.feature.store.newest;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount;

final class SpecialDiscountProductHolder$initProductView$1 implements OnClickListener {
    final /* synthetic */ long $eventId;
    final /* synthetic */ SpecialDiscount $item;
    final /* synthetic */ SpecialDiscountProductHolder this$0;

    SpecialDiscountProductHolder$initProductView$1(SpecialDiscountProductHolder specialDiscountProductHolder, SpecialDiscount specialDiscount, long j) {
        this.this$0 = specialDiscountProductHolder;
        this.$item = specialDiscount;
        this.$eventId = j;
    }

    public final void onClick(View view) {
        SpecialDiscount specialDiscount = this.$item;
        if ((specialDiscount != null ? specialDiscount.getProduct() : null) != null) {
            this.this$0.getDelegate().onSpecialDiscountClick(this.$item.getProduct().getId(), this.$eventId, this.$item.getProduct().getShopLinkUrl());
        }
    }
}
