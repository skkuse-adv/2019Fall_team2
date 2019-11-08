package kr.co.popone.fitts.viewmodel.refund.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.refund.RefundCompleteFragment;

public final class RefundCompleteFragmentModule_ProvideExchangeDetailViewModelFactory implements Factory<RefundDetailViewModel> {
    private final Provider<RefundCompleteFragment> fragmentProvider;
    private final RefundCompleteFragmentModule module;
    private final Provider<RefundDetailViewModelFactory> viewModelFactoryProvider;

    public RefundCompleteFragmentModule_ProvideExchangeDetailViewModelFactory(RefundCompleteFragmentModule refundCompleteFragmentModule, Provider<RefundCompleteFragment> provider, Provider<RefundDetailViewModelFactory> provider2) {
        this.module = refundCompleteFragmentModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public RefundDetailViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static RefundDetailViewModel provideInstance(RefundCompleteFragmentModule refundCompleteFragmentModule, Provider<RefundCompleteFragment> provider, Provider<RefundDetailViewModelFactory> provider2) {
        return proxyProvideExchangeDetailViewModel(refundCompleteFragmentModule, (RefundCompleteFragment) provider.get(), (RefundDetailViewModelFactory) provider2.get());
    }

    public static RefundCompleteFragmentModule_ProvideExchangeDetailViewModelFactory create(RefundCompleteFragmentModule refundCompleteFragmentModule, Provider<RefundCompleteFragment> provider, Provider<RefundDetailViewModelFactory> provider2) {
        return new RefundCompleteFragmentModule_ProvideExchangeDetailViewModelFactory(refundCompleteFragmentModule, provider, provider2);
    }

    public static RefundDetailViewModel proxyProvideExchangeDetailViewModel(RefundCompleteFragmentModule refundCompleteFragmentModule, RefundCompleteFragment refundCompleteFragment, RefundDetailViewModelFactory refundDetailViewModelFactory) {
        return (RefundDetailViewModel) Preconditions.checkNotNull(refundCompleteFragmentModule.provideExchangeDetailViewModel(refundCompleteFragment, refundDetailViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
