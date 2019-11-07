package kr.co.popone.fitts.feature.push.order;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class OrderRendingActivity_MembersInjector implements MembersInjector<OrderRendingActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;

    public OrderRendingActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.fragmentInjectorProvider = provider;
    }

    public static MembersInjector<OrderRendingActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new OrderRendingActivity_MembersInjector(provider);
    }

    public void injectMembers(OrderRendingActivity orderRendingActivity) {
        injectFragmentInjector(orderRendingActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
    }

    public static void injectFragmentInjector(OrderRendingActivity orderRendingActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        orderRendingActivity.fragmentInjector = dispatchingAndroidInjector;
    }
}
