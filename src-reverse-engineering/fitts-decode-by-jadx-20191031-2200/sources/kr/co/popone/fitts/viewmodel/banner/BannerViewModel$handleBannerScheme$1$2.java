package kr.co.popone.fitts.viewmodel.banner;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class BannerViewModel$handleBannerScheme$1$2<T> implements Consumer<Throwable> {
    public static final BannerViewModel$handleBannerScheme$1$2 INSTANCE = new BannerViewModel$handleBannerScheme$1$2();

    BannerViewModel$handleBannerScheme$1$2() {
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogFail:: Type = collection, MainPath = ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
