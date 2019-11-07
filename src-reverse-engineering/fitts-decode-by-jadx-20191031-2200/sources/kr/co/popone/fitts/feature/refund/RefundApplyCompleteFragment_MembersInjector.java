package kr.co.popone.fitts.feature.refund;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.refund.detail.RefundDetailViewModel;

public final class RefundApplyCompleteFragment_MembersInjector implements MembersInjector<RefundApplyCompleteFragment> {
    private final Provider<RefundDetailViewModel> viewModelProvider;

    public RefundApplyCompleteFragment_MembersInjector(Provider<RefundDetailViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<RefundApplyCompleteFragment> create(Provider<RefundDetailViewModel> provider) {
        return new RefundApplyCompleteFragment_MembersInjector(provider);
    }

    public void injectMembers(RefundApplyCompleteFragment refundApplyCompleteFragment) {
        injectViewModel(refundApplyCompleteFragment, (RefundDetailViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(RefundApplyCompleteFragment refundApplyCompleteFragment, RefundDetailViewModel refundDetailViewModel) {
        refundApplyCompleteFragment.viewModel = refundDetailViewModel;
    }
}
