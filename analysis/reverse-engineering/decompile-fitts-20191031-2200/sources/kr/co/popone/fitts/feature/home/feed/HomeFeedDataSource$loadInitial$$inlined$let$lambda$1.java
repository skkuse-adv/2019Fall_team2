package kr.co.popone.fitts.feature.home.feed;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource.LoadInitialParams;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Pair;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.Feed;

final class HomeFeedDataSource$loadInitial$$inlined$let$lambda$1<T> implements Consumer<Pair<? extends String, ? extends List<? extends Feed>>> {
    final /* synthetic */ LoadInitialCallback $callback$inlined;
    final /* synthetic */ HomeFeedDataSource this$0;

    HomeFeedDataSource$loadInitial$$inlined$let$lambda$1(HomeFeedDataSource homeFeedDataSource, LoadInitialParams loadInitialParams, LoadInitialCallback loadInitialCallback) {
        this.this$0 = homeFeedDataSource;
        this.$callback$inlined = loadInitialCallback;
    }

    public final void accept(Pair<String, ? extends List<Feed>> pair) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        Feed feed = (Feed) CollectionsKt___CollectionsKt.firstOrNull((List) pair.getSecond());
        this.this$0.getFirstFeedType().postValue(feed != null ? feed.getHomeFeedType() : null);
        this.this$0.lastVersion = (String) pair.getFirst();
        this.$callback$inlined.onResult((List) pair.getSecond());
    }
}
