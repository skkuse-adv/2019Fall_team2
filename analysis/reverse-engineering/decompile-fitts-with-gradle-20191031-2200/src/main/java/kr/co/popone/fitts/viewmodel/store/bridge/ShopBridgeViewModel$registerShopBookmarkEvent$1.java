package kr.co.popone.fitts.viewmodel.store.bridge;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.ShopBookmarkEvent;

final class ShopBridgeViewModel$registerShopBookmarkEvent$1<T> implements Consumer<ShopBookmarkEvent> {
    final /* synthetic */ ShopBridgeViewModel this$0;

    ShopBridgeViewModel$registerShopBookmarkEvent$1(ShopBridgeViewModel shopBridgeViewModel) {
        this.this$0 = shopBridgeViewModel;
    }

    public final void accept(ShopBookmarkEvent shopBookmarkEvent) {
        this.this$0._shopBookmarkEvent.postValue(shopBookmarkEvent);
    }
}
