package kr.co.popone.fitts.paging.ncommerce;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;

final class PointUsageHistoryDataSource$loadInitial$1<T> implements Consumer<List<? extends PaymentUsage>> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ PointUsageHistoryDataSource this$0;

    PointUsageHistoryDataSource$loadInitial$1(PointUsageHistoryDataSource pointUsageHistoryDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = pointUsageHistoryDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(List<PaymentUsage> list) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.$callback.onResult(list);
    }
}
