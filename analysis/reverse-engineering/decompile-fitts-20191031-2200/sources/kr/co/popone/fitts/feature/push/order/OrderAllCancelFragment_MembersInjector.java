package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class OrderAllCancelFragment_MembersInjector implements MembersInjector<OrderAllCancelFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public OrderAllCancelFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderAllCancelFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new OrderAllCancelFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderAllCancelFragment orderAllCancelFragment) {
        injectViewModel(orderAllCancelFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderAllCancelFragment orderAllCancelFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        orderAllCancelFragment.viewModel = orderPushRendingViewModel;
    }
}
