package kr.co.popone.fitts.feature.reward;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.payment.PaymentAPI;

public final class RewardUsageDetailActivity_MembersInjector implements MembersInjector<RewardUsageDetailActivity> {
    private final Provider<PaymentAPI> paymentAPIProvider;

    public RewardUsageDetailActivity_MembersInjector(Provider<PaymentAPI> provider) {
        this.paymentAPIProvider = provider;
    }

    public static MembersInjector<RewardUsageDetailActivity> create(Provider<PaymentAPI> provider) {
        return new RewardUsageDetailActivity_MembersInjector(provider);
    }

    public void injectMembers(RewardUsageDetailActivity rewardUsageDetailActivity) {
        injectPaymentAPI(rewardUsageDetailActivity, (PaymentAPI) this.paymentAPIProvider.get());
    }

    public static void injectPaymentAPI(RewardUsageDetailActivity rewardUsageDetailActivity, PaymentAPI paymentAPI) {
        rewardUsageDetailActivity.paymentAPI = paymentAPI;
    }
}
