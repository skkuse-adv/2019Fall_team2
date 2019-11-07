package kr.co.popone.fitts.feature.banner;

import androidx.lifecycle.Observer;
import java.util.List;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;

final class BannerActivity$onCreate$8<T> implements Observer<List<? extends Banner>> {
    final /* synthetic */ BannerActivity this$0;

    BannerActivity$onCreate$8(BannerActivity bannerActivity) {
        this.this$0 = bannerActivity;
    }

    public final void onChanged(List<Banner> list) {
        if (list != null) {
            this.this$0.bannerAdapter.setItems(list);
            this.this$0.bannerAdapter.notifyDataSetChanged();
        }
    }
}
