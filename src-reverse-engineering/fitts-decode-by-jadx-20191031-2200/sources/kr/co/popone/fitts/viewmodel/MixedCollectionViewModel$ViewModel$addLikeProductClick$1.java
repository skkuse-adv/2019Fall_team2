package kr.co.popone.fitts.viewmodel;

import io.reactivex.functions.Action;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.event.WishStateUpdateEvent;

final class MixedCollectionViewModel$ViewModel$addLikeProductClick$1 implements Action {
    final /* synthetic */ long $id;

    MixedCollectionViewModel$ViewModel$addLikeProductClick$1(long j) {
        this.$id = j;
    }

    public final void run() {
        RxBus.INSTANCE.post(new WishStateUpdateEvent(this.$id, true));
    }
}
