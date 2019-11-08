package kr.co.popone.fitts.paging.category;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class CategoryFeedListDataSource$loadAfter$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ CategoryFeedListDataSource this$0;

    CategoryFeedListDataSource$loadAfter$$inlined$let$lambda$2(CategoryFeedListDataSource categoryFeedListDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = categoryFeedListDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
