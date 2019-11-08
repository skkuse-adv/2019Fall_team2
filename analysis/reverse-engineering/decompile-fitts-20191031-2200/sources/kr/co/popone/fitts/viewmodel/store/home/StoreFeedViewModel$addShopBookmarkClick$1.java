package kr.co.popone.fitts.viewmodel.store.home;

import io.reactivex.functions.Action;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.ShopBookmarkEvent;

final class StoreFeedViewModel$addShopBookmarkClick$1 implements Action {
    final /* synthetic */ long $id;
    final /* synthetic */ StoreFeedViewModel this$0;

    StoreFeedViewModel$addShopBookmarkClick$1(StoreFeedViewModel storeFeedViewModel, long j) {
        this.this$0 = storeFeedViewModel;
        this.$id = j;
    }

    public final void run() {
        this.this$0.eventTracker.customLogAddShopBookmark("shop_list");
        RxBus.INSTANCE.post(new ShopBookmarkEvent(this.$id, true));
    }
}
