package kr.co.popone.fitts.feature.cart;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.cart.CartLineItemsDomain;

final class CartActivity$onCreate$10<T> implements Observer<CartLineItemsDomain> {
    final /* synthetic */ CartActivity this$0;

    CartActivity$onCreate$10(CartActivity cartActivity) {
        this.this$0 = cartActivity;
    }

    public final void onChanged(CartLineItemsDomain cartLineItemsDomain) {
        this.this$0.calculateTotalPrice();
    }
}
