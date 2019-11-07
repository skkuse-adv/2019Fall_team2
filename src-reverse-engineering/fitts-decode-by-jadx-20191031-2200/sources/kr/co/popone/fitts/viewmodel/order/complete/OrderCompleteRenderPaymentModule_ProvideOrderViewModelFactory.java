package kr.co.popone.fitts.viewmodel.order.complete;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderPaymentFragment;

public final class OrderCompleteRenderPaymentModule_ProvideOrderViewModelFactory implements Factory<OrderCompleteRenderViewModel> {
    private final Provider<OrderCompleteRenderPaymentFragment> fragmentProvider;
    private final OrderCompleteRenderPaymentModule module;
    private final Provider<OrderCompleteRenderViewModelFactory> viewModelFactoryProvider;

    public OrderCompleteRenderPaymentModule_ProvideOrderViewModelFactory(OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule, Provider<OrderCompleteRenderPaymentFragment> provider, Provider<OrderCompleteRenderViewModelFactory> provider2) {
        this.module = orderCompleteRenderPaymentModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderCompleteRenderViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static OrderCompleteRenderViewModel provideInstance(OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule, Provider<OrderCompleteRenderPaymentFragment> provider, Provider<OrderCompleteRenderViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderCompleteRenderPaymentModule, (OrderCompleteRenderPaymentFragment) provider.get(), (OrderCompleteRenderViewModelFactory) provider2.get());
    }

    public static OrderCompleteRenderPaymentModule_ProvideOrderViewModelFactory create(OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule, Provider<OrderCompleteRenderPaymentFragment> provider, Provider<OrderCompleteRenderViewModelFactory> provider2) {
        return new OrderCompleteRenderPaymentModule_ProvideOrderViewModelFactory(orderCompleteRenderPaymentModule, provider, provider2);
    }

    public static OrderCompleteRenderViewModel proxyProvideOrderViewModel(OrderCompleteRenderPaymentModule orderCompleteRenderPaymentModule, OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment, OrderCompleteRenderViewModelFactory orderCompleteRenderViewModelFactory) {
        return (OrderCompleteRenderViewModel) Preconditions.checkNotNull(orderCompleteRenderPaymentModule.provideOrderViewModel(orderCompleteRenderPaymentFragment, orderCompleteRenderViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
