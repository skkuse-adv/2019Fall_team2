package kr.co.popone.fitts.feature.order.complete;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderViewModel;

public final class OrderCompleteRenderPaymentFragment_MembersInjector implements MembersInjector<OrderCompleteRenderPaymentFragment> {
    private final Provider<OrderCompleteRenderViewModel> viewModelProvider;

    public OrderCompleteRenderPaymentFragment_MembersInjector(Provider<OrderCompleteRenderViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderCompleteRenderPaymentFragment> create(Provider<OrderCompleteRenderViewModel> provider) {
        return new OrderCompleteRenderPaymentFragment_MembersInjector(provider);
    }

    public void injectMembers(OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment) {
        injectViewModel(orderCompleteRenderPaymentFragment, (OrderCompleteRenderViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment, OrderCompleteRenderViewModel orderCompleteRenderViewModel) {
        orderCompleteRenderPaymentFragment.viewModel = orderCompleteRenderViewModel;
    }
}
