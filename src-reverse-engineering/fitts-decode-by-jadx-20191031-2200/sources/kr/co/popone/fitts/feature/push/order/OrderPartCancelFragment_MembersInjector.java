package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class OrderPartCancelFragment_MembersInjector implements MembersInjector<OrderPartCancelFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public OrderPartCancelFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderPartCancelFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new OrderPartCancelFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderPartCancelFragment orderPartCancelFragment) {
        injectViewModel(orderPartCancelFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderPartCancelFragment orderPartCancelFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        orderPartCancelFragment.viewModel = orderPushRendingViewModel;
    }
}
