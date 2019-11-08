package kr.co.popone.fitts.feature.store.bridge;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity.Companion;

final class ShopBridgeActivity$updateShopLinkUrl$1 implements OnClickListener {
    final /* synthetic */ String $url;
    final /* synthetic */ ShopBridgeActivity this$0;

    ShopBridgeActivity$updateShopLinkUrl$1(ShopBridgeActivity shopBridgeActivity, String str) {
        this.this$0 = shopBridgeActivity;
        this.$url = str;
    }

    public final void onClick(View view) {
        Companion.start$default(StoreBrowserActivity.Companion, this.this$0, this.$url, "shop", null, null, 24, null);
    }
}
