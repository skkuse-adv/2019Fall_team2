package kr.co.popone.fitts.feature.store.recommend;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class StoreFeedFragment$onViewCreated$2 implements OnRefreshListener {
    final /* synthetic */ StoreFeedFragment this$0;

    StoreFeedFragment$onViewCreated$2(StoreFeedFragment storeFeedFragment) {
        this.this$0 = storeFeedFragment;
    }

    public final void onRefresh() {
        this.this$0.getVm().refreshStoreFeeds();
    }
}
