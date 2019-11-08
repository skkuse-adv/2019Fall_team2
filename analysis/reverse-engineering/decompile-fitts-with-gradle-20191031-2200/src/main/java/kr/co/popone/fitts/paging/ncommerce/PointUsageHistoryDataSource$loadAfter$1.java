package kr.co.popone.fitts.paging.ncommerce;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;

final class PointUsageHistoryDataSource$loadAfter$1<T> implements Consumer<List<? extends PaymentUsage>> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ PointUsageHistoryDataSource this$0;

    PointUsageHistoryDataSource$loadAfter$1(PointUsageHistoryDataSource pointUsageHistoryDataSource, LoadCallback loadCallback) {
        this.this$0 = pointUsageHistoryDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(List<PaymentUsage> list) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        this.$callback.onResult(list);
    }
}
