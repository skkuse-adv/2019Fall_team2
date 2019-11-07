package kr.co.popone.fitts.paging.wish;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.store.ProductFeedViewData;

final class WishListDataSource$loadAfter$1<T1, T2> implements BiConsumer<List<? extends ProductFeedViewData>, Throwable> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ WishListDataSource this$0;

    WishListDataSource$loadAfter$1(WishListDataSource wishListDataSource, LoadCallback loadCallback) {
        this.this$0 = wishListDataSource;
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
