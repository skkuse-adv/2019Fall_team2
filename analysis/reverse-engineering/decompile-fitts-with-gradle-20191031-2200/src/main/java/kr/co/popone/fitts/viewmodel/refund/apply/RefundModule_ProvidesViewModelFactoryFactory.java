package kr.co.popone.fitts.viewmodel.refund.apply;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.repository.RefundRepository;

public final class RefundModule_ProvidesViewModelFactoryFactory implements Factory<RefundViewModelFactory> {
    private final RefundModule module;
    private final Provider<RefundRepository> refundRepositoryProvider;

    public RefundModule_ProvidesViewModelFactoryFactory(RefundModule refundModule, Provider<RefundRepository> provider) {
        this.module = refundModule;
        this.refundRepositoryProvider = provider;
    }

    public RefundViewModelFactory get() {
        return provideInstance(this.module, this.refundRepositoryProvider);
    }

    public static RefundViewModelFactory provideInstance(RefundModule refundModule, Provider<RefundRepository> provider) {
        return proxyProvidesViewModelFactory(refundModule, (RefundRepository) provider.get());
    }

    public static RefundModule_ProvidesViewModelFactoryFactory create(RefundModule refundModule, Provider<RefundRepository> provider) {
        return new RefundModule_ProvidesViewModelFactoryFactory(refundModule, provider);
    }

    public static RefundViewModelFactory proxyProvidesViewModelFactory(RefundModule refundModule, RefundRepository refundRepository) {
        return (RefundViewModelFactory) Preconditions.checkNotNull(refundModule.providesViewModelFactory(refundRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
