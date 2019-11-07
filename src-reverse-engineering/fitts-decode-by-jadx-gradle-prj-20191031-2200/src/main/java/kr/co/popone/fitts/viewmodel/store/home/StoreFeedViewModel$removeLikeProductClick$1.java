package kr.co.popone.fitts.viewmodel.store.home;

import io.reactivex.functions.Action;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.eventtracker.EventTracker;

final class StoreFeedViewModel$removeLikeProductClick$1 implements Action {
    final /* synthetic */ long $id;
    final /* synthetic */ StoreFeedViewModel this$0;

    StoreFeedViewModel$removeLikeProductClick$1(StoreFeedViewModel storeFeedViewModel, long j) {
        this.this$0 = storeFeedViewModel;
        this.$id = j;
    }

    public final void run() {
        RxBus.INSTANCE.post(new WishStateUpdateEvent(this.$id, false));
        EventTracker access$getEventTracker$p = this.this$0.eventTracker;
        StringBuilder sb = new StringBuilder();
        sb.append("store ");
        sb.append(this.this$0.getTabName());
        access$getEventTracker$p.customLogWishlistRemove(sb.toString());
    }
}
