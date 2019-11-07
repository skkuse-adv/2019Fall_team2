package kr.co.popone.fitts.paging.store.bridge;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;

final class StoreBridgeDataSource$loadInitial$1<T> implements Consumer<List<? extends FeedItem>> {
    final /* synthetic */ LoadInitialCallback $callback;

    StoreBridgeDataSource$loadInitial$1(LoadInitialCallback loadInitialCallback) {
        this.$callback = loadInitialCallback;
    }

    public final void accept(List<? extends FeedItem> list) {
        this.$callback.onResult(list);
    }
}
