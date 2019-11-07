package kr.co.popone.fitts.feature.payment;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.payment.PaymentAPI;

public final class PaymentModuleActivity_MembersInjector implements MembersInjector<PaymentModuleActivity> {
    private final Provider<PaymentAPI> paymentApiProvider;

    public PaymentModuleActivity_MembersInjector(Provider<PaymentAPI> provider) {
        this.paymentApiProvider = provider;
    }

    public static MembersInjector<PaymentModuleActivity> create(Provider<PaymentAPI> provider) {
        return new PaymentModuleActivity_MembersInjector(provider);
    }

    public void injectMembers(PaymentModuleActivity paymentModuleActivity) {
        injectPaymentApi(paymentModuleActivity, (PaymentAPI) this.paymentApiProvider.get());
    }

    public static void injectPaymentApi(PaymentModuleActivity paymentModuleActivity, PaymentAPI paymentAPI) {
        paymentModuleActivity.paymentApi = paymentAPI;
    }
}
