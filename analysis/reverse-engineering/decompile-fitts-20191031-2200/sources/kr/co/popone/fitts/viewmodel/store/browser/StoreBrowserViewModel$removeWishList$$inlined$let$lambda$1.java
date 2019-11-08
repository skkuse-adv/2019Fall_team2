package kr.co.popone.fitts.viewmodel.store.browser;

import io.reactivex.functions.Action;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.WishStateUpdateEvent;

final class StoreBrowserViewModel$removeWishList$$inlined$let$lambda$1 implements Action {
    final /* synthetic */ long $it;
    final /* synthetic */ StoreBrowserViewModel this$0;

    StoreBrowserViewModel$removeWishList$$inlined$let$lambda$1(long j, StoreBrowserViewModel storeBrowserViewModel) {
        this.$it = j;
        this.this$0 = storeBrowserViewModel;
    }

    public final void run() {
        RxBus.INSTANCE.post(new WishStateUpdateEvent(this.$it, false));
        this.this$0.isWishProductLiveData().setValue(Boolean.valueOf(false));
        this.this$0.eventTracker.customLogWishlistRemove("browser");
    }
}
