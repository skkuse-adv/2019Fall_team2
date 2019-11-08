package kr.co.popone.fitts.viewmodel.store.bridge;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class ShopBridgeViewModel$getShopDetailInfo$2<T> implements Consumer<Throwable> {
    public static final ShopBridgeViewModel$getShopDetailInfo$2 INSTANCE = new ShopBridgeViewModel$getShopDetailInfo$2();

    ShopBridgeViewModel$getShopDetailInfo$2() {
    }

    public final void accept(Throwable th) {
        Logger.d(th);
    }
}
