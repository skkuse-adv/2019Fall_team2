package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.OrderAllCancelFragment;

public final class OrderAllCancelModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<OrderAllCancelFragment> fragmentProvider;
    private final OrderAllCancelModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public OrderAllCancelModule_ProvideOrderViewModelFactory(OrderAllCancelModule orderAllCancelModule, Provider<OrderAllCancelFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = orderAllCancelModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(OrderAllCancelModule orderAllCancelModule, Provider<OrderAllCancelFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderAllCancelModule, (OrderAllCancelFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static OrderAllCancelModule_ProvideOrderViewModelFactory create(OrderAllCancelModule orderAllCancelModule, Provider<OrderAllCancelFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new OrderAllCancelModule_ProvideOrderViewModelFactory(orderAllCancelModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(OrderAllCancelModule orderAllCancelModule, OrderAllCancelFragment orderAllCancelFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(orderAllCancelModule.provideOrderViewModel(orderAllCancelFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
