package kr.co.popone.fitts.paging.category;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse;

final class CategoryFeedListDataSource$loadAfter$$inlined$let$lambda$1<T> implements Consumer<CategoryPostListResponse> {
    final /* synthetic */ LoadCallback $callback$inlined;
    final /* synthetic */ CategoryFeedListDataSource this$0;

    CategoryFeedListDataSource$loadAfter$$inlined$let$lambda$1(CategoryFeedListDataSource categoryFeedListDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = categoryFeedListDataSource;
        this.$callback$inlined = loadCallback;
    }

    public final void accept(CategoryPostListResponse categoryPostListResponse) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        this.$callback$inlined.onResult(categoryPostListResponse.getItems());
    }
}
