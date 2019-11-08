package kr.co.popone.fitts.feature.home.feed;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class HomeFeedFragment$onViewCreated$2 implements OnRefreshListener {
    final /* synthetic */ HomeFeedFragment this$0;

    HomeFeedFragment$onViewCreated$2(HomeFeedFragment homeFeedFragment) {
        this.this$0 = homeFeedFragment;
    }

    public final void onRefresh() {
        this.this$0.getViewModel().refresh();
    }
}
