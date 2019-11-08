package kr.co.popone.fitts.feature.store.bookmark;

import androidx.lifecycle.Observer;
import com.kakao.util.helper.log.Logger;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.feature.store.bookmark.ShopBookmarkActivity.WhenMappings;
import kr.co.popone.fitts.feature.store.list.StoreListAdapter;

final class ShopBookmarkActivity$onCreate$$inlined$with$lambda$2<T> implements Observer<NetworkState> {
    final /* synthetic */ StoreListAdapter $shopBookmarkAdapter$inlined;

    ShopBookmarkActivity$onCreate$$inlined$with$lambda$2(ShopBookmarkActivity shopBookmarkActivity, StoreListAdapter storeListAdapter) {
        this.$shopBookmarkAdapter$inlined = storeListAdapter;
    }

    public final void onChanged(NetworkState networkState) {
        int i = WhenMappings.$EnumSwitchMapping$0[networkState.getStatus().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.$shopBookmarkAdapter$inlined.updateNetworkState(networkState);
        } else {
            Logger.d("Init loading or success");
        }
    }
}
