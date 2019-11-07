package kr.co.popone.fitts.viewmodel.store.home;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class StoreFeedViewModel$registerShopBookmarkBus$2<T> implements Consumer<Throwable> {
    public static final StoreFeedViewModel$registerShopBookmarkBus$2 INSTANCE = new StoreFeedViewModel$registerShopBookmarkBus$2();

    StoreFeedViewModel$registerShopBookmarkBus$2() {
    }

    public final void accept(Throwable th) {
        Logger.d("Observing Failed about ShopBookmarkEvent", new Object[0]);
    }
}
