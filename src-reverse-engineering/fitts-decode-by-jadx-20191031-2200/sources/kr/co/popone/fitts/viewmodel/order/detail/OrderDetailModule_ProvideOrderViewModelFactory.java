package kr.co.popone.fitts.viewmodel.order.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

public final class OrderDetailModule_ProvideOrderViewModelFactory implements Factory<OrderDetailViewModel> {
    private final Provider<OrderDetailActivity> activityProvider;
    private final OrderDetailModule module;
    private final Provider<OrderDetailViewModelFactory> viewModelFactoryProvider;

    public OrderDetailModule_ProvideOrderViewModelFactory(OrderDetailModule orderDetailModule, Provider<OrderDetailActivity> provider, Provider<OrderDetailViewModelFactory> provider2) {
        this.module = orderDetailModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderDetailViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static OrderDetailViewModel provideInstance(OrderDetailModule orderDetailModule, Provider<OrderDetailActivity> provider, Provider<OrderDetailViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(orderDetailModule, (OrderDetailActivity) provider.get(), (OrderDetailViewModelFactory) provider2.get());
    }

    public static OrderDetailModule_ProvideOrderViewModelFactory create(OrderDetailModule orderDetailModule, Provider<OrderDetailActivity> provider, Provider<OrderDetailViewModelFactory> provider2) {
        return new OrderDetailModule_ProvideOrderViewModelFactory(orderDetailModule, provider, provider2);
    }

    public static OrderDetailViewModel proxyProvideOrderViewModel(OrderDetailModule orderDetailModule, OrderDetailActivity orderDetailActivity, OrderDetailViewModelFactory orderDetailViewModelFactory) {
        return (OrderDetailViewModel) Preconditions.checkNotNull(orderDetailModule.provideOrderViewModel(orderDetailActivity, orderDetailViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
