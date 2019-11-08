package kr.co.popone.fitts.paging.product;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.product.CategoryProductListResponse;

final class ProductFeedListDataSource$loadAfter$$inlined$let$lambda$1<T> implements Consumer<CategoryProductListResponse> {
    final /* synthetic */ LoadCallback $callback$inlined;
    final /* synthetic */ ProductFeedListDataSource this$0;

    ProductFeedListDataSource$loadAfter$$inlined$let$lambda$1(ProductFeedListDataSource productFeedListDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = productFeedListDataSource;
        this.$callback$inlined = loadCallback;
    }

    public final void accept(CategoryProductListResponse categoryProductListResponse) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        this.$callback$inlined.onResult(categoryProductListResponse.getItems());
    }
}
