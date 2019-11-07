package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class CouponUseConfirmActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ CouponUseConfirmActivity this$0;

    CouponUseConfirmActivity$onCreate$1(CouponUseConfirmActivity couponUseConfirmActivity) {
        this.this$0 = couponUseConfirmActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
