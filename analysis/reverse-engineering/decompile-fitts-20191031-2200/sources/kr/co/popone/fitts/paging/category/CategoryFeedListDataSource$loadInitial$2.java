package kr.co.popone.fitts.paging.category;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class CategoryFeedListDataSource$loadInitial$2<T> implements Consumer<Throwable> {
    final /* synthetic */ CategoryFeedListDataSource this$0;

    CategoryFeedListDataSource$loadInitial$2(CategoryFeedListDataSource categoryFeedListDataSource) {
        this.this$0 = categoryFeedListDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
