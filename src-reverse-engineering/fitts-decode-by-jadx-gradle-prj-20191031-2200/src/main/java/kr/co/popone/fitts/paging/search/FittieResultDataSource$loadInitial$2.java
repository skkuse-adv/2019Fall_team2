package kr.co.popone.fitts.paging.search;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class FittieResultDataSource$loadInitial$2<T> implements Consumer<Throwable> {
    final /* synthetic */ FittieResultDataSource this$0;

    FittieResultDataSource$loadInitial$2(FittieResultDataSource fittieResultDataSource) {
        this.this$0 = fittieResultDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
