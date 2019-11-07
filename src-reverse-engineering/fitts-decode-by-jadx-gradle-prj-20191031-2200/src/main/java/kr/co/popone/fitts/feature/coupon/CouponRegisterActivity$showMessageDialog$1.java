package kr.co.popone.fitts.feature.coupon;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0001R$anim;

final class CouponRegisterActivity$showMessageDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ CouponRegisterActivity this$0;

    CouponRegisterActivity$showMessageDialog$1(CouponRegisterActivity couponRegisterActivity) {
        this.this$0 = couponRegisterActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.setResult(-1);
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
