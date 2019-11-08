package kr.co.popone.fitts.viewmodel.banner;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Action;

final class BannerViewModel$handleBannerScheme$1$1 implements Action {
    final /* synthetic */ String $it;

    BannerViewModel$handleBannerScheme$1$1(String str) {
        this.$it = str;
    }

    public final void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionLogSuccess:: Type = collection, MainPath = ");
        sb.append(this.$it);
        Logger.d(sb.toString(), new Object[0]);
    }
}
