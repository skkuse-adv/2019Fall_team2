package kr.co.popone.fitts.paging.ncommerce;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentHistory;

final class PointHistoryDataSource$loadAfter$1<T> implements Consumer<List<? extends PaymentHistory>> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ PointHistoryDataSource this$0;

    PointHistoryDataSource$loadAfter$1(PointHistoryDataSource pointHistoryDataSource, LoadCallback loadCallback) {
        this.this$0 = pointHistoryDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(List<PaymentHistory> list) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        this.$callback.onResult(list);
    }
}
