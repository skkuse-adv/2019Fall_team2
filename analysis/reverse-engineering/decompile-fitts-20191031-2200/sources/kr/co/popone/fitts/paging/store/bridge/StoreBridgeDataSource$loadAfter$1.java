package kr.co.popone.fitts.paging.store.bridge;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;

final class StoreBridgeDataSource$loadAfter$1<T> implements Consumer<List<? extends FeedItem>> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ StoreBridgeDataSource this$0;

    StoreBridgeDataSource$loadAfter$1(StoreBridgeDataSource storeBridgeDataSource, LoadCallback loadCallback) {
        this.this$0 = storeBridgeDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(List<? extends FeedItem> list) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        this.$callback.onResult(list);
    }
}
