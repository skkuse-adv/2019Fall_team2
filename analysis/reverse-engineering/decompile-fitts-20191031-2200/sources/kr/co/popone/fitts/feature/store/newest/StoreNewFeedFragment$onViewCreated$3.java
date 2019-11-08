package kr.co.popone.fitts.feature.store.newest;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;

final class StoreNewFeedFragment$onViewCreated$3<T> implements Observer<PagedList<FeedItem>> {
    final /* synthetic */ StoreNewFeedFragment this$0;

    StoreNewFeedFragment$onViewCreated$3(StoreNewFeedFragment storeNewFeedFragment) {
        this.this$0 = storeNewFeedFragment;
    }

    public final void onChanged(PagedList<FeedItem> pagedList) {
        this.this$0.feedsAdapter.submitList(pagedList);
    }
}
