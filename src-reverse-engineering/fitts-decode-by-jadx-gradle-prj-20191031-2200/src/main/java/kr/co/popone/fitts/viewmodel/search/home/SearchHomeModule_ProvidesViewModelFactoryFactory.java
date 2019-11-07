package kr.co.popone.fitts.viewmodel.search.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import kr.co.popone.fitts.repository.SearchRepository;

public final class SearchHomeModule_ProvidesViewModelFactoryFactory implements Factory<SearchViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final SearchHomeModule module;
    private final Provider<SearchHistoryRepository> searchHistoryRepositoryProvider;
    private final Provider<SearchRepository> searchRepositoryProvider;

    public SearchHomeModule_ProvidesViewModelFactoryFactory(SearchHomeModule searchHomeModule, Provider<EventTracker> provider, Provider<SearchRepository> provider2, Provider<SearchHistoryRepository> provider3) {
        this.module = searchHomeModule;
        this.eventTrackerProvider = provider;
        this.searchRepositoryProvider = provider2;
        this.searchHistoryRepositoryProvider = provider3;
    }

    public SearchViewModelFactory get() {
        return provideInstance(this.module, this.eventTrackerProvider, this.searchRepositoryProvider, this.searchHistoryRepositoryProvider);
    }

    public static SearchViewModelFactory provideInstance(SearchHomeModule searchHomeModule, Provider<EventTracker> provider, Provider<SearchRepository> provider2, Provider<SearchHistoryRepository> provider3) {
        return proxyProvidesViewModelFactory(searchHomeModule, (EventTracker) provider.get(), (SearchRepository) provider2.get(), (SearchHistoryRepository) provider3.get());
    }

    public static SearchHomeModule_ProvidesViewModelFactoryFactory create(SearchHomeModule searchHomeModule, Provider<EventTracker> provider, Provider<SearchRepository> provider2, Provider<SearchHistoryRepository> provider3) {
        return new SearchHomeModule_ProvidesViewModelFactoryFactory(searchHomeModule, provider, provider2, provider3);
    }

    public static SearchViewModelFactory proxyProvidesViewModelFactory(SearchHomeModule searchHomeModule, EventTracker eventTracker, SearchRepository searchRepository, SearchHistoryRepository searchHistoryRepository) {
        return (SearchViewModelFactory) Preconditions.checkNotNull(searchHomeModule.providesViewModelFactory(eventTracker, searchRepository, searchHistoryRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
