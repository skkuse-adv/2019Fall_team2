package kr.co.popone.fitts.feature.coupon;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.model.payment.PaymentAPI;

public final class CouponUsageDetailActivity_MembersInjector implements MembersInjector<CouponUsageDetailActivity> {
    private final Provider<CouponAPI> couponAPIProvider;
    private final Provider<PaymentAPI> paymentAPIProvider;

    public CouponUsageDetailActivity_MembersInjector(Provider<CouponAPI> provider, Provider<PaymentAPI> provider2) {
        this.couponAPIProvider = provider;
        this.paymentAPIProvider = provider2;
    }

    public static MembersInjector<CouponUsageDetailActivity> create(Provider<CouponAPI> provider, Provider<PaymentAPI> provider2) {
        return new CouponUsageDetailActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(CouponUsageDetailActivity couponUsageDetailActivity) {
        injectCouponAPI(couponUsageDetailActivity, (CouponAPI) this.couponAPIProvider.get());
        injectPaymentAPI(couponUsageDetailActivity, (PaymentAPI) this.paymentAPIProvider.get());
    }

    public static void injectCouponAPI(CouponUsageDetailActivity couponUsageDetailActivity, CouponAPI couponAPI) {
        couponUsageDetailActivity.couponAPI = couponAPI;
    }

    public static void injectPaymentAPI(CouponUsageDetailActivity couponUsageDetailActivity, PaymentAPI paymentAPI) {
        couponUsageDetailActivity.paymentAPI = paymentAPI;
    }
}
