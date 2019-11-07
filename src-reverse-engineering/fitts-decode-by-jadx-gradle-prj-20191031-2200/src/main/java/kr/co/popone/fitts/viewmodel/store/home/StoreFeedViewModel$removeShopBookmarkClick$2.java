package kr.co.popone.fitts.viewmodel.store.home;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class StoreFeedViewModel$removeShopBookmarkClick$2<T> implements Consumer<Throwable> {
    public static final StoreFeedViewModel$removeShopBookmarkClick$2 INSTANCE = new StoreFeedViewModel$removeShopBookmarkClick$2();

    StoreFeedViewModel$removeShopBookmarkClick$2() {
    }

    public final void accept(Throwable th) {
        Logger.d("Remove bookmark on shop is failed", new Object[0]);
    }
}
