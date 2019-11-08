package kr.co.popone.fitts.viewmodel.store.bridge;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.WishStateUpdateEvent;

final class ShopBridgeViewModel$registerProductLikeEvent$1<T> implements Consumer<WishStateUpdateEvent> {
    final /* synthetic */ ShopBridgeViewModel this$0;

    ShopBridgeViewModel$registerProductLikeEvent$1(ShopBridgeViewModel shopBridgeViewModel) {
        this.this$0 = shopBridgeViewModel;
    }

    public final void accept(WishStateUpdateEvent wishStateUpdateEvent) {
        this.this$0._productLikeEvent.postValue(wishStateUpdateEvent);
    }
}
