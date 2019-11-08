package kr.co.popone.fitts.feature.coupon;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Action;

final class CouponPointInputUserInfoActivity$confirmModifyUserInfo$1 implements Action {
    final /* synthetic */ CouponPointInputUserInfoActivity this$0;

    CouponPointInputUserInfoActivity$confirmModifyUserInfo$1(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity) {
        this.this$0 = couponPointInputUserInfoActivity;
    }

    public final void run() {
        Logger.d("success updateAditionalInfo", new Object[0]);
        this.this$0.userInfoRegisterDisposable = null;
        this.this$0.loadingSubject.onNext(Boolean.valueOf(false));
        this.this$0.setResult(-1);
        this.this$0.onBackPressed();
    }
}
