package kr.co.popone.fitts.paging.recommend;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class FittieRecommendDataSource$loadInitial$2<T> implements Consumer<Throwable> {
    final /* synthetic */ FittieRecommendDataSource this$0;

    FittieRecommendDataSource$loadInitial$2(FittieRecommendDataSource fittieRecommendDataSource) {
        this.this$0 = fittieRecommendDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
