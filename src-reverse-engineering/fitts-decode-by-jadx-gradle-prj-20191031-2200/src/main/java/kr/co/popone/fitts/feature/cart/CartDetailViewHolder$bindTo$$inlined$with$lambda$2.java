package kr.co.popone.fitts.feature.cart;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import kr.co.popone.fitts.event.CartEvent$VariantCheckStateChangeEvent;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.model.cart.CartVariantsItem;

final class CartDetailViewHolder$bindTo$$inlined$with$lambda$2 implements OnCheckedChangeListener {
    final /* synthetic */ int $position$inlined;
    final /* synthetic */ CartVariantsItem $this_run;
    final /* synthetic */ CartDetailViewHolder this$0;

    CartDetailViewHolder$bindTo$$inlined$with$lambda$2(CartVariantsItem cartVariantsItem, View view, CartDetailViewHolder cartDetailViewHolder, CartVariantsItem cartVariantsItem2, int i) {
        this.$this_run = cartVariantsItem;
        this.this$0 = cartDetailViewHolder;
        this.$position$inlined = i;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.$this_run.isCheckedOption() != z) {
            this.$this_run.setCheckedOption(z);
            this.this$0.delegate.onCheckStateChanged(z, this.$position$inlined);
            RxBus.INSTANCE.post(new CartEvent$VariantCheckStateChangeEvent());
        }
    }
}
