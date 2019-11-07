package kr.co.popone.fitts.feature.store.bridge;

import android.view.View;
import android.view.View.OnClickListener;

final class ShopBridgeActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ ShopBridgeActivity this$0;

    ShopBridgeActivity$onCreate$3(ShopBridgeActivity shopBridgeActivity) {
        this.this$0 = shopBridgeActivity;
    }

    public final void onClick(View view) {
        this.this$0.getVm().bookmarkButtonClick();
    }
}
