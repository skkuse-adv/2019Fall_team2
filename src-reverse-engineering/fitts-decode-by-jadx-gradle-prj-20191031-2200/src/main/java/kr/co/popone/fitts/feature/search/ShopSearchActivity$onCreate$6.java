package kr.co.popone.fitts.feature.search;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class ShopSearchActivity$onCreate$6 implements OnRefreshListener {
    final /* synthetic */ ShopSearchActivity this$0;

    ShopSearchActivity$onCreate$6(ShopSearchActivity shopSearchActivity) {
        this.this$0 = shopSearchActivity;
    }

    public final void onRefresh() {
        this.this$0.searchShop(true);
    }
}
