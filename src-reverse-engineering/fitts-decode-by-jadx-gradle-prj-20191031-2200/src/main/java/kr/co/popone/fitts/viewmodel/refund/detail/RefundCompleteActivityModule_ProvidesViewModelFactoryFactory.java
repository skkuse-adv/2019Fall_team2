package kr.co.popone.fitts.viewmodel.refund.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.repository.RefundRepository;

public final class RefundCompleteActivityModule_ProvidesViewModelFactoryFactory implements Factory<RefundDetailViewModelFactory> {
    private final RefundCompleteActivityModule module;
    private final Provider<RefundRepository> refundRepositoryProvider;

    public RefundCompleteActivityModule_ProvidesViewModelFactoryFactory(RefundCompleteActivityModule refundCompleteActivityModule, Provider<RefundRepository> provider) {
        this.module = refundCompleteActivityModule;
        this.refundRepositoryProvider = provider;
    }

    public RefundDetailViewModelFactory get() {
        return provideInstance(this.module, this.refundRepositoryProvider);
    }

    public static RefundDetailViewModelFactory provideInstance(RefundCompleteActivityModule refundCompleteActivityModule, Provider<RefundRepository> provider) {
        return proxyProvidesViewModelFactory(refundCompleteActivityModule, (RefundRepository) provider.get());
    }

    public static RefundCompleteActivityModule_ProvidesViewModelFactoryFactory create(RefundCompleteActivityModule refundCompleteActivityModule, Provider<RefundRepository> provider) {
        return new RefundCompleteActivityModule_ProvidesViewModelFactoryFactory(refundCompleteActivityModule, provider);
    }

    public static RefundDetailViewModelFactory proxyProvidesViewModelFactory(RefundCompleteActivityModule refundCompleteActivityModule, RefundRepository refundRepository) {
        return (RefundDetailViewModelFactory) Preconditions.checkNotNull(refundCompleteActivityModule.providesViewModelFactory(refundRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
