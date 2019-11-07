package kr.co.popone.fitts.feature.coupon;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.payment.PaymentAPI;

public final class CouponUseConfirmActivity_MembersInjector implements MembersInjector<CouponUseConfirmActivity> {
    private final Provider<PaymentAPI> paymentAPIProvider;

    public CouponUseConfirmActivity_MembersInjector(Provider<PaymentAPI> provider) {
        this.paymentAPIProvider = provider;
    }

    public static MembersInjector<CouponUseConfirmActivity> create(Provider<PaymentAPI> provider) {
        return new CouponUseConfirmActivity_MembersInjector(provider);
    }

    public void injectMembers(CouponUseConfirmActivity couponUseConfirmActivity) {
        injectPaymentAPI(couponUseConfirmActivity, (PaymentAPI) this.paymentAPIProvider.get());
    }

    public static void injectPaymentAPI(CouponUseConfirmActivity couponUseConfirmActivity, PaymentAPI paymentAPI) {
        couponUseConfirmActivity.paymentAPI = paymentAPI;
    }
}
