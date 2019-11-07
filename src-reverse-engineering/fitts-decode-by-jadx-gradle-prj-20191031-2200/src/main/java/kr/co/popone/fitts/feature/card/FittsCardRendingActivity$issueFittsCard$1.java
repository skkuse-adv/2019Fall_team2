package kr.co.popone.fitts.feature.card;

import com.orhanobut.logger.Logger;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.coupon.CouponAPI.CouponRegisterResult;

final class FittsCardRendingActivity$issueFittsCard$1<T> implements Consumer<CouponRegisterResult> {
    final /* synthetic */ FittsCardRendingActivity this$0;

    FittsCardRendingActivity$issueFittsCard$1(FittsCardRendingActivity fittsCardRendingActivity) {
        this.this$0 = fittsCardRendingActivity;
    }

    public final void accept(CouponRegisterResult couponRegisterResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("FittsCardRendingActivity::issueFittsCard msg = ");
        sb.append(couponRegisterResult.getMessage());
        Logger.d(sb.toString(), new Object[0]);
        this.this$0.handleFittsCardIssued(couponRegisterResult.getMessage());
    }
}
