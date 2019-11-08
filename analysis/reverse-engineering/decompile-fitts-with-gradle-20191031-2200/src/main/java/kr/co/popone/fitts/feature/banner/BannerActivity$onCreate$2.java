package kr.co.popone.fitts.feature.banner;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class BannerActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ BannerActivity this$0;

    BannerActivity$onCreate$2(BannerActivity bannerActivity) {
        this.this$0 = bannerActivity;
    }

    public final void onClick(View view) {
        ActivityExtensionKt.finishWithAnimation(this.this$0, ActivityAnimationType.SLIDE_LTOR);
    }
}
