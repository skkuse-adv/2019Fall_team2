package kr.co.popone.fitts.paging.store;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.store.ProductFeedViewData;

final class StoreFeedDataSource$loadAfter$1<T1, T2> implements BiConsumer<List<? extends ProductFeedViewData>, Throwable> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ StoreFeedDataSource this$0;

    StoreFeedDataSource$loadAfter$1(StoreFeedDataSource storeFeedDataSource, LoadCallback loadCallback) {
        this.this$0 = storeFeedDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(List<ProductFeedViewData> list, Throwable th) {
        if (list != null) {
            this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
            this.$callback.onResult(list);
            return;
        }
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
