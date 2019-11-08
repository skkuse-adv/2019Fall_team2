package kr.co.popone.fitts.viewmodel.refund.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.refund.RefundApplyCompleteFragment;

public final class RefundCompleteActivityModule_ProvideExchangeDetailViewModelFactory implements Factory<RefundDetailViewModel> {
    private final Provider<RefundApplyCompleteFragment> fragmentProvider;
    private final RefundCompleteActivityModule module;
    private final Provider<RefundDetailViewModelFactory> viewModelFactoryProvider;

    public RefundCompleteActivityModule_ProvideExchangeDetailViewModelFactory(RefundCompleteActivityModule refundCompleteActivityModule, Provider<RefundApplyCompleteFragment> provider, Provider<RefundDetailViewModelFactory> provider2) {
        this.module = refundCompleteActivityModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public RefundDetailViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static RefundDetailViewModel provideInstance(RefundCompleteActivityModule refundCompleteActivityModule, Provider<RefundApplyCompleteFragment> provider, Provider<RefundDetailViewModelFactory> provider2) {
        return proxyProvideExchangeDetailViewModel(refundCompleteActivityModule, (RefundApplyCompleteFragment) provider.get(), (RefundDetailViewModelFactory) provider2.get());
    }

    public static RefundCompleteActivityModule_ProvideExchangeDetailViewModelFactory create(RefundCompleteActivityModule refundCompleteActivityModule, Provider<RefundApplyCompleteFragment> provider, Provider<RefundDetailViewModelFactory> provider2) {
        return new RefundCompleteActivityModule_ProvideExchangeDetailViewModelFactory(refundCompleteActivityModule, provider, provider2);
    }

    public static RefundDetailViewModel proxyProvideExchangeDetailViewModel(RefundCompleteActivityModule refundCompleteActivityModule, RefundApplyCompleteFragment refundApplyCompleteFragment, RefundDetailViewModelFactory refundDetailViewModelFactory) {
        return (RefundDetailViewModel) Preconditions.checkNotNull(refundCompleteActivityModule.provideExchangeDetailViewModel(refundApplyCompleteFragment, refundDetailViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
