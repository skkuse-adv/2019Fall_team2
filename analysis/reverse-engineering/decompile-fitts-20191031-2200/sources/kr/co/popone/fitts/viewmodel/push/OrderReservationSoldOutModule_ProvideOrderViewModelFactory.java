package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.OrderReservationSoldOutFragment;

public final class OrderReservationSoldOutModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<OrderReservationSoldOutFragment> fragmentProvider;
    private final OrderReservationSoldOutModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public OrderReservationSoldOutModule_ProvideOrderViewModelFactory(OrderReservationSoldOutModule orderReservationSoldOutModule, Provider<OrderReservationSoldOutFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = orderReservationSoldOutModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(OrderReservationSoldOutModule orderReservationSoldOutModule, Provider<OrderReservationSoldOutFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderReservationSoldOutModule, (OrderReservationSoldOutFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static OrderReservationSoldOutModule_ProvideOrderViewModelFactory create(OrderReservationSoldOutModule orderReservationSoldOutModule, Provider<OrderReservationSoldOutFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new OrderReservationSoldOutModule_ProvideOrderViewModelFactory(orderReservationSoldOutModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(OrderReservationSoldOutModule orderReservationSoldOutModule, OrderReservationSoldOutFragment orderReservationSoldOutFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(orderReservationSoldOutModule.provideOrderViewModel(orderReservationSoldOutFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
