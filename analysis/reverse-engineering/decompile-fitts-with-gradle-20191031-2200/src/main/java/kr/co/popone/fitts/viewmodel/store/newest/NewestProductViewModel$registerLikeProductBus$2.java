package kr.co.popone.fitts.viewmodel.store.newest;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class NewestProductViewModel$registerLikeProductBus$2<T> implements Consumer<Throwable> {
    public static final NewestProductViewModel$registerLikeProductBus$2 INSTANCE = new NewestProductViewModel$registerLikeProductBus$2();

    NewestProductViewModel$registerLikeProductBus$2() {
    }

    public final void accept(Throwable th) {
        Logger.d("Observing Failed about WishStateUpdateEvent", new Object[0]);
    }
}
