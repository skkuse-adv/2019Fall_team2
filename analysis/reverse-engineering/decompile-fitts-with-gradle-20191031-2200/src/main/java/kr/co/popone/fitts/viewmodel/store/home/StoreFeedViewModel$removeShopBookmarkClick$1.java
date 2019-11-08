package kr.co.popone.fitts.viewmodel.store.home;

import io.reactivex.functions.Action;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.ShopBookmarkEvent;

final class StoreFeedViewModel$removeShopBookmarkClick$1 implements Action {
    final /* synthetic */ long $id;
    final /* synthetic */ StoreFeedViewModel this$0;

    StoreFeedViewModel$removeShopBookmarkClick$1(StoreFeedViewModel storeFeedViewModel, long j) {
        this.this$0 = storeFeedViewModel;
        this.$id = j;
    }

    public final void run() {
        this.this$0.eventTracker.customLogRemoveShopBookmark("shop_list");
        RxBus.INSTANCE.post(new ShopBookmarkEvent(this.$id, false));
    }
}
