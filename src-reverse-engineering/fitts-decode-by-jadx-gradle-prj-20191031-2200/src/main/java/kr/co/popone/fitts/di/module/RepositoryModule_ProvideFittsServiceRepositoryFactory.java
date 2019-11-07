package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.api.FittsServiceApi;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;

public final class RepositoryModule_ProvideFittsServiceRepositoryFactory implements Factory<FittsServiceRepository> {
    private final Provider<FittsServiceApi> fittsServiceApiProvider;
    private final RepositoryModule module;

    public RepositoryModule_ProvideFittsServiceRepositoryFactory(RepositoryModule repositoryModule, Provider<FittsServiceApi> provider) {
        this.module = repositoryModule;
        this.fittsServiceApiProvider = provider;
    }

    public FittsServiceRepository get() {
        return provideInstance(this.module, this.fittsServiceApiProvider);
    }

    public static FittsServiceRepository provideInstance(RepositoryModule repositoryModule, Provider<FittsServiceApi> provider) {
        return proxyProvideFittsServiceRepository(repositoryModule, (FittsServiceApi) provider.get());
    }

    public static RepositoryModule_ProvideFittsServiceRepositoryFactory create(RepositoryModule repositoryModule, Provider<FittsServiceApi> provider) {
        return new RepositoryModule_ProvideFittsServiceRepositoryFactory(repositoryModule, provider);
    }

    public static FittsServiceRepository proxyProvideFittsServiceRepository(RepositoryModule repositoryModule, FittsServiceApi fittsServiceApi) {
        return (FittsServiceRepository) Preconditions.checkNotNull(repositoryModule.provideFittsServiceRepository(fittsServiceApi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
