package kr.co.popone.fitts.feature.store.bookmark;

import android.view.View;
import android.view.View.OnClickListener;

final class ShopBookmarkActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ ShopBookmarkActivity this$0;

    ShopBookmarkActivity$onCreate$3(ShopBookmarkActivity shopBookmarkActivity) {
        this.this$0 = shopBookmarkActivity;
    }

    public final void onClick(View view) {
        this.this$0.getViewModel().moveToShopListButtonClick(this.this$0);
    }
}
