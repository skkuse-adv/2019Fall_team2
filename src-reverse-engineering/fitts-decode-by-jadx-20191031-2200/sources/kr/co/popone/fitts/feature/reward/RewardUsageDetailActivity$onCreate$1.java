package kr.co.popone.fitts.feature.reward;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class RewardUsageDetailActivity$onCreate$1 implements OnRefreshListener {
    final /* synthetic */ RewardUsageDetailActivity this$0;

    RewardUsageDetailActivity$onCreate$1(RewardUsageDetailActivity rewardUsageDetailActivity) {
        this.this$0 = rewardUsageDetailActivity;
    }

    public final void onRefresh() {
        this.this$0.loadRewardUsage();
    }
}
