package kr.co.popone.fitts.feature.reward;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.payment.PaymentAPI;

public final class UsedRewardHistoryFragment_MembersInjector implements MembersInjector<UsedRewardHistoryFragment> {
    private final Provider<PaymentAPI> paymentAPIProvider;

    public UsedRewardHistoryFragment_MembersInjector(Provider<PaymentAPI> provider) {
        this.paymentAPIProvider = provider;
    }

    public static MembersInjector<UsedRewardHistoryFragment> create(Provider<PaymentAPI> provider) {
        return new UsedRewardHistoryFragment_MembersInjector(provider);
    }

    public void injectMembers(UsedRewardHistoryFragment usedRewardHistoryFragment) {
        injectPaymentAPI(usedRewardHistoryFragment, (PaymentAPI) this.paymentAPIProvider.get());
    }

    public static void injectPaymentAPI(UsedRewardHistoryFragment usedRewardHistoryFragment, PaymentAPI paymentAPI) {
        usedRewardHistoryFragment.paymentAPI = paymentAPI;
    }
}
