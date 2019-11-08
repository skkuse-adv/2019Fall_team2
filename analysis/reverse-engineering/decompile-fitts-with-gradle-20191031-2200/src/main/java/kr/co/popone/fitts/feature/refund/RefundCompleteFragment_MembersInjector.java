package kr.co.popone.fitts.feature.refund;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundDetailViewModel;

public final class RefundCompleteFragment_MembersInjector implements MembersInjector<RefundCompleteFragment> {
    private final Provider<RefundDetailViewModel> viewModelProvider;

    public RefundCompleteFragment_MembersInjector(Provider<RefundDetailViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<RefundCompleteFragment> create(Provider<RefundDetailViewModel> provider) {
        return new RefundCompleteFragment_MembersInjector(provider);
    }

    public void injectMembers(RefundCompleteFragment refundCompleteFragment) {
        injectViewModel(refundCompleteFragment, (RefundDetailViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(RefundCompleteFragment refundCompleteFragment, RefundDetailViewModel refundDetailViewModel) {
        refundCompleteFragment.viewModel = refundDetailViewModel;
    }
}
