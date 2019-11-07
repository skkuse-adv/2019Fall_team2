package kr.co.popone.fitts.paging.search;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class ProductResultDataSource$loadAfter$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ProductResultDataSource this$0;

    ProductResultDataSource$loadAfter$2(ProductResultDataSource productResultDataSource) {
        this.this$0 = productResultDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
