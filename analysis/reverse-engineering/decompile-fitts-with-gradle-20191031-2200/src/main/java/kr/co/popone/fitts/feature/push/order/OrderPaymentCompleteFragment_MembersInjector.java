package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class OrderPaymentCompleteFragment_MembersInjector implements MembersInjector<OrderPaymentCompleteFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public OrderPaymentCompleteFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderPaymentCompleteFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new OrderPaymentCompleteFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
        injectViewModel(orderPaymentCompleteFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderPaymentCompleteFragment orderPaymentCompleteFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        orderPaymentCompleteFragment.viewModel = orderPushRendingViewModel;
    }
}
