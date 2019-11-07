package kr.co.popone.fitts.paging.store.recommend;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;

final class StoreRecommendDataSource$loadInitial$1<T> implements Consumer<FeedInfo> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ StoreRecommendDataSource this$0;

    StoreRecommendDataSource$loadInitial$1(StoreRecommendDataSource storeRecommendDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = storeRecommendDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(FeedInfo feedInfo) {
        this.this$0.get_networkState().postValue(NetworkState.Companion.getINIT_LOADED());
        this.this$0.feedVersion = feedInfo.getVersion();
        this.$callback.onResult(feedInfo.getItems());
    }
}
