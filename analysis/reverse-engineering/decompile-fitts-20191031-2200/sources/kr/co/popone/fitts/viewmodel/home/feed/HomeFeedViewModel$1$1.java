package kr.co.popone.fitts.viewmodel.home.feed;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.feature.home.feed.HomeFeedDataSource;
import org.jetbrains.annotations.NotNull;

final class HomeFeedViewModel$1$1<I, O> implements Function<X, LiveData<Y>> {
    public static final HomeFeedViewModel$1$1 INSTANCE = new HomeFeedViewModel$1$1();

    HomeFeedViewModel$1$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(HomeFeedDataSource homeFeedDataSource) {
        return homeFeedDataSource.getNetworkStateLiveData();
    }
}
