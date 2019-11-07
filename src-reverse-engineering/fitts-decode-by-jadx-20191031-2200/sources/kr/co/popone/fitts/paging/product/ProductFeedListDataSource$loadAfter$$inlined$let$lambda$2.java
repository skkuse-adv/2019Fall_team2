package kr.co.popone.fitts.paging.product;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class ProductFeedListDataSource$loadAfter$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ProductFeedListDataSource this$0;

    ProductFeedListDataSource$loadAfter$$inlined$let$lambda$2(ProductFeedListDataSource productFeedListDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = productFeedListDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
