package kr.co.popone.fitts.feature.reward;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class UsedRewardHistoryFragment$onViewCreated$3 implements OnRefreshListener {
    final /* synthetic */ UsedRewardHistoryFragment this$0;

    UsedRewardHistoryFragment$onViewCreated$3(UsedRewardHistoryFragment usedRewardHistoryFragment) {
        this.this$0 = usedRewardHistoryFragment;
    }

    public final void onRefresh() {
        this.this$0.loadUsedRewardHistory(true);
    }
}
