package kr.co.popone.fitts.viewmodel.trend;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedInfo;

final class TrendFeedViewModel$$special$$inlined$let$lambda$1<T> implements Consumer<FeedInfo> {
    final /* synthetic */ TrendFeedViewModel this$0;

    TrendFeedViewModel$$special$$inlined$let$lambda$1(TrendFeedViewModel trendFeedViewModel) {
        this.this$0 = trendFeedViewModel;
    }

    public final void accept(FeedInfo feedInfo) {
        this.this$0._titleLiveData.setValue(feedInfo.getTitle());
        this.this$0._trendFeedsLiveData.setValue(feedInfo.getItems());
        this.this$0._networkState.setValue(NetworkState.Companion.getLOADED());
    }
}
