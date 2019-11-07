package kr.co.popone.fitts.ui.custom;

import android.view.View;
import android.view.View.OnClickListener;

final class StoreOptionSelectDialog$initializeView$4 implements OnClickListener {
    final /* synthetic */ StoreOptionSelectDialog this$0;

    StoreOptionSelectDialog$initializeView$4(StoreOptionSelectDialog storeOptionSelectDialog) {
        this.this$0 = storeOptionSelectDialog;
    }

    public final void onClick(View view) {
        this.this$0.getDelegate().onBuyButtonClicked(this.this$0.orderableOptionAdatper.getOrderableItems());
    }
}
