package kr.co.popone.fitts.viewmodel.store.home;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.WishStateUpdateEvent;

final class StoreFeedViewModel$registerLikeProductBus$1<T> implements Consumer<WishStateUpdateEvent> {
    final /* synthetic */ StoreFeedViewModel this$0;

    StoreFeedViewModel$registerLikeProductBus$1(StoreFeedViewModel storeFeedViewModel) {
        this.this$0 = storeFeedViewModel;
    }

    public final void accept(WishStateUpdateEvent wishStateUpdateEvent) {
        this.this$0._productLikeEvent.postValue(wishStateUpdateEvent);
    }
}
