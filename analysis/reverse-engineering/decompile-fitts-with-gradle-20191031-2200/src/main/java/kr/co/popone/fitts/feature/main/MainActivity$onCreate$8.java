package kr.co.popone.fitts.feature.main;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.BiConsumer;
import java.util.List;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;

final class MainActivity$onCreate$8<T1, T2> implements BiConsumer<List<? extends Banner>, Throwable> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$8(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void accept(List<Banner> list, Throwable th) {
        if (list != null) {
            this.this$0.updateDrawerBanner(list);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("MainActivity::getBannerList=");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
    }
}
