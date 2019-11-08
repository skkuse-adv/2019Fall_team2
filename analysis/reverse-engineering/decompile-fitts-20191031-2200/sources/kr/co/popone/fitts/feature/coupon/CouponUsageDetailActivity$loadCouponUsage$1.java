package kr.co.popone.fitts.feature.coupon;

import io.reactivex.functions.BiConsumer;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.model.payment.PaymentAPI.PaymentUsage;

final class CouponUsageDetailActivity$loadCouponUsage$1<T1, T2> implements BiConsumer<PaymentUsage, Throwable> {
    final /* synthetic */ CouponUsageDetailActivity this$0;

    CouponUsageDetailActivity$loadCouponUsage$1(CouponUsageDetailActivity couponUsageDetailActivity) {
        this.this$0 = couponUsageDetailActivity;
    }

    public final void accept(PaymentUsage paymentUsage, Throwable th) {
        if (paymentUsage != null) {
            this.this$0.couponUsageRequest = null;
            this.this$0.paymentUsage = paymentUsage;
            this.this$0.updateUI();
            return;
        }
        ActivityExtensionKt.handleError(this.this$0, th);
    }
}
