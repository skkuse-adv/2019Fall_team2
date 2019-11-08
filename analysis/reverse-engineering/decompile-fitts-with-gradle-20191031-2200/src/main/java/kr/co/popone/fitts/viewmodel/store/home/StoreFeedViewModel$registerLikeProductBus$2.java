package kr.co.popone.fitts.viewmodel.store.home;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class StoreFeedViewModel$registerLikeProductBus$2<T> implements Consumer<Throwable> {
    public static final StoreFeedViewModel$registerLikeProductBus$2 INSTANCE = new StoreFeedViewModel$registerLikeProductBus$2();

    StoreFeedViewModel$registerLikeProductBus$2() {
    }

    public final void accept(Throwable th) {
        Logger.d("Observing Failed about WishStateUpdateEvent", new Object[0]);
    }
}
