package kr.co.popone.fitts.viewmodel.refund.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.refund.RefundCompleteActivity;

public final class RefundApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory implements Factory<RefundDetailViewModel> {
    private final Provider<RefundCompleteActivity> activityProvider;
    private final RefundApplyCompleteFragmentModule module;
    private final Provider<RefundDetailViewModelFactory> viewModelFactoryProvider;

    public RefundApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory(RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule, Provider<RefundCompleteActivity> provider, Provider<RefundDetailViewModelFactory> provider2) {
        this.module = refundApplyCompleteFragmentModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public RefundDetailViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static RefundDetailViewModel provideInstance(RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule, Provider<RefundCompleteActivity> provider, Provider<RefundDetailViewModelFactory> provider2) {
        return proxyProvideExchangeDetailViewModel(refundApplyCompleteFragmentModule, (RefundCompleteActivity) provider.get(), (RefundDetailViewModelFactory) provider2.get());
    }

    public static RefundApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory create(RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule, Provider<RefundCompleteActivity> provider, Provider<RefundDetailViewModelFactory> provider2) {
        return new RefundApplyCompleteFragmentModule_ProvideExchangeDetailViewModelFactory(refundApplyCompleteFragmentModule, provider, provider2);
    }

    public static RefundDetailViewModel proxyProvideExchangeDetailViewModel(RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule, RefundCompleteActivity refundCompleteActivity, RefundDetailViewModelFactory refundDetailViewModelFactory) {
        return (RefundDetailViewModel) Preconditions.checkNotNull(refundApplyCompleteFragmentModule.provideExchangeDetailViewModel(refundCompleteActivity, refundDetailViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
