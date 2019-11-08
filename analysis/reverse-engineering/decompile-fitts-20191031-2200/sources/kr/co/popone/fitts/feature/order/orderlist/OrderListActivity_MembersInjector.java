package kr.co.popone.fitts.feature.order.orderlist;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.order.list.OrderListViewModel;

public final class OrderListActivity_MembersInjector implements MembersInjector<OrderListActivity> {
    private final Provider<OrderListViewModel> viewModelProvider;

    public OrderListActivity_MembersInjector(Provider<OrderListViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderListActivity> create(Provider<OrderListViewModel> provider) {
        return new OrderListActivity_MembersInjector(provider);
    }

    public void injectMembers(OrderListActivity orderListActivity) {
        injectViewModel(orderListActivity, (OrderListViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderListActivity orderListActivity, OrderListViewModel orderListViewModel) {
        orderListActivity.viewModel = orderListViewModel;
    }
}
