package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class OrderReservationCompleteFragment_MembersInjector implements MembersInjector<OrderReservationCompleteFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public OrderReservationCompleteFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderReservationCompleteFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new OrderReservationCompleteFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderReservationCompleteFragment orderReservationCompleteFragment) {
        injectViewModel(orderReservationCompleteFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderReservationCompleteFragment orderReservationCompleteFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        orderReservationCompleteFragment.viewModel = orderPushRendingViewModel;
    }
}
