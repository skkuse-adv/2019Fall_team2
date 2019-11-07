package kr.co.popone.fitts.feature.refund;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel;

public final class RefundApplyActivity_MembersInjector implements MembersInjector<RefundApplyActivity> {
    private final Provider<RefundViewModel> viewModelProvider;

    public RefundApplyActivity_MembersInjector(Provider<RefundViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<RefundApplyActivity> create(Provider<RefundViewModel> provider) {
        return new RefundApplyActivity_MembersInjector(provider);
    }

    public void injectMembers(RefundApplyActivity refundApplyActivity) {
        injectViewModel(refundApplyActivity, (RefundViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(RefundApplyActivity refundApplyActivity, RefundViewModel refundViewModel) {
        refundApplyActivity.viewModel = refundViewModel;
    }
}
