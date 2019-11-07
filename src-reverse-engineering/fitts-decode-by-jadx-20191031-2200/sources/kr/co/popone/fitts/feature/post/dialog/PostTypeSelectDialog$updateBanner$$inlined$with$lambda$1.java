package kr.co.popone.fitts.feature.post.dialog;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.banner.Banner;

final class PostTypeSelectDialog$updateBanner$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Banner $banner$inlined;
    final /* synthetic */ PostTypeSelectDialog this$0;

    PostTypeSelectDialog$updateBanner$$inlined$with$lambda$1(Banner banner, Context context, PostTypeSelectDialog postTypeSelectDialog, Banner banner2) {
        this.$banner$inlined = banner;
        this.this$0 = postTypeSelectDialog;
    }

    public final void onClick(View view) {
        this.this$0.delegate.onBannerClicked(this.$banner$inlined.getScheme());
    }
}
