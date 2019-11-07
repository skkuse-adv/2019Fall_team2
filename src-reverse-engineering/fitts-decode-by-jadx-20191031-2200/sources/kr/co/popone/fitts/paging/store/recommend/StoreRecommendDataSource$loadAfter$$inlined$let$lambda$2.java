package kr.co.popone.fitts.paging.store.recommend;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class StoreRecommendDataSource$loadAfter$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ StoreRecommendDataSource this$0;

    StoreRecommendDataSource$loadAfter$$inlined$let$lambda$2(StoreRecommendDataSource storeRecommendDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = storeRecommendDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.get_networkState().postValue(NetworkState.Companion.error(th));
    }
}
