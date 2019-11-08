package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.OrderCompleteFragment;

public final class OrderCompleteModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<OrderCompleteFragment> fragmentProvider;
    private final OrderCompleteModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public OrderCompleteModule_ProvideOrderViewModelFactory(OrderCompleteModule orderCompleteModule, Provider<OrderCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = orderCompleteModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(OrderCompleteModule orderCompleteModule, Provider<OrderCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderCompleteModule, (OrderCompleteFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static OrderCompleteModule_ProvideOrderViewModelFactory create(OrderCompleteModule orderCompleteModule, Provider<OrderCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new OrderCompleteModule_ProvideOrderViewModelFactory(orderCompleteModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(OrderCompleteModule orderCompleteModule, OrderCompleteFragment orderCompleteFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(orderCompleteModule.provideOrderViewModel(orderCompleteFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
