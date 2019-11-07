package kr.co.popone.fitts.viewmodel.banner;

import io.reactivex.functions.BiConsumer;
import java.util.List;
import kr.co.popone.fitts.base.type.NetworkState;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;

final class BannerViewModel$getBannerList$$inlined$let$lambda$1<T1, T2> implements BiConsumer<List<? extends Banner>, Throwable> {
    final /* synthetic */ BannerViewModel this$0;

    BannerViewModel$getBannerList$$inlined$let$lambda$1(BannerViewModel bannerViewModel) {
        this.this$0 = bannerViewModel;
    }

    public final void accept(List<Banner> list, Throwable th) {
        if (list != null) {
            this.this$0.getBannerListLiveData().setValue(list);
            this.this$0.getNetworkState().setValue(NetworkState.Companion.getLOADED());
            return;
        }
        this.this$0.getErrorLiveData().setValue(th);
        this.this$0.getNetworkState().setValue(NetworkState.Companion.error(th));
    }
}
