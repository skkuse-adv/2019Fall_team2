package kr.co.popone.fitts.viewmodel.order.complete;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.order.complete.OrderCompleteRenderActivity;

public final class OrderCompleteRenderModule_ProvideOrderViewModelFactory implements Factory<OrderCompleteRenderViewModel> {
    private final Provider<OrderCompleteRenderActivity> activityProvider;
    private final OrderCompleteRenderModule module;
    private final Provider<OrderCompleteRenderViewModelFactory> viewModelFactoryProvider;

    public OrderCompleteRenderModule_ProvideOrderViewModelFactory(OrderCompleteRenderModule orderCompleteRenderModule, Provider<OrderCompleteRenderActivity> provider, Provider<OrderCompleteRenderViewModelFactory> provider2) {
        this.module = orderCompleteRenderModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderCompleteRenderViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static OrderCompleteRenderViewModel provideInstance(OrderCompleteRenderModule orderCompleteRenderModule, Provider<OrderCompleteRenderActivity> provider, Provider<OrderCompleteRenderViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderCompleteRenderModule, (OrderCompleteRenderActivity) provider.get(), (OrderCompleteRenderViewModelFactory) provider2.get());
    }

    public static OrderCompleteRenderModule_ProvideOrderViewModelFactory create(OrderCompleteRenderModule orderCompleteRenderModule, Provider<OrderCompleteRenderActivity> provider, Provider<OrderCompleteRenderViewModelFactory> provider2) {
        return new OrderCompleteRenderModule_ProvideOrderViewModelFactory(orderCompleteRenderModule, provider, provider2);
    }

    public static OrderCompleteRenderViewModel proxyProvideOrderViewModel(OrderCompleteRenderModule orderCompleteRenderModule, OrderCompleteRenderActivity orderCompleteRenderActivity, OrderCompleteRenderViewModelFactory orderCompleteRenderViewModelFactory) {
        return (OrderCompleteRenderViewModel) Preconditions.checkNotNull(orderCompleteRenderModule.provideOrderViewModel(orderCompleteRenderActivity, orderCompleteRenderViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
