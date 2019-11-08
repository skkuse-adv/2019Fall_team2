package kr.co.popone.fitts.feature.order.detail;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.order.detail.OrderDetailViewModel;

public final class OrderDetailActivity_MembersInjector implements MembersInjector<OrderDetailActivity> {
    private final Provider<OrderDetailViewModel> viewModelProvider;

    public OrderDetailActivity_MembersInjector(Provider<OrderDetailViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<OrderDetailActivity> create(Provider<OrderDetailViewModel> provider) {
        return new OrderDetailActivity_MembersInjector(provider);
    }

    public void injectMembers(OrderDetailActivity orderDetailActivity) {
        injectViewModel(orderDetailActivity, (OrderDetailViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(OrderDetailActivity orderDetailActivity, OrderDetailViewModel orderDetailViewModel) {
        orderDetailActivity.viewModel = orderDetailViewModel;
    }
}
