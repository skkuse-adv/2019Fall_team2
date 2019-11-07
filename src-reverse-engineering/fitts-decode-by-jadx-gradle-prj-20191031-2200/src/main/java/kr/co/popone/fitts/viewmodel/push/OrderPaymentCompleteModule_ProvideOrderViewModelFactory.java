package kr.co.popone.fitts.viewmodel.push;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.push.order.OrderPaymentCompleteFragment;

public final class OrderPaymentCompleteModule_ProvideOrderViewModelFactory implements Factory<OrderPushRendingViewModel> {
    private final Provider<OrderPaymentCompleteFragment> fragmentProvider;
    private final OrderPaymentCompleteModule module;
    private final Provider<OrderPushRendingViewModelFactory> viewModelFactoryProvider;

    public OrderPaymentCompleteModule_ProvideOrderViewModelFactory(OrderPaymentCompleteModule orderPaymentCompleteModule, Provider<OrderPaymentCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        this.module = orderPaymentCompleteModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderPushRendingViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderPushRendingViewModel provideInstance(OrderPaymentCompleteModule orderPaymentCompleteModule, Provider<OrderPaymentCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderPaymentCompleteModule, (OrderPaymentCompleteFragment) provider.get(), (OrderPushRendingViewModelFactory) provider2.get());
    }

    public static OrderPaymentCompleteModule_ProvideOrderViewModelFactory create(OrderPaymentCompleteModule orderPaymentCompleteModule, Provider<OrderPaymentCompleteFragment> provider, Provider<OrderPushRendingViewModelFactory> provider2) {
        return new OrderPaymentCompleteModule_ProvideOrderViewModelFactory(orderPaymentCompleteModule, provider, provider2);
    }

    public static OrderPushRendingViewModel proxyProvideOrderViewModel(OrderPaymentCompleteModule orderPaymentCompleteModule, OrderPaymentCompleteFragment orderPaymentCompleteFragment, OrderPushRendingViewModelFactory orderPushRendingViewModelFactory) {
        return (OrderPushRendingViewModel) Preconditions.checkNotNull(orderPaymentCompleteModule.provideOrderViewModel(orderPaymentCompleteFragment, orderPushRendingViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
