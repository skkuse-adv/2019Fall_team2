package kr.co.popone.fitts.feature.banner;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class BannerActivity$onCreate$3 implements OnRefreshListener {
    final /* synthetic */ BannerActivity this$0;

    BannerActivity$onCreate$3(BannerActivity bannerActivity) {
        this.this$0 = bannerActivity;
    }

    public final void onRefresh() {
        this.this$0.getViewModel().getBannerList();
    }
}
