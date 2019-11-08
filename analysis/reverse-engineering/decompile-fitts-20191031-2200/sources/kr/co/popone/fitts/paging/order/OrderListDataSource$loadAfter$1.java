package kr.co.popone.fitts.paging.order;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.order.OrderListViewData;

final class OrderListDataSource$loadAfter$1<T1, T2> implements BiConsumer<List<? extends OrderListViewData>, Throwable> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ OrderListDataSource this$0;

    OrderListDataSource$loadAfter$1(OrderListDataSource orderListDataSource, LoadCallback loadCallback) {
        this.this$0 = orderListDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(List<OrderListViewData> list, Throwable th) {
        if (list != null) {
            this.$callback.onResult(list);
            this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
            return;
        }
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
