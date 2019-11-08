package kr.co.popone.fitts.feature.ncommerce;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.ncommerce.NCommerceViewModel;

public final class NCommerceActivity_MembersInjector implements MembersInjector<NCommerceActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
    private final Provider<NCommerceViewModel> viewModelProvider;

    public NCommerceActivity_MembersInjector(Provider<NCommerceViewModel> provider, Provider<DispatchingAndroidInjector<Fragment>> provider2) {
        this.viewModelProvider = provider;
        this.fragmentInjectorProvider = provider2;
    }

    public static MembersInjector<NCommerceActivity> create(Provider<NCommerceViewModel> provider, Provider<DispatchingAndroidInjector<Fragment>> provider2) {
        return new NCommerceActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(NCommerceActivity nCommerceActivity) {
        injectViewModel(nCommerceActivity, (NCommerceViewModel) this.viewModelProvider.get());
        injectFragmentInjector(nCommerceActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
    }

    public static void injectViewModel(NCommerceActivity nCommerceActivity, NCommerceViewModel nCommerceViewModel) {
        nCommerceActivity.viewModel = nCommerceViewModel;
    }

    public static void injectFragmentInjector(NCommerceActivity nCommerceActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        nCommerceActivity.fragmentInjector = dispatchingAndroidInjector;
    }
}
