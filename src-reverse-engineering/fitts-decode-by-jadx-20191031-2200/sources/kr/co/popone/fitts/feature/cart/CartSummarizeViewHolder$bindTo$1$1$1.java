package kr.co.popone.fitts.feature.cart;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.event.CartEvent$OrderButtonClickEvent;
import kr.co.popone.fitts.event.RxBus;

final class CartSummarizeViewHolder$bindTo$1$1$1 implements OnClickListener {
    public static final CartSummarizeViewHolder$bindTo$1$1$1 INSTANCE = new CartSummarizeViewHolder$bindTo$1$1$1();

    CartSummarizeViewHolder$bindTo$1$1$1() {
    }

    public final void onClick(View view) {
        RxBus.INSTANCE.post(new CartEvent$OrderButtonClickEvent());
    }
}
