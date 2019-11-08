package kr.co.popone.fitts.viewmodel.ncommerce;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.ncommerce.PointUsageHistoryDataSource;
import org.jetbrains.annotations.NotNull;

final class NCommerceViewModel$requestPointUsageHistory$1<I, O> implements Function<X, LiveData<Y>> {
    public static final NCommerceViewModel$requestPointUsageHistory$1 INSTANCE = new NCommerceViewModel$requestPointUsageHistory$1();

    NCommerceViewModel$requestPointUsageHistory$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(PointUsageHistoryDataSource pointUsageHistoryDataSource) {
        return pointUsageHistoryDataSource.getNetworkStateLiveData();
    }
}
