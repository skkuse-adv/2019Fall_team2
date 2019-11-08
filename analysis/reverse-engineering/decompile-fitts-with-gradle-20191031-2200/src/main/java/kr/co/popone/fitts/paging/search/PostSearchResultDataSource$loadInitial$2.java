package kr.co.popone.fitts.paging.search;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class PostSearchResultDataSource$loadInitial$2<T> implements Consumer<Throwable> {
    final /* synthetic */ PostSearchResultDataSource this$0;

    PostSearchResultDataSource$loadInitial$2(PostSearchResultDataSource postSearchResultDataSource) {
        this.this$0 = postSearchResultDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
