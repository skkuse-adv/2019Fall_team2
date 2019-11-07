package kr.co.popone.fitts.paging.store.recommend;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import androidx.paging.ItemKeyedDataSource.LoadParams;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;

final class StoreRecommendDataSource$loadAfter$$inlined$let$lambda$1<T> implements Consumer<FeedInfo> {
    final /* synthetic */ LoadCallback $callback$inlined;
    final /* synthetic */ StoreRecommendDataSource this$0;

    StoreRecommendDataSource$loadAfter$$inlined$let$lambda$1(StoreRecommendDataSource storeRecommendDataSource, LoadParams loadParams, LoadCallback loadCallback) {
        this.this$0 = storeRecommendDataSource;
        this.$callback$inlined = loadCallback;
    }

    public final void accept(FeedInfo feedInfo) {
        this.this$0.get_networkState().postValue(NetworkState.Companion.getLOADED());
        this.$callback$inlined.onResult(feedInfo.getItems());
    }
}
