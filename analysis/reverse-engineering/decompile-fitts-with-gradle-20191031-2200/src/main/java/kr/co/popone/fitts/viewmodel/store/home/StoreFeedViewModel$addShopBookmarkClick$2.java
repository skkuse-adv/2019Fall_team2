package kr.co.popone.fitts.viewmodel.store.home;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class StoreFeedViewModel$addShopBookmarkClick$2<T> implements Consumer<Throwable> {
    public static final StoreFeedViewModel$addShopBookmarkClick$2 INSTANCE = new StoreFeedViewModel$addShopBookmarkClick$2();

    StoreFeedViewModel$addShopBookmarkClick$2() {
    }

    public final void accept(Throwable th) {
        Logger.d("Add bookmark on shop is failed", new Object[0]);
    }
}
