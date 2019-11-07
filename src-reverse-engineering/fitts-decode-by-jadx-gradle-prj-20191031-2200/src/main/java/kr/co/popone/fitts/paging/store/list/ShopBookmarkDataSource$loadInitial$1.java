package kr.co.popone.fitts.paging.store.list;

import androidx.paging.ItemKeyedDataSource.LoadInitialCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.store.StoreInfo;

final class ShopBookmarkDataSource$loadInitial$1<T> implements Consumer<List<? extends StoreInfo>> {
    final /* synthetic */ LoadInitialCallback $callback;
    final /* synthetic */ ShopBookmarkDataSource this$0;

    ShopBookmarkDataSource$loadInitial$1(ShopBookmarkDataSource shopBookmarkDataSource, LoadInitialCallback loadInitialCallback) {
        this.this$0 = shopBookmarkDataSource;
        this.$callback = loadInitialCallback;
    }

    public final void accept(List<StoreInfo> list) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getINIT_LOADED());
        this.this$0.getEmptyListLiveData().postValue(Boolean.valueOf(list.isEmpty()));
        this.$callback.onResult(list);
    }
}
