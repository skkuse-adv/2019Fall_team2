package kr.co.popone.fitts.feature.search;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class ShopWebViewActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ ShopWebViewActivity this$0;

    ShopWebViewActivity$onCreate$4(ShopWebViewActivity shopWebViewActivity) {
        this.this$0 = shopWebViewActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
