package kr.co.popone.fitts.feature.category;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.paging.category.CategoryFeedListDataSource;
import org.jetbrains.annotations.NotNull;

final class CategorySearchFragment$getPostFeeds$3<I, O> implements Function<X, LiveData<Y>> {
    public static final CategorySearchFragment$getPostFeeds$3 INSTANCE = new CategorySearchFragment$getPostFeeds$3();

    CategorySearchFragment$getPostFeeds$3() {
    }

    @NotNull
    public final MutableLiveData<NetworkState> apply(CategoryFeedListDataSource categoryFeedListDataSource) {
        return categoryFeedListDataSource.getNetworkStateLiveData();
    }
}
