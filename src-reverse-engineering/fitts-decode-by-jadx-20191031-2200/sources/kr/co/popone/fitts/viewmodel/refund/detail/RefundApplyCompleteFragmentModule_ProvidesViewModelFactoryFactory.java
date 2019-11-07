package kr.co.popone.fitts.viewmodel.refund.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.repository.RefundRepository;

public final class RefundApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory implements Factory<RefundDetailViewModelFactory> {
    private final RefundApplyCompleteFragmentModule module;
    private final Provider<RefundRepository> refundRepositoryProvider;

    public RefundApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory(RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule, Provider<RefundRepository> provider) {
        this.module = refundApplyCompleteFragmentModule;
        this.refundRepositoryProvider = provider;
    }

    public RefundDetailViewModelFactory get() {
        return provideInstance(this.module, this.refundRepositoryProvider);
    }

    public static RefundDetailViewModelFactory provideInstance(RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule, Provider<RefundRepository> provider) {
        return proxyProvidesViewModelFactory(refundApplyCompleteFragmentModule, (RefundRepository) provider.get());
    }

    public static RefundApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory create(RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule, Provider<RefundRepository> provider) {
        return new RefundApplyCompleteFragmentModule_ProvidesViewModelFactoryFactory(refundApplyCompleteFragmentModule, provider);
    }

    public static RefundDetailViewModelFactory proxyProvidesViewModelFactory(RefundApplyCompleteFragmentModule refundApplyCompleteFragmentModule, RefundRepository refundRepository) {
        return (RefundDetailViewModelFactory) Preconditions.checkNotNull(refundApplyCompleteFragmentModule.providesViewModelFactory(refundRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
