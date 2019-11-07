package kr.co.popone.fitts.viewmodel.ncommerce;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.ncommerce.PointHistoryDataSource;
import org.jetbrains.annotations.NotNull;

final class NCommerceViewModel$requestPointHistory$1<I, O> implements Function<X, LiveData<Y>> {
    public static final NCommerceViewModel$requestPointHistory$1 INSTANCE = new NCommerceViewModel$requestPointHistory$1();

    NCommerceViewModel$requestPointHistory$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(PointHistoryDataSource pointHistoryDataSource) {
        return pointHistoryDataSource.getNetworkStateLiveData();
    }
}
