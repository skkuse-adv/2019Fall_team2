package kr.co.popone.fitts.feature.order.complete;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderViewModel;

public final class OrderCompleteRenderReservationFragment_MembersInjector implements MembersInjector<OrderCompleteRenderReservationFragment> {
    private final Provider<OrderCompleteRenderViewModel> viewModelProvider;

    public OrderCompleteRenderReservationFragment_MembersInjector(Provider<OrderCompleteRenderViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderCompleteRenderReservationFragment> create(Provider<OrderCompleteRenderViewModel> provider) {
        return new OrderCompleteRenderReservationFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment) {
        injectViewModel(orderCompleteRenderReservationFragment, (OrderCompleteRenderViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment, OrderCompleteRenderViewModel orderCompleteRenderViewModel) {
        orderCompleteRenderReservationFragment.viewModel = orderCompleteRenderViewModel;
    }
}
