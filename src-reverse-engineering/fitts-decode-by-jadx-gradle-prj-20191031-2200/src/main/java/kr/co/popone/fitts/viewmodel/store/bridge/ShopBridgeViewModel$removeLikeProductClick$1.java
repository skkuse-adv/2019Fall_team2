package kr.co.popone.fitts.viewmodel.store.bridge;

import io.reactivex.functions.Action;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.WishStateUpdateEvent;

final class ShopBridgeViewModel$removeLikeProductClick$1 implements Action {
    final /* synthetic */ long $id;

    ShopBridgeViewModel$removeLikeProductClick$1(long j) {
        this.$id = j;
    }

    public final void run() {
        RxBus.INSTANCE.post(new WishStateUpdateEvent(this.$id, false));
    }
}
