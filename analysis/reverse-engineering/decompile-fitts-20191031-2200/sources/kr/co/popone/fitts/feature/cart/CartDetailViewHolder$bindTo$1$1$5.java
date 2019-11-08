package kr.co.popone.fitts.feature.cart;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.CartEvent$VariantsRemoveEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.cart.CartVariantsItem;

final class CartDetailViewHolder$bindTo$1$1$5 implements OnClickListener {
    final /* synthetic */ CartVariantsItem $this_run;

    CartDetailViewHolder$bindTo$1$1$5(CartVariantsItem cartVariantsItem) {
        this.$this_run = cartVariantsItem;
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new CartEvent$VariantsRemoveEvent(this.$this_run.getLineItemId()));
    }
}
