package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class OrderReservationSoldOutFragment_MembersInjector implements MembersInjector<OrderReservationSoldOutFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public OrderReservationSoldOutFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderReservationSoldOutFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new OrderReservationSoldOutFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderReservationSoldOutFragment orderReservationSoldOutFragment) {
        injectViewModel(orderReservationSoldOutFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderReservationSoldOutFragment orderReservationSoldOutFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        orderReservationSoldOutFragment.viewModel = orderPushRendingViewModel;
    }
}
