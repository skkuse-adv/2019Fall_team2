package kr.co.popone.fitts.paging.order;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.order.OrderListViewData;

final class OrderListDataSource$loadInitial$1<T1, T2> implements BiConsumer<List<? extends OrderListViewData>, Throwable> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ OrderListDataSource this$0;

    OrderListDataSource$loadInitial$1(OrderListDataSource orderListDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = orderListDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(List<OrderListViewData> list, Throwable th) {
        if (list != null) {
            this.$callback.onResult(list);
            this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
            this.this$0.isEmptyList().postValue(Boolean.valueOf(list.isEmpty()));
            return;
        }
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
