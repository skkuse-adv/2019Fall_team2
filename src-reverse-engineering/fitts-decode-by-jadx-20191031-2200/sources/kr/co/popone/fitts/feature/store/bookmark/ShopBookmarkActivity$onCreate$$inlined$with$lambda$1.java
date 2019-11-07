package kr.co.popone.fitts.feature.store.bookmark;

import androidx.lifecycle.Observer;
import androidx.paging.PagedList;
import kr.co.popone.fitts.feature.store.list.StoreListAdapter;
import kr.co.popone.fitts.model.store.StoreInfo;

final class ShopBookmarkActivity$onCreate$$inlined$with$lambda$1<T> implements Observer<PagedList<StoreInfo>> {
    final /* synthetic */ StoreListAdapter $shopBookmarkAdapter$inlined;

    ShopBookmarkActivity$onCreate$$inlined$with$lambda$1(ShopBookmarkActivity shopBookmarkActivity, StoreListAdapter storeListAdapter) {
        this.$shopBookmarkAdapter$inlined = storeListAdapter;
    }

    public final void onChanged(PagedList<StoreInfo> pagedList) {
        this.$shopBookmarkAdapter$inlined.submitList(pagedList);
    }
}
