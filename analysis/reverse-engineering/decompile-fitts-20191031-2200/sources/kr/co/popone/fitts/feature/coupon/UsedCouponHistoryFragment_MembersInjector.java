package kr.co.popone.fitts.feature.coupon;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.payment.PaymentAPI;

public final class UsedCouponHistoryFragment_MembersInjector implements MembersInjector<UsedCouponHistoryFragment> {
    private final Provider<PaymentAPI> paymentAPIProvider;

    public UsedCouponHistoryFragment_MembersInjector(Provider<PaymentAPI> provider) {
        this.paymentAPIProvider = provider;
    }

    public static MembersInjector<UsedCouponHistoryFragment> create(Provider<PaymentAPI> provider) {
        return new UsedCouponHistoryFragment_MembersInjector(provider);
    }

    public void injectMembers(UsedCouponHistoryFragment usedCouponHistoryFragment) {
        injectPaymentAPI(usedCouponHistoryFragment, (PaymentAPI) this.paymentAPIProvider.get());
    }

    public static void injectPaymentAPI(UsedCouponHistoryFragment usedCouponHistoryFragment, PaymentAPI paymentAPI) {
        usedCouponHistoryFragment.paymentAPI = paymentAPI;
    }
}
