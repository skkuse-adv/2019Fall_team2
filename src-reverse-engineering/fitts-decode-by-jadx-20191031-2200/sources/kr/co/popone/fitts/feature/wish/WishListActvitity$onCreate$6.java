package kr.co.popone.fitts.feature.wish;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.model.store.ProductFeedViewData;

final class WishListActvitity$onCreate$6<T> implements Observer<PagedList<ProductFeedViewData>> {
    final /* synthetic */ WishListAdapter $wishListAdapter;

    WishListActvitity$onCreate$6(WishListAdapter wishListAdapter) {
        this.$wishListAdapter = wishListAdapter;
    }

    public final void onChanged(PagedList<ProductFeedViewData> pagedList) {
        this.$wishListAdapter.submitList(pagedList);
    }
}
