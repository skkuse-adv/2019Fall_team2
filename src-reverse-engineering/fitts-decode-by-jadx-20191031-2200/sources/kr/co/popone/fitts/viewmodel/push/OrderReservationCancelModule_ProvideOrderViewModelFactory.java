package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.OrderReservationCancelFragment;

public final class OrderReservationCancelModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<OrderReservationCancelFragment> fragmentProvider;
    private final OrderReservationCancelModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public OrderReservationCancelModule_ProvideOrderViewModelFactory(OrderReservationCancelModule orderReservationCancelModule, Provider<OrderReservationCancelFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = orderReservationCancelModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(OrderReservationCancelModule orderReservationCancelModule, Provider<OrderReservationCancelFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderReservationCancelModule, (OrderReservationCancelFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static OrderReservationCancelModule_ProvideOrderViewModelFactory create(OrderReservationCancelModule orderReservationCancelModule, Provider<OrderReservationCancelFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new OrderReservationCancelModule_ProvideOrderViewModelFactory(orderReservationCancelModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(OrderReservationCancelModule orderReservationCancelModule, OrderReservationCancelFragment orderReservationCancelFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(orderReservationCancelModule.provideOrderViewModel(orderReservationCancelFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
