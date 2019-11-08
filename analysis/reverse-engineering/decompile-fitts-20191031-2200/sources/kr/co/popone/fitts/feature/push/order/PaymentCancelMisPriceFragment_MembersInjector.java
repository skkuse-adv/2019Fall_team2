package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class PaymentCancelMisPriceFragment_MembersInjector implements MembersInjector<PaymentCancelMisPriceFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public PaymentCancelMisPriceFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<PaymentCancelMisPriceFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new PaymentCancelMisPriceFragment_MembersInjector(provider);
    }

    public void injectMembers(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
        injectViewModel(paymentCancelMisPriceFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        paymentCancelMisPriceFragment.viewModel = orderPushRendingViewModel;
    }
}
