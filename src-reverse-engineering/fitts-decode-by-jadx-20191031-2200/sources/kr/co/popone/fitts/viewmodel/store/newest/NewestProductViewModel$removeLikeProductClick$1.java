package kr.co.popone.fitts.viewmodel.store.newest;

import io.reactivex.functions.Action;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.WishStateUpdateEvent;

final class NewestProductViewModel$removeLikeProductClick$1 implements Action {
    final /* synthetic */ long $id;
    final /* synthetic */ NewestProductViewModel this$0;

    NewestProductViewModel$removeLikeProductClick$1(NewestProductViewModel newestProductViewModel, long j) {
        this.this$0 = newestProductViewModel;
        this.$id = j;
    }

    public final void run() {
        RxBus.INSTANCE.post(new WishStateUpdateEvent(this.$id, false));
        this.this$0.eventTracker.customLogWishlistRemove("store new");
    }
}
