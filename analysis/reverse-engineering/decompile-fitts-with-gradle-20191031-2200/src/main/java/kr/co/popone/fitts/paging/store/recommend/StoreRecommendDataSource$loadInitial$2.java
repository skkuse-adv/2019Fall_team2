package kr.co.popone.fitts.paging.store.recommend;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class StoreRecommendDataSource$loadInitial$2<T> implements Consumer<Throwable> {
    final /* synthetic */ StoreRecommendDataSource this$0;

    StoreRecommendDataSource$loadInitial$2(StoreRecommendDataSource storeRecommendDataSource) {
        this.this$0 = storeRecommendDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.get_networkState().postValue(NetworkState.Companion.error(th));
    }
}
