package kr.co.popone.fitts.feature.coupon;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;

final class CouponPointInputUserInfoActivity$confirmModifyUserInfo$2<T> implements Consumer<Throwable> {
    final /* synthetic */ CouponPointInputUserInfoActivity this$0;

    CouponPointInputUserInfoActivity$confirmModifyUserInfo$2(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity) {
        this.this$0 = couponPointInputUserInfoActivity;
    }

    public final void accept(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("error ");
        sb.append(th);
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.userInfoRegisterDisposable = null;
        this.this$0.loadingSubject.onNext(Boolean.valueOf(false));
    }
}
