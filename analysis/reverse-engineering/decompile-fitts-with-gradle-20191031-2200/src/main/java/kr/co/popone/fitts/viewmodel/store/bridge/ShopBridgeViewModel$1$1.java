package kr.co.popone.fitts.viewmodel.store.bridge;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.store.bridge.StoreBridgeDataSource;
import org.jetbrains.annotations.NotNull;

final class ShopBridgeViewModel$1$1<I, O> implements Function<X, LiveData<Y>> {
    public static final ShopBridgeViewModel$1$1 INSTANCE = new ShopBridgeViewModel$1$1();

    ShopBridgeViewModel$1$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(StoreBridgeDataSource storeBridgeDataSource) {
        return storeBridgeDataSource.getNetworkStateLiveData();
    }
}
