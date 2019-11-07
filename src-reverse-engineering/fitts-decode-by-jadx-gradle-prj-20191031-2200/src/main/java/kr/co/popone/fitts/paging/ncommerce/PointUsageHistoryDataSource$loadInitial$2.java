package kr.co.popone.fitts.paging.ncommerce;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class PointUsageHistoryDataSource$loadInitial$2<T> implements Consumer<Throwable> {
    final /* synthetic */ PointUsageHistoryDataSource this$0;

    PointUsageHistoryDataSource$loadInitial$2(PointUsageHistoryDataSource pointUsageHistoryDataSource) {
        this.this$0 = pointUsageHistoryDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
