package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.repository.SearchRepository;

public final class RepositoryModule_ProvideSearchRepositoryFactory implements Factory<SearchRepository> {
    private final RepositoryModule module;
    private final Provider<SearchAPI> searchAPIProvider;

    public RepositoryModule_ProvideSearchRepositoryFactory(RepositoryModule repositoryModule, Provider<SearchAPI> provider) {
        this.module = repositoryModule;
        this.searchAPIProvider = provider;
    }

    public SearchRepository get() {
        return provideInstance(this.module, this.searchAPIProvider);
    }

    public static SearchRepository provideInstance(RepositoryModule repositoryModule, Provider<SearchAPI> provider) {
        return proxyProvideSearchRepository(repositoryModule, (SearchAPI) provider.get());
    }

    public static RepositoryModule_ProvideSearchRepositoryFactory create(RepositoryModule repositoryModule, Provider<SearchAPI> provider) {
        return new RepositoryModule_ProvideSearchRepositoryFactory(repositoryModule, provider);
    }

    public static SearchRepository proxyProvideSearchRepository(RepositoryModule repositoryModule, SearchAPI searchAPI) {
        return (SearchRepository) Preconditions.checkNotNull(repositoryModule.provideSearchRepository(searchAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
