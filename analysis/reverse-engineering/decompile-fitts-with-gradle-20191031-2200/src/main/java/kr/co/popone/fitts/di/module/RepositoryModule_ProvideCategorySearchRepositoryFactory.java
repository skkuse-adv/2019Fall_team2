package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.category.CategoryAPI;
import kr.co.popone.fitts.repository.CategoryRepository;

public final class RepositoryModule_ProvideCategorySearchRepositoryFactory implements Factory<CategoryRepository> {
    private final Provider<CategoryAPI> categoryAPIProvider;
    private final RepositoryModule module;

    public RepositoryModule_ProvideCategorySearchRepositoryFactory(RepositoryModule repositoryModule, Provider<CategoryAPI> provider) {
        this.module = repositoryModule;
        this.categoryAPIProvider = provider;
    }

    public CategoryRepository get() {
        return provideInstance(this.module, this.categoryAPIProvider);
    }

    public static CategoryRepository provideInstance(RepositoryModule repositoryModule, Provider<CategoryAPI> provider) {
        return proxyProvideCategorySearchRepository(repositoryModule, (CategoryAPI) provider.get());
    }

    public static RepositoryModule_ProvideCategorySearchRepositoryFactory create(RepositoryModule repositoryModule, Provider<CategoryAPI> provider) {
        return new RepositoryModule_ProvideCategorySearchRepositoryFactory(repositoryModule, provider);
    }

    public static CategoryRepository proxyProvideCategorySearchRepository(RepositoryModule repositoryModule, CategoryAPI categoryAPI) {
        return (CategoryRepository) Preconditions.checkNotNull(repositoryModule.provideCategorySearchRepository(categoryAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
