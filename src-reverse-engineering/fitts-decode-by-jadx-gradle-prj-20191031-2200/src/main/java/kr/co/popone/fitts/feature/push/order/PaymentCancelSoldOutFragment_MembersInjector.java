package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class PaymentCancelSoldOutFragment_MembersInjector implements MembersInjector<PaymentCancelSoldOutFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public PaymentCancelSoldOutFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<PaymentCancelSoldOutFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new PaymentCancelSoldOutFragment_MembersInjector(provider);
    }

    public void injectMembers(PaymentCancelSoldOutFragment paymentCancelSoldOutFragment) {
        injectViewModel(paymentCancelSoldOutFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(PaymentCancelSoldOutFragment paymentCancelSoldOutFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        paymentCancelSoldOutFragment.viewModel = orderPushRendingViewModel;
    }
}
