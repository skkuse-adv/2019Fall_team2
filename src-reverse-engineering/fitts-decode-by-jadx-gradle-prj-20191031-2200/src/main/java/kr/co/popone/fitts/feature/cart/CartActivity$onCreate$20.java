package kr.co.popone.fitts.feature.cart;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;

final class CartActivity$onCreate$20<T> implements Observer<Throwable> {
    final /* synthetic */ CartActivity this$0;

    CartActivity$onCreate$20(CartActivity cartActivity) {
        this.this$0 = cartActivity;
    }

    public final void onChanged(Throwable th) {
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
