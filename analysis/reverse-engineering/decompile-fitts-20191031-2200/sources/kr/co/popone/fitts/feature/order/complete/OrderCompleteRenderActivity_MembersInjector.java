package kr.co.popone.fitts.feature.order.complete;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.order.complete.OrderCompleteRenderViewModel;

public final class OrderCompleteRenderActivity_MembersInjector implements MembersInjector<OrderCompleteRenderActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
    private final Provider<OrderCompleteRenderViewModel> viewModelProvider;

    public OrderCompleteRenderActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<OrderCompleteRenderViewModel> provider2) {
        this.fragmentInjectorProvider = provider;
        this.viewModelProvider = provider2;
    }

    public static MembersInjector<OrderCompleteRenderActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<OrderCompleteRenderViewModel> provider2) {
        return new OrderCompleteRenderActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(OrderCompleteRenderActivity orderCompleteRenderActivity) {
        injectFragmentInjector(orderCompleteRenderActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
        injectViewModel(orderCompleteRenderActivity, (OrderCompleteRenderViewModel) this.viewModelProvider.get());
    }

    public static void injectFragmentInjector(OrderCompleteRenderActivity orderCompleteRenderActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        orderCompleteRenderActivity.fragmentInjector = dispatchingAndroidInjector;
    }

    public static void injectViewModel(OrderCompleteRenderActivity orderCompleteRenderActivity, OrderCompleteRenderViewModel orderCompleteRenderViewModel) {
        orderCompleteRenderActivity.viewModel = orderCompleteRenderViewModel;
    }
}
