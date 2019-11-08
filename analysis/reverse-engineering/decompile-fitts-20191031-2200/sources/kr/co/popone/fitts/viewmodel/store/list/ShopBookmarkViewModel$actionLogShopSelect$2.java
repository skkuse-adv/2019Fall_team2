package kr.co.popone.fitts.viewmodel.store.list;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class ShopBookmarkViewModel$actionLogShopSelect$2<T> implements Consumer<Throwable> {
    public static final ShopBookmarkViewModel$actionLogShopSelect$2 INSTANCE = new ShopBookmarkViewModel$actionLogShopSelect$2();

    ShopBookmarkViewModel$actionLogShopSelect$2() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogFail::");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
