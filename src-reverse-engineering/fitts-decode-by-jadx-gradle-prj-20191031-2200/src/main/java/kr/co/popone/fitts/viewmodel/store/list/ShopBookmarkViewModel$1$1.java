package kr.co.popone.fitts.viewmodel.store.list;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.store.list.ShopBookmarkDataSource;
import org.jetbrains.annotations.NotNull;

final class ShopBookmarkViewModel$1$1<I, O> implements Function<X, LiveData<Y>> {
    public static final ShopBookmarkViewModel$1$1 INSTANCE = new ShopBookmarkViewModel$1$1();

    ShopBookmarkViewModel$1$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(ShopBookmarkDataSource shopBookmarkDataSource) {
        return shopBookmarkDataSource.getNetworkStateLiveData();
    }
}
