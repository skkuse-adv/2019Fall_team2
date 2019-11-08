package kr.co.popone.fitts.viewmodel.store.home;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.ShopBookmarkEvent;

final class StoreFeedViewModel$registerShopBookmarkBus$1<T> implements Consumer<ShopBookmarkEvent> {
    final /* synthetic */ StoreFeedViewModel this$0;

    StoreFeedViewModel$registerShopBookmarkBus$1(StoreFeedViewModel storeFeedViewModel) {
        this.this$0 = storeFeedViewModel;
    }

    public final void accept(ShopBookmarkEvent shopBookmarkEvent) {
        this.this$0._bookmarkEvent.postValue(shopBookmarkEvent);
    }
}
