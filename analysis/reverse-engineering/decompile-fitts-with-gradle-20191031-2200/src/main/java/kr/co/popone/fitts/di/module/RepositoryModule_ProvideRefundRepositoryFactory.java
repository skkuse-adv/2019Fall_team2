package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.remote.refund.RefundApi;
import kr.co.popone.fitts.repository.RefundRepository;

public final class RepositoryModule_ProvideRefundRepositoryFactory implements Factory<RefundRepository> {
    private final RepositoryModule module;
    private final Provider<RefundApi> refundApiProvider;

    public RepositoryModule_ProvideRefundRepositoryFactory(RepositoryModule repositoryModule, Provider<RefundApi> provider) {
        this.module = repositoryModule;
        this.refundApiProvider = provider;
    }

    public RefundRepository get() {
        return provideInstance(this.module, this.refundApiProvider);
    }

    public static RefundRepository provideInstance(RepositoryModule repositoryModule, Provider<RefundApi> provider) {
        return proxyProvideRefundRepository(repositoryModule, (RefundApi) provider.get());
    }

    public static RepositoryModule_ProvideRefundRepositoryFactory create(RepositoryModule repositoryModule, Provider<RefundApi> provider) {
        return new RepositoryModule_ProvideRefundRepositoryFactory(repositoryModule, provider);
    }

    public static RefundRepository proxyProvideRefundRepository(RepositoryModule repositoryModule, RefundApi refundApi) {
        return (RefundRepository) Preconditions.checkNotNull(repositoryModule.provideRefundRepository(refundApi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
