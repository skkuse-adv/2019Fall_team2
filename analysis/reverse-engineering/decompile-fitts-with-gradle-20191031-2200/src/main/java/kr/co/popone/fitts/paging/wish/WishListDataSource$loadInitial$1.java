package kr.co.popone.fitts.paging.wish;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.store.ProductFeedViewData;

final class WishListDataSource$loadInitial$1<T1, T2> implements BiConsumer<List<? extends ProductFeedViewData>, Throwable> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ WishListDataSource this$0;

    WishListDataSource$loadInitial$1(WishListDataSource wishListDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = wishListDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(List<ProductFeedViewData> list, Throwable th) {
        if (list != null) {
            this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
            this.$callback.onResult(list);
            this.this$0.isEmptyList().postValue(Boolean.valueOf(list.isEmpty()));
            return;
        }
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
