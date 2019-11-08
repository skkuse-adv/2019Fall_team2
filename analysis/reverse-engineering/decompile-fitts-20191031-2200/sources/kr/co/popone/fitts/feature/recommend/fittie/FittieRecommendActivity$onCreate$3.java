package kr.co.popone.fitts.feature.recommend.fittie;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class FittieRecommendActivity$onCreate$3 implements OnRefreshListener {
    final /* synthetic */ FittieRecommendActivity this$0;

    FittieRecommendActivity$onCreate$3(FittieRecommendActivity fittieRecommendActivity) {
        this.this$0 = fittieRecommendActivity;
    }

    public final void onRefresh() {
        this.this$0.getVm().refreshRecommendFitties();
    }
}
