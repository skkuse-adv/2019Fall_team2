package kr.co.popone.fitts.feature.cart;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartLineItemsDomain;

final class CartActivity$onCreate$16<T> implements Observer<CartLineItemsDomain> {
    final /* synthetic */ CartActivity this$0;

    CartActivity$onCreate$16(CartActivity cartActivity) {
        this.this$0 = cartActivity;
    }

    public final void onChanged(CartLineItemsDomain cartLineItemsDomain) {
        CartAdatper access$getCartAdatper$p = this.this$0.cartAdatper;
        if (cartLineItemsDomain == null) {
            Intrinsics.throwNpe();
        }
        access$getCartAdatper$p.updateTotalPrice(cartLineItemsDomain);
    }
}
