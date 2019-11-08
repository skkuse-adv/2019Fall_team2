package kr.co.popone.fitts.viewmodel.order.list;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.paging.order.OrderListDataSource;
import org.jetbrains.annotations.NotNull;

final class OrderListViewModel$requestOrderList$2<I, O> implements Function<X, LiveData<Y>> {
    public static final OrderListViewModel$requestOrderList$2 INSTANCE = new OrderListViewModel$requestOrderList$2();

    OrderListViewModel$requestOrderList$2() {
    }

    @NotNull
    public final MutableLiveData<Boolean> apply(OrderListDataSource orderListDataSource) {
        return orderListDataSource.isEmptyList();
    }
}
