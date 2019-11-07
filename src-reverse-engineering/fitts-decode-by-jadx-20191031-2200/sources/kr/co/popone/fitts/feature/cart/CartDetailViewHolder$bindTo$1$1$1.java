package kr.co.popone.fitts.feature.cart;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.CartEvent$VariantsEditEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.cart.CartVariantsItem;

final class CartDetailViewHolder$bindTo$1$1$1 implements OnClickListener {
    final /* synthetic */ CartVariantsItem $this_run;

    CartDetailViewHolder$bindTo$1$1$1(CartVariantsItem cartVariantsItem) {
        this.$this_run = cartVariantsItem;
    }

    public final void onClick(View view) {
        if (this.$this_run.getProductCount() > 1) {
            CartVariantsItem cartVariantsItem = this.$this_run;
            cartVariantsItem.setProductCount(cartVariantsItem.getProductCount() - 1);
            RxBus.INSTANCE.post(new CartEvent$VariantsEditEvent(this.$this_run.getLineItemId(), this.$this_run.getProductCount()));
        }
    }
}
