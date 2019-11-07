package kr.co.popone.fitts.paging.store.list;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.base.type.NetworkState;

final class ShopBookmarkDataSource$loadAfter$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ShopBookmarkDataSource this$0;

    ShopBookmarkDataSource$loadAfter$2(ShopBookmarkDataSource shopBookmarkDataSource) {
        this.this$0 = shopBookmarkDataSource;
    }

    public final void accept(Throwable th) {
        this.this$0.getNetworkStateLiveData().postValue(NetworkState.Companion.error(th));
    }
}
