package kr.co.popone.fitts.feature.cart;

import androidx.lifecycle.Observer;
import kotlin.Unit;

final class CartActivity$onCreate$18<T> implements Observer<Unit> {
    final /* synthetic */ CartActivity this$0;

    CartActivity$onCreate$18(CartActivity cartActivity) {
        this.this$0 = cartActivity;
    }

    public final void onChanged(Unit unit) {
        this.this$0.cartAdatper.updateEmptyLineItem();
    }
}
