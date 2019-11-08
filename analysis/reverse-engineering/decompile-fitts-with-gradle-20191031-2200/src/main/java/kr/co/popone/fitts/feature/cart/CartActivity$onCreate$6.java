package kr.co.popone.fitts.feature.cart;

import androidx.lifecycle.Observer;

final class CartActivity$onCreate$6<T> implements Observer<Integer> {
    final /* synthetic */ CartActivity this$0;

    CartActivity$onCreate$6(CartActivity cartActivity) {
        this.this$0 = cartActivity;
    }

    public final void onChanged(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            CartActivity cartActivity = this.this$0;
            boolean z = true;
            if (intValue >= 1) {
                z = false;
            }
            cartActivity.updateLayoutVisiblity(z);
        }
    }
}
