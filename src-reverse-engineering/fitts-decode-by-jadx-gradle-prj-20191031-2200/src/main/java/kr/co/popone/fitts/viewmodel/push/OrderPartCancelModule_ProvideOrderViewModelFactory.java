package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.OrderPartCancelFragment;

public final class OrderPartCancelModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<OrderPartCancelFragment> fragmentProvider;
    private final OrderPartCancelModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public OrderPartCancelModule_ProvideOrderViewModelFactory(OrderPartCancelModule orderPartCancelModule, Provider<OrderPartCancelFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = orderPartCancelModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(OrderPartCancelModule orderPartCancelModule, Provider<OrderPartCancelFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderPartCancelModule, (OrderPartCancelFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static OrderPartCancelModule_ProvideOrderViewModelFactory create(OrderPartCancelModule orderPartCancelModule, Provider<OrderPartCancelFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new OrderPartCancelModule_ProvideOrderViewModelFactory(orderPartCancelModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(OrderPartCancelModule orderPartCancelModule, OrderPartCancelFragment orderPartCancelFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(orderPartCancelModule.provideOrderViewModel(orderPartCancelFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
