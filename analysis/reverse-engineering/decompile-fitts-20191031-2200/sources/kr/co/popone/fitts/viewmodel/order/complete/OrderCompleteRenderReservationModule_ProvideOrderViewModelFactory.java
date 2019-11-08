package kr.co.popone.fitts.viewmodel.order.complete;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderReservationFragment;

public final class OrderCompleteRenderReservationModule_ProvideOrderViewModelFactory implements Factory<OrderCompleteRenderViewModel> {
    private final Provider<OrderCompleteRenderReservationFragment> fragmentProvider;
    private final OrderCompleteRenderReservationModule module;
    private final Provider<OrderCompleteRenderViewModelFactory> viewModelFactoryProvider;

    public OrderCompleteRenderReservationModule_ProvideOrderViewModelFactory(OrderCompleteRenderReservationModule orderCompleteRenderReservationModule, Provider<OrderCompleteRenderReservationFragment> provider, Provider<OrderCompleteRenderViewModelFactory> provider2) {
        this.module = orderCompleteRenderReservationModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderCompleteRenderViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderCompleteRenderViewModel provideInstance(OrderCompleteRenderReservationModule orderCompleteRenderReservationModule, Provider<OrderCompleteRenderReservationFragment> provider, Provider<OrderCompleteRenderViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderCompleteRenderReservationModule, (OrderCompleteRenderReservationFragment) provider.get(), (OrderCompleteRenderViewModelFactory) provider2.get());
    }

    public static OrderCompleteRenderReservationModule_ProvideOrderViewModelFactory create(OrderCompleteRenderReservationModule orderCompleteRenderReservationModule, Provider<OrderCompleteRenderReservationFragment> provider, Provider<OrderCompleteRenderViewModelFactory> provider2) {
        return new OrderCompleteRenderReservationModule_ProvideOrderViewModelFactory(orderCompleteRenderReservationModule, provider, provider2);
    }

    public static OrderCompleteRenderViewModel proxyProvideOrderViewModel(OrderCompleteRenderReservationModule orderCompleteRenderReservationModule, OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment, OrderCompleteRenderViewModelFactory orderCompleteRenderViewModelFactory) {
        return (OrderCompleteRenderViewModel) Preconditions.checkNotNull(orderCompleteRenderReservationModule.provideOrderViewModel(orderCompleteRenderReservationFragment, orderCompleteRenderViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
