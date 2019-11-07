package kr.co.popone.fitts.paging.ncommerce;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;

final class PointHistoryDataSource$loadInitial$1<T> implements Consumer<List<? extends PaymentHistory>> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ PointHistoryDataSource this$0;

    PointHistoryDataSource$loadInitial$1(PointHistoryDataSource pointHistoryDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = pointHistoryDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(List<PaymentHistory> list) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.this$0.getEmptyListLiveData().postValue(Boolean.valueOf(list.isEmpty()));
        this.$callback.onResult(list);
    }
}
