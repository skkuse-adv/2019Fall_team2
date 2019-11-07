package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.OrderShippingCompleteFragment;

public final class OrderShippingCompleteModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<OrderShippingCompleteFragment> fragmentProvider;
    private final OrderShippingCompleteModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public OrderShippingCompleteModule_ProvideOrderViewModelFactory(OrderShippingCompleteModule orderShippingCompleteModule, Provider<OrderShippingCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = orderShippingCompleteModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(OrderShippingCompleteModule orderShippingCompleteModule, Provider<OrderShippingCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderShippingCompleteModule, (OrderShippingCompleteFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static OrderShippingCompleteModule_ProvideOrderViewModelFactory create(OrderShippingCompleteModule orderShippingCompleteModule, Provider<OrderShippingCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new OrderShippingCompleteModule_ProvideOrderViewModelFactory(orderShippingCompleteModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(OrderShippingCompleteModule orderShippingCompleteModule, OrderShippingCompleteFragment orderShippingCompleteFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(orderShippingCompleteModule.provideOrderViewModel(orderShippingCompleteFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
