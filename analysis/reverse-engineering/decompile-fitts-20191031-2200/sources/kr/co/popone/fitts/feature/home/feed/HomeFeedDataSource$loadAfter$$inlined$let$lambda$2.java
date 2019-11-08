package kr.co.popone.fitts.feature.home.feed;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class HomeFeedDataSource$loadAfter$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ HomeFeedDataSource this$0;

    HomeFeedDataSource$loadAfter$$inlined$let$lambda$2(String str, HomeFeedDataSource homeFeedDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = homeFeedDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
