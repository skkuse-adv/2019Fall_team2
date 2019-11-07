package kr.co.popone.fitts.feature.push.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.push.OrderPushRendingViewModel;

public final class OrderReservationCancelFragment_MembersInjector implements MembersInjector<OrderReservationCancelFragment> {
    private final Provider<OrderPushRendingViewModel> viewModelProvider;

    public OrderReservationCancelFragment_MembersInjector(Provider<OrderPushRendingViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderReservationCancelFragment> create(Provider<OrderPushRendingViewModel> provider) {
        return new OrderReservationCancelFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderReservationCancelFragment orderReservationCancelFragment) {
        injectViewModel(orderReservationCancelFragment, (OrderPushRendingViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderReservationCancelFragment orderReservationCancelFragment, OrderPushRendingViewModel orderPushRendingViewModel) {
        orderReservationCancelFragment.viewModel = orderPushRendingViewModel;
    }
}
