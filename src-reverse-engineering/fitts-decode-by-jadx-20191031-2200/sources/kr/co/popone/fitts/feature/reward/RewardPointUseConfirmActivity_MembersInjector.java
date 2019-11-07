package kr.co.popone.fitts.feature.reward;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.payment.PaymentAPI;

public final class RewardPointUseConfirmActivity_MembersInjector implements MembersInjector<RewardPointUseConfirmActivity> {
    private final Provider<PaymentAPI> paymentAPIProvider;

    public RewardPointUseConfirmActivity_MembersInjector(Provider<PaymentAPI> provider) {
        this.paymentAPIProvider = provider;
    }

    public static MembersInjector<RewardPointUseConfirmActivity> create(Provider<PaymentAPI> provider) {
        return new RewardPointUseConfirmActivity_MembersInjector(provider);
    }

    public void injectMembers(RewardPointUseConfirmActivity rewardPointUseConfirmActivity) {
        injectPaymentAPI(rewardPointUseConfirmActivity, (PaymentAPI) this.paymentAPIProvider.get());
    }

    public static void injectPaymentAPI(RewardPointUseConfirmActivity rewardPointUseConfirmActivity, PaymentAPI paymentAPI) {
        rewardPointUseConfirmActivity.paymentAPI = paymentAPI;
    }
}
