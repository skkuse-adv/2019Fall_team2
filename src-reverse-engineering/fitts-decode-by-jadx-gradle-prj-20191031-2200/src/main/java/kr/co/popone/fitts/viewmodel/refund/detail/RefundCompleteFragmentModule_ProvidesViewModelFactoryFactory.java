package kr.co.popone.fitts.viewmodel.refund.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.repository.RefundRepository;

public final class RefundCompleteFragmentModule_ProvidesViewModelFactoryFactory implements Factory<RefundDetailViewModelFactory> {
    private final RefundCompleteFragmentModule module;
    private final Provider<RefundRepository> refundRepositoryProvider;

    public RefundCompleteFragmentModule_ProvidesViewModelFactoryFactory(RefundCompleteFragmentModule refundCompleteFragmentModule, Provider<RefundRepository> provider) {
        this.module = refundCompleteFragmentModule;
        this.refundRepositoryProvider = provider;
    }

    public RefundDetailViewModelFactory get() {
        return provideInstance(this.module, this.refundRepositoryProvider);
    }

    public static RefundDetailViewModelFactory provideInstance(RefundCompleteFragmentModule refundCompleteFragmentModule, Provider<RefundRepository> provider) {
        return proxyProvidesViewModelFactory(refundCompleteFragmentModule, (RefundRepository) provider.get());
    }

    public static RefundCompleteFragmentModule_ProvidesViewModelFactoryFactory create(RefundCompleteFragmentModule refundCompleteFragmentModule, Provider<RefundRepository> provider) {
        return new RefundCompleteFragmentModule_ProvidesViewModelFactoryFactory(refundCompleteFragmentModule, provider);
    }

    public static RefundDetailViewModelFactory proxyProvidesViewModelFactory(RefundCompleteFragmentModule refundCompleteFragmentModule, RefundRepository refundRepository) {
        return (RefundDetailViewModelFactory) Preconditions.checkNotNull(refundCompleteFragmentModule.providesViewModelFactory(refundRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
