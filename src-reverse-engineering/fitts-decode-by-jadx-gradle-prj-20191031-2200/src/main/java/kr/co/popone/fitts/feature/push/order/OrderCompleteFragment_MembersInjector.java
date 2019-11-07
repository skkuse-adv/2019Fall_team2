package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class OrderCompleteFragment_MembersInjector implements MembersInjector<OrderCompleteFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public OrderCompleteFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderCompleteFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new OrderCompleteFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderCompleteFragment orderCompleteFragment) {
        injectViewModel(orderCompleteFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderCompleteFragment orderCompleteFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        orderCompleteFragment.viewModel = orderPushRendingViewModel;
    }
}
