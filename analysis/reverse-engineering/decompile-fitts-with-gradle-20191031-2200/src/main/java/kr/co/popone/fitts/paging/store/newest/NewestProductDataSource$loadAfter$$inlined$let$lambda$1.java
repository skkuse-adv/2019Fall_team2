package kr.co.popone.fitts.paging.store.newest;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;

final class NewestProductDataSource$loadAfter$$inlined$let$lambda$1<T> implements Consumer<FeedInfo> {
    final /* synthetic */ LoadCallback $callback$inlined;
    final /* synthetic */ NewestProductDataSource this$0;

    NewestProductDataSource$loadAfter$$inlined$let$lambda$1(NewestProductDataSource newestProductDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = newestProductDataSource;
        this.$callback$inlined = loadCallback;
    }

    public final void accept(FeedInfo feedInfo) {
        this.this$0.getNetworkState().postValue(NetworkState.Companion.getLOADED());
        this.$callback$inlined.onResult(feedInfo.getItems());
    }
}
