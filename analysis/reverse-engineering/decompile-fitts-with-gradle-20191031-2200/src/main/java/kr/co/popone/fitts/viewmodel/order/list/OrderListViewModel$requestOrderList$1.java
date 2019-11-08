package kr.co.popone.fitts.viewmodel.order.list;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.order.OrderListDataSource;
import org.jetbrains.annotations.NotNull;

final class OrderListViewModel$requestOrderList$1<I, O> implements Function<X, LiveData<Y>> {
    public static final OrderListViewModel$requestOrderList$1 INSTANCE = new OrderListViewModel$requestOrderList$1();

    OrderListViewModel$requestOrderList$1() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(OrderListDataSource orderListDataSource) {
        return orderListDataSource.getNetworkStateLiveData();
    }
}
