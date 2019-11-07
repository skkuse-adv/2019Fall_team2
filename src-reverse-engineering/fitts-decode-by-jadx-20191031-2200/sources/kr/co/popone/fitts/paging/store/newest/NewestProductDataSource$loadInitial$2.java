package kr.co.popone.fitts.paging.store.newest;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class NewestProductDataSource$loadInitial$2<T> implements Consumer<Throwable> {
    final /* synthetic */ NewestProductDataSource this$0;

    NewestProductDataSource$loadInitial$2(NewestProductDataSource newestProductDataSource) {
        this.this$0 = newestProductDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkState().postValue(NetworkState.Companion.error(th));
    }
}
