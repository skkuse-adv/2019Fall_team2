package kr.co.popone.fitts.feature.store.newest;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener;

final class StoreNewFeedFragment$onViewCreated$2 implements OnRefreshListener {
    final /* synthetic */ StoreNewFeedFragment this$0;

    StoreNewFeedFragment$onViewCreated$2(StoreNewFeedFragment storeNewFeedFragment) {
        this.this$0 = storeNewFeedFragment;
    }

    public final void onRefresh() {
        this.this$0.getVm().refreshStoreNewFeeds();
    }
}
