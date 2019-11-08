package kr.co.popone.fitts.viewmodel.store.newest;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.WishStateUpdateEvent;

final class NewestProductViewModel$registerLikeProductBus$1<T> implements Consumer<WishStateUpdateEvent> {
    final /* synthetic */ NewestProductViewModel this$0;

    NewestProductViewModel$registerLikeProductBus$1(NewestProductViewModel newestProductViewModel) {
        this.this$0 = newestProductViewModel;
    }

    public final void accept(WishStateUpdateEvent wishStateUpdateEvent) {
        this.this$0._productLikeEvent.postValue(wishStateUpdateEvent);
    }
}
