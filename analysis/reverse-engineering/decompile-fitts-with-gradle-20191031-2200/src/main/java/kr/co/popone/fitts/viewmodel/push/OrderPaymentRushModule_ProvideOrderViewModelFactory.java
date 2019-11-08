package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.OrderPaymentRushFragment;

public final class OrderPaymentRushModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<OrderPaymentRushFragment> fragmentProvider;
    private final OrderPaymentRushModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public OrderPaymentRushModule_ProvideOrderViewModelFactory(OrderPaymentRushModule orderPaymentRushModule, Provider<OrderPaymentRushFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = orderPaymentRushModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(OrderPaymentRushModule orderPaymentRushModule, Provider<OrderPaymentRushFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderPaymentRushModule, (OrderPaymentRushFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static OrderPaymentRushModule_ProvideOrderViewModelFactory create(OrderPaymentRushModule orderPaymentRushModule, Provider<OrderPaymentRushFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new OrderPaymentRushModule_ProvideOrderViewModelFactory(orderPaymentRushModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(OrderPaymentRushModule orderPaymentRushModule, OrderPaymentRushFragment orderPaymentRushFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(orderPaymentRushModule.provideOrderViewModel(orderPaymentRushFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
