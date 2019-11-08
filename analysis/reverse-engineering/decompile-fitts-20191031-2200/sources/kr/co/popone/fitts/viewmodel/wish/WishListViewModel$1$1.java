package kr.co.popone.fitts.viewmodel.wish;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.wish.WishListDataSource;
import org.jetbrains.annotations.NotNull;

final class WishListViewModel$1$1<I, O> implements Function<X, LiveData<Y>> {
    public static final WishListViewModel$1$1 INSTANCE = new WishListViewModel$1$1();

    WishListViewModel$1$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(WishListDataSource wishListDataSource) {
        return wishListDataSource.getNetworkStateLiveData();
    }
}
