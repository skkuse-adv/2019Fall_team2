package kr.co.popone.fitts.feature.cart;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion;
import kr.co.popone.fitts.model.cart.CartVariantsItem;

final class CartDetailViewHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ CartVariantsItem $this_run;
    final /* synthetic */ View $this_with$inlined;

    CartDetailViewHolder$bindTo$$inlined$with$lambda$1(CartVariantsItem cartVariantsItem, View view, CartDetailViewHolder cartDetailViewHolder, CartVariantsItem cartVariantsItem2, int i) {
        this.$this_run = cartVariantsItem;
        this.$this_with$inlined = view;
    }

    public final void onClick(View view) {
        String storeLinkUrl = this.$this_run.getStoreLinkUrl();
        if (storeLinkUrl != null) {
            Companion.start$default(StoreBrowserActivity.Companion, this.$this_with$inlined.getContext(), storeLinkUrl, "cart", null, null, 24, null);
        }
    }
}
