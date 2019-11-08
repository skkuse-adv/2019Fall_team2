package kr.co.popone.fitts.paging.product;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class ProductFeedListDataSource$loadInitial$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ProductFeedListDataSource this$0;

    ProductFeedListDataSource$loadInitial$2(ProductFeedListDataSource productFeedListDataSource) {
        this.this$0 = productFeedListDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
