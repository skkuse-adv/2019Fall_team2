package kr.co.popone.fitts.viewmodel.recommend.fittie;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.recommend.FittieRecommendDataSource;
import org.jetbrains.annotations.NotNull;

final class FittieRecommendViewModel$1$1<I, O> implements Function<X, LiveData<Y>> {
    public static final FittieRecommendViewModel$1$1 INSTANCE = new FittieRecommendViewModel$1$1();

    FittieRecommendViewModel$1$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(FittieRecommendDataSource fittieRecommendDataSource) {
        return fittieRecommendDataSource.getNetworkStateLiveData();
    }
}
