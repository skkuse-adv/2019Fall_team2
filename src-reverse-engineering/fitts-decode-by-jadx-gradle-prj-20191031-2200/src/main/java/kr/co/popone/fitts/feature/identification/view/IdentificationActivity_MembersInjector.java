package kr.co.popone.fitts.feature.identification.view;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class IdentificationActivity_MembersInjector implements MembersInjector<IdentificationActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;

    public IdentificationActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.fragmentInjectorProvider = provider;
    }

    public static MembersInjector<IdentificationActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new IdentificationActivity_MembersInjector(provider);
    }

    public void injectMembers(IdentificationActivity identificationActivity) {
        injectFragmentInjector(identificationActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
    }

    public static void injectFragmentInjector(IdentificationActivity identificationActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        identificationActivity.fragmentInjector = dispatchingAndroidInjector;
    }
}
