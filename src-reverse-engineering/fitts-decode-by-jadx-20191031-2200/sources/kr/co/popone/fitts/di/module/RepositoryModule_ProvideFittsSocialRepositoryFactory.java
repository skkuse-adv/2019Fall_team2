package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.api.FittsSocialApi;
import kr.co.popone.fitts.model.repository.social.FittsSocialRepository;

public final class RepositoryModule_ProvideFittsSocialRepositoryFactory implements Factory<FittsSocialRepository> {
    private final Provider<FittsSocialApi> fittsSocialApiProvider;
    private final RepositoryModule module;

    public RepositoryModule_ProvideFittsSocialRepositoryFactory(RepositoryModule repositoryModule, Provider<FittsSocialApi> provider) {
        this.module = repositoryModule;
        this.fittsSocialApiProvider = provider;
    }

    public FittsSocialRepository get() {
        return provideInstance(this.module, this.fittsSocialApiProvider);
    }

    public static FittsSocialRepository provideInstance(RepositoryModule repositoryModule, Provider<FittsSocialApi> provider) {
        return proxyProvideFittsSocialRepository(repositoryModule, (FittsSocialApi) provider.get());
    }

    public static RepositoryModule_ProvideFittsSocialRepositoryFactory create(RepositoryModule repositoryModule, Provider<FittsSocialApi> provider) {
        return new RepositoryModule_ProvideFittsSocialRepositoryFactory(repositoryModule, provider);
    }

    public static FittsSocialRepository proxyProvideFittsSocialRepository(RepositoryModule repositoryModule, FittsSocialApi fittsSocialApi) {
        return (FittsSocialRepository) Preconditions.checkNotNull(repositoryModule.provideFittsSocialRepository(fittsSocialApi), "Cannot return null from a non-@Nullable @Provides method");
    }
}
