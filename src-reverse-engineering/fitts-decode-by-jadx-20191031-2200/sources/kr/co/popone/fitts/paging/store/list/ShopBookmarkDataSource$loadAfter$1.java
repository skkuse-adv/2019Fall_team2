package kr.co.popone.fitts.paging.store.list;

import androidx.paging.ItemKeyedDataSource.LoadCallback;
import io.reactivex.functions.Consumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.store.StoreInfo;

final class ShopBookmarkDataSource$loadAfter$1<T> implements Consumer<List<? extends StoreInfo>> {
    final /* synthetic */ LoadCallback $callback;
    final /* synthetic */ ShopBookmarkDataSource this$0;

    ShopBookmarkDataSource$loadAfter$1(ShopBookmarkDataSource shopBookmarkDataSource, LoadCallback loadCallback) {
        this.this$0 = shopBookmarkDataSource;
        this.$callback = loadCallback;
    }

    public final void accept(List<StoreInfo> list) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.getLOADED());
        this.$callback.onResult(list);
    }
}
