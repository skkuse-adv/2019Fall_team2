package kr.co.popone.fitts.viewmodel.store.home;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.store.recommend.StoreRecommendDataSource;
import org.jetbrains.annotations.NotNull;

final class StoreFeedViewModel$1$1<I, O> implements Function<X, LiveData<Y>> {
    public static final StoreFeedViewModel$1$1 INSTANCE = new StoreFeedViewModel$1$1();

    StoreFeedViewModel$1$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(StoreRecommendDataSource storeRecommendDataSource) {
        return storeRecommendDataSource.get_networkState();
    }
}
