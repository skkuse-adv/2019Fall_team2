package kr.co.popone.fitts.feature.banner;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;

final class BannerItemHolder$bindTo$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Banner $banner$inlined;
    final /* synthetic */ BannerItemHolder this$0;

    BannerItemHolder$bindTo$$inlined$with$lambda$1(BannerItemHolder bannerItemHolder, Banner banner) {
        this.this$0 = bannerItemHolder;
        this.$banner$inlined = banner;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onBannerClicked(this.$banner$inlined.getScheme());
    }
}
