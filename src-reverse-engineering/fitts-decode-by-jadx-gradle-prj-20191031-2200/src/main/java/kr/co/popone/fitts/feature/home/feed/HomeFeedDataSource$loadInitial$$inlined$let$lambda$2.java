package kr.co.popone.fitts.feature.home.feed;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class HomeFeedDataSource$loadInitial$$inlined$let$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ HomeFeedDataSource this$0;

    HomeFeedDataSource$loadInitial$$inlined$let$lambda$2(HomeFeedDataSource homeFeedDataSource, LoadInitialParams loadInitialParams, LoadInitialCallback loadInitialCallback) {
        this.this$0 = homeFeedDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
