package kr.co.popone.fitts.paging.ncommerce;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class PointHistoryDataSource$loadAfter$2<T> implements Consumer<Throwable> {
    final /* synthetic */ PointHistoryDataSource this$0;

    PointHistoryDataSource$loadAfter$2(PointHistoryDataSource pointHistoryDataSource) {
        this.this$0 = pointHistoryDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
