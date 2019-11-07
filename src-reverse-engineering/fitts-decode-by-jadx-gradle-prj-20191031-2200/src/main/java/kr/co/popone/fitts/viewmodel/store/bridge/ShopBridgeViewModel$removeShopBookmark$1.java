package kr.co.popone.fitts.viewmodel.store.bridge;

import io.reactivex.functions.Action;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.ShopBookmarkEvent;

final class ShopBridgeViewModel$removeShopBookmark$1 implements Action {
    final /* synthetic */ long $shopId;
    final /* synthetic */ ShopBridgeViewModel this$0;

    ShopBridgeViewModel$removeShopBookmark$1(ShopBridgeViewModel shopBridgeViewModel, long j) {
        this.this$0 = shopBridgeViewModel;
        this.$shopId = j;
    }

    public final void run() {
        RxBus.INSTANCE.post(new ShopBookmarkEvent(this.$shopId, false));
        this.this$0.eventTracker.customLogRemoveShopBookmark("shop");
        this.this$0._shopBookmarkState.setValue(Boolean.valueOf(false));
        this.this$0._shopBookmarkEvent.setValue(new ShopBookmarkEvent(this.$shopId, false));
    }
}
