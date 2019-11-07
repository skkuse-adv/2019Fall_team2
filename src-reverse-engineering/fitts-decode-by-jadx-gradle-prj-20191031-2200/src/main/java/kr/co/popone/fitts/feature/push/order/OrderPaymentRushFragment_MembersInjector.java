package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class OrderPaymentRushFragment_MembersInjector implements MembersInjector<OrderPaymentRushFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public OrderPaymentRushFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderPaymentRushFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new OrderPaymentRushFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderPaymentRushFragment orderPaymentRushFragment) {
        injectViewModel(orderPaymentRushFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderPaymentRushFragment orderPaymentRushFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        orderPaymentRushFragment.viewModel = orderPushRendingViewModel;
    }
}
