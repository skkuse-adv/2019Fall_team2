package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class CouponHomeActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ CouponHomeActivity this$0;

    CouponHomeActivity$onCreate$1(CouponHomeActivity couponHomeActivity) {
        this.this$0 = couponHomeActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_left_out);
    }
}
