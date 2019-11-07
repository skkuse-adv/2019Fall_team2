package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.store.StoreAPI;
import kr.co.popone.fitts.repository.StoreRepository;

public final class RepositoryModule_ProvideStoreRepositoryFactory implements Factory<StoreRepository> {
    private final RepositoryModule module;
    private final Provider<StoreAPI> storeAPIProvider;

    public RepositoryModule_ProvideStoreRepositoryFactory(RepositoryModule repositoryModule, Provider<StoreAPI> provider) {
        this.module = repositoryModule;
        this.storeAPIProvider = provider;
    }

    public StoreRepository get() {
        return provideInstance(this.module, this.storeAPIProvider);
    }

    public static StoreRepository provideInstance(RepositoryModule repositoryModule, Provider<StoreAPI> provider) {
        return proxyProvideStoreRepository(repositoryModule, (StoreAPI) provider.get());
    }

    public static RepositoryModule_ProvideStoreRepositoryFactory create(RepositoryModule repositoryModule, Provider<StoreAPI> provider) {
        return new RepositoryModule_ProvideStoreRepositoryFactory(repositoryModule, provider);
    }

    public static StoreRepository proxyProvideStoreRepository(RepositoryModule repositoryModule, StoreAPI storeAPI) {
        return (StoreRepository) Preconditions.checkNotNull(repositoryModule.provideStoreRepository(storeAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
