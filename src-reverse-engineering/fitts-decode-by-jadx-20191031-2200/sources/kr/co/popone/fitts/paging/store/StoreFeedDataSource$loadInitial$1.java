package kr.co.popone.fitts.paging.store;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.store.ProductFeedViewData;

final class StoreFeedDataSource$loadInitial$1<T1, T2> implements BiConsumer<List<? extends ProductFeedViewData>, Throwable> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ StoreFeedDataSource this$0;

    StoreFeedDataSource$loadInitial$1(StoreFeedDataSource storeFeedDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = storeFeedDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(List<ProductFeedViewData> list, Throwable th) {
        if (list != null) {
            this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
            this.$callback.onResult(list);
            return;
        }
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
