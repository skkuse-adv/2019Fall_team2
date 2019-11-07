package kr.co.popone.fitts.viewmodel.order.list;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.order.orderlist.OrderListActivity;

public final class OrderListModule_ProvideOrderListViewModelFactory implements Factory<OrderListViewModel> {
    private final Provider<OrderListActivity> activityProvider;
    private final OrderListModule module;
    private final Provider<OrderListViewModelFactory> viewModelFactoryProvider;

    public OrderListModule_ProvideOrderListViewModelFactory(OrderListModule orderListModule, Provider<OrderListActivity> provider, Provider<OrderListViewModelFactory> provider2) {
        this.module = orderListModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public OrderListViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static OrderListViewModel provideInstance(OrderListModule orderListModule, Provider<OrderListActivity> provider, Provider<OrderListViewModelFactory> provider2) {
        return proxyProvideOrderListViewModel(orderListModule, (OrderListActivity) provider.get(), (OrderListViewModelFactory) provider2.get());
    }

    public static OrderListModule_ProvideOrderListViewModelFactory create(OrderListModule orderListModule, Provider<OrderListActivity> provider, Provider<OrderListViewModelFactory> provider2) {
        return new OrderListModule_ProvideOrderListViewModelFactory(orderListModule, provider, provider2);
    }

    public static OrderListViewModel proxyProvideOrderListViewModel(OrderListModule orderListModule, OrderListActivity orderListActivity, OrderListViewModelFactory orderListViewModelFactory) {
        return (OrderListViewModel) Preconditions.checkNotNull(orderListModule.provideOrderListViewModel(orderListActivity, orderListViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
