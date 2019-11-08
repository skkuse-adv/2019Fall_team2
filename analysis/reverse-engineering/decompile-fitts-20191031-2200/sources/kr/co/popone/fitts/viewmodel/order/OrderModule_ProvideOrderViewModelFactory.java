package kr.co.popone.fitts.viewmodel.order;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.order.OrderActivity;

public final class OrderModule_ProvideOrderViewModelFactory implements Factory<OrderViewModel> {
    private final Provider<OrderActivity> activityProvider;
    private final OrderModule module;
    private final Provider<OrderViewModelFactory> viewModelFactoryProvider;

    public OrderModule_ProvideOrderViewModelFactory(OrderModule orderModule, Provider<OrderActivity> provider, Provider<OrderViewModelFactory> provider2) {
        this.module = orderModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static OrderViewModel provideInstance(OrderModule orderModule, Provider<OrderActivity> provider, Provider<OrderViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderModule, (OrderActivity) provider.get(), (OrderViewModelFactory) provider2.get());
    }

    public static OrderModule_ProvideOrderViewModelFactory create(OrderModule orderModule, Provider<OrderActivity> provider, Provider<OrderViewModelFactory> provider2) {
        return new OrderModule_ProvideOrderViewModelFactory(orderModule, provider, provider2);
    }

    public static OrderViewModel proxyProvideOrderViewModel(OrderModule orderModule, OrderActivity orderActivity, OrderViewModelFactory orderViewModelFactory) {
        return (OrderViewModel) Preconditions.checkNotNull(orderModule.provideOrderViewModel(orderActivity, orderViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
