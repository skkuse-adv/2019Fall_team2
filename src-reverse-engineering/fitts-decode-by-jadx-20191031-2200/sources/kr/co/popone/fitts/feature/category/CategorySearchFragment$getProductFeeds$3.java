package kr.co.popone.fitts.feature.category;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.product.ProductFeedListDataSource;
import org.jetbrains.annotations.NotNull;

final class CategorySearchFragment$getProductFeeds$3<I, O> implements Function<X, LiveData<Y>> {
    public static final CategorySearchFragment$getProductFeeds$3 INSTANCE = new CategorySearchFragment$getProductFeeds$3();

    CategorySearchFragment$getProductFeeds$3() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(ProductFeedListDataSource productFeedListDataSource) {
        return productFeedListDataSource.getNetworkStateLiveData();
    }
}
