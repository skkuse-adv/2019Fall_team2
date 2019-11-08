package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class CouponUseActivity$onCreate$10 implements OnClickListener {
    final /* synthetic */ CouponUseActivity this$0;

    CouponUseActivity$onCreate$10(CouponUseActivity couponUseActivity) {
        this.this$0 = couponUseActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
