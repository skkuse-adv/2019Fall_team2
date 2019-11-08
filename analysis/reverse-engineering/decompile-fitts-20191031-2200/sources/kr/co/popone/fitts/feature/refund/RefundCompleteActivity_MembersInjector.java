package kr.co.popone.fitts.feature.refund;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundDetailViewModel;

public final class RefundCompleteActivity_MembersInjector implements MembersInjector<RefundCompleteActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
    private final Provider<RefundDetailViewModel> viewModelProvider;

    public RefundCompleteActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RefundDetailViewModel> provider2) {
        this.fragmentInjectorProvider = provider;
        this.viewModelProvider = provider2;
    }

    public static MembersInjector<RefundCompleteActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RefundDetailViewModel> provider2) {
        return new RefundCompleteActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(RefundCompleteActivity refundCompleteActivity) {
        injectFragmentInjector(refundCompleteActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
        injectViewModel(refundCompleteActivity, (RefundDetailViewModel) this.viewModelProvider.get());
    }

    public static void injectFragmentInjector(RefundCompleteActivity refundCompleteActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        refundCompleteActivity.fragmentInjector = dispatchingAndroidInjector;
    }

    public static void injectViewModel(RefundCompleteActivity refundCompleteActivity, RefundDetailViewModel refundDetailViewModel) {
        refundCompleteActivity.viewModel = refundDetailViewModel;
    }
}
