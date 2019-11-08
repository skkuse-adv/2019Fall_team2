package kr.co.popone.fitts.paging.category;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.post.PostAPI.CategoryPostListResponse;

final class CategoryFeedListDataSource$loadInitial$1<T> implements Consumer<CategoryPostListResponse> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ CategoryFeedListDataSource this$0;

    CategoryFeedListDataSource$loadInitial$1(CategoryFeedListDataSource categoryFeedListDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = categoryFeedListDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(CategoryPostListResponse categoryPostListResponse) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.this$0.lastVersion = categoryPostListResponse.getVersion();
        this.$callback.onResult(categoryPostListResponse.getItems());
    }
}
