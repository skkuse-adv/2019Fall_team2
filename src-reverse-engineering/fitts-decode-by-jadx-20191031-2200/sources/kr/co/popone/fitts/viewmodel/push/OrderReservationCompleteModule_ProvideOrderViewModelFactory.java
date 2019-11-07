package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.OrderReservationCompleteFragment;

public final class OrderReservationCompleteModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<OrderReservationCompleteFragment> fragmentProvider;
    private final OrderReservationCompleteModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public OrderReservationCompleteModule_ProvideOrderViewModelFactory(OrderReservationCompleteModule orderReservationCompleteModule, Provider<OrderReservationCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = orderReservationCompleteModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(OrderReservationCompleteModule orderReservationCompleteModule, Provider<OrderReservationCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderReservationCompleteModule, (OrderReservationCompleteFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static OrderReservationCompleteModule_ProvideOrderViewModelFactory create(OrderReservationCompleteModule orderReservationCompleteModule, Provider<OrderReservationCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new OrderReservationCompleteModule_ProvideOrderViewModelFactory(orderReservationCompleteModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(OrderReservationCompleteModule orderReservationCompleteModule, OrderReservationCompleteFragment orderReservationCompleteFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(orderReservationCompleteModule.provideOrderViewModel(orderReservationCompleteFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
