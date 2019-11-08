package kr.co.popone.fitts.paging.store.newest;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class NewestProductDataSource$loadAfter$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ NewestProductDataSource this$0;

    NewestProductDataSource$loadAfter$$inlined$let$lambda$2(NewestProductDataSource newestProductDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = newestProductDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkState().postValue(NetworkState.Companion.error(th));
    }
}
