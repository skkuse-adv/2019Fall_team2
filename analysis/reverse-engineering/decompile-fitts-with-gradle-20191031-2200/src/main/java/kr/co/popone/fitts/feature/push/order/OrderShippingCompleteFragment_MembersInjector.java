package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class OrderShippingCompleteFragment_MembersInjector implements MembersInjector<OrderShippingCompleteFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public OrderShippingCompleteFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderShippingCompleteFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new OrderShippingCompleteFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderShippingCompleteFragment orderShippingCompleteFragment) {
        injectViewModel(orderShippingCompleteFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderShippingCompleteFragment orderShippingCompleteFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        orderShippingCompleteFragment.viewModel = orderPushRendingViewModel;
    }
}
