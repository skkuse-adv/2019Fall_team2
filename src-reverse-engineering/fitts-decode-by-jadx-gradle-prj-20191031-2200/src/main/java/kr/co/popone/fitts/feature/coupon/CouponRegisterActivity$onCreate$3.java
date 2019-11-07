package kr.co.popone.fitts.feature.coupon;

import android.view.View;
import android.view.View.OnClickListener;
import com.orhanobut.logger.Logger;

final class CouponRegisterActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ CouponRegisterActivity this$0;

    CouponRegisterActivity$onCreate$3(CouponRegisterActivity couponRegisterActivity) {
        this.this$0 = couponRegisterActivity;
    }

    public final void onClick(View view) {
        Logger.d("confirmButton clicked", new Object[0]);
        this.this$0.loadingSubject.onNext(Boolean.valueOf(true));
        this.this$0.requestRegisterCoupon();
    }
}
