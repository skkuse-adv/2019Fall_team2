package kr.co.popone.fitts.paging.product;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.product.CategoryProductListResponse;

final class ProductFeedListDataSource$loadInitial$1<T> implements Consumer<CategoryProductListResponse> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ ProductFeedListDataSource this$0;

    ProductFeedListDataSource$loadInitial$1(ProductFeedListDataSource productFeedListDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = productFeedListDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(CategoryProductListResponse categoryProductListResponse) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.this$0.lastVersion = categoryProductListResponse.getVersion();
        this.$callback.onResult(categoryProductListResponse.getItems());
    }
}
