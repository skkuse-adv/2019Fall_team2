package kr.co.popone.fitts.di.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;

public final class RepositoryModule_ProvideAllSearchHistoryRepositoryFactory implements Factory<SearchHistoryRepository> {
    private final Provider<Context> contextProvider;
    private final RepositoryModule module;

    public RepositoryModule_ProvideAllSearchHistoryRepositoryFactory(RepositoryModule repositoryModule, Provider<Context> provider) {
        this.module = repositoryModule;
        this.contextProvider = provider;
    }

    public SearchHistoryRepository get() {
        return provideInstance(this.module, this.contextProvider);
    }

    public static SearchHistoryRepository provideInstance(RepositoryModule repositoryModule, Provider<Context> provider) {
        return proxyProvideAllSearchHistoryRepository(repositoryModule, (Context) provider.get());
    }

    public static RepositoryModule_ProvideAllSearchHistoryRepositoryFactory create(RepositoryModule repositoryModule, Provider<Context> provider) {
        return new RepositoryModule_ProvideAllSearchHistoryRepositoryFactory(repositoryModule, provider);
    }

    public static SearchHistoryRepository proxyProvideAllSearchHistoryRepository(RepositoryModule repositoryModule, Context context) {
        return (SearchHistoryRepository) Preconditions.checkNotNull(repositoryModule.provideAllSearchHistoryRepository(context), "Cannot return null from a non-@Nullable @Provides method");
    }
}
