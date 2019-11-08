package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.api.FittsCommerceApi;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;

public final class RepositoryModule_ProvideFittsCommerceRepositoryFactory implements Factory<FittsCommerceRepository> {
    private final Provider<FittsCommerceApi> fittsCommerceApiProvider;
    private final RepositoryModule module;

    public RepositoryModule_ProvideFittsCommerceRepositoryFactory(RepositoryModule repositoryModule, Provider<FittsCommerceApi> provider) {
        this.module = repositoryModule;
        this.fittsCommerceApiProvider = provider;
    }

    public FittsCommerceRepository get() {
        return provideInstance(this.module, this.fittsCommerceApiProvider);
    }

    public static FittsCommerceRepository provideInstance(RepositoryModule repositoryModule, Provider<FittsCommerceApi> provider) {
        return proxyProvideFittsCommerceRepository(repositoryModule, (FittsCommerceApi) provider.get());
    }

    public static RepositoryModule_ProvideFittsCommerceRepositoryFactory create(RepositoryModule repositoryModule, Provider<FittsCommerceApi> provider) {
        return new RepositoryModule_ProvideFittsCommerceRepositoryFactory(repositoryModule, provider);
    }

    public static FittsCommerceRepository proxyProvideFittsCommerceRepository(RepositoryModule repositoryModule, FittsCommerceApi fittsCommerceApi) {
        return (FittsCommerceRepository) Preconditions.checkNotNull(repositoryModule.provideFittsCommerceRepository(fittsCommerceApi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
