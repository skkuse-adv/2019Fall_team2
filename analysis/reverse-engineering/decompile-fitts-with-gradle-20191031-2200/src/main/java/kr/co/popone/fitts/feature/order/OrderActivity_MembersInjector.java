package kr.co.popone.fitts.feature.order;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.order.OrderViewModel;

public final class OrderActivity_MembersInjector implements MembersInjector<OrderActivity> {
    private final Provider<OrderViewModel> viewModelProvider;

    public OrderActivity_MembersInjector(Provider<OrderViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderActivity> create(Provider<OrderViewModel> provider) {
        return new OrderActivity_MembersInjector(provider);
    }

    public void injectMembers(OrderActivity orderActivity) {
        injectViewModel(orderActivity, (OrderViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderActivity orderActivity, OrderViewModel orderViewModel) {
        orderActivity.viewModel = orderViewModel;
    }
}
