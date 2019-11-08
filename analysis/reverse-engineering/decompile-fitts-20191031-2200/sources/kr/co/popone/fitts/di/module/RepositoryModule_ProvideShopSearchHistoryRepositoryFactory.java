package kr.co.popone.fitts.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;

public final class RepositoryModule_ProvideShopSearchHistoryRepositoryFactory implements Factory<SearchHistoryRepository> {
    private final Provider<Context> contextProvider;
    private final RepositoryModule module;

    public RepositoryModule_ProvideShopSearchHistoryRepositoryFactory(RepositoryModule repositoryModule, Provider<Context> provider) {
        this.module = repositoryModule;
        this.contextProvider = provider;
    }

    public SearchHistoryRepository get() {
        return provideInstance(this.module, this.contextProvider);
    }

    public static SearchHistoryRepository provideInstance(RepositoryModule repositoryModule, Provider<Context> provider) {
        return proxyProvideShopSearchHistoryRepository(repositoryModule, (Context) provider.get());
    }

    public static RepositoryModule_ProvideShopSearchHistoryRepositoryFactory create(RepositoryModule repositoryModule, Provider<Context> provider) {
        return new RepositoryModule_ProvideShopSearchHistoryRepositoryFactory(repositoryModule, provider);
    }

    public static SearchHistoryRepository proxyProvideShopSearchHistoryRepository(RepositoryModule repositoryModule, Context context) {
        return (SearchHistoryRepository) Preconditions.checkNotNull(repositoryModule.provideShopSearchHistoryRepository(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
