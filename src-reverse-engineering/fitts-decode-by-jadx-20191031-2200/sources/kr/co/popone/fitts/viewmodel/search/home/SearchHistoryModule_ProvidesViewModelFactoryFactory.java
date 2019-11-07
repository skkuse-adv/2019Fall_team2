package kr.co.popone.fitts.viewmodel.search.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import kr.co.popone.fitts.repository.SearchRepository;

public final class SearchHistoryModule_ProvidesViewModelFactoryFactory implements Factory<SearchViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final SearchHistoryModule module;
    private final Provider<SearchHistoryRepository> searchHistoryRepositoryProvider;
    private final Provider<SearchRepository> searchRepositoryProvider;

    public SearchHistoryModule_ProvidesViewModelFactoryFactory(SearchHistoryModule searchHistoryModule, Provider<EventTracker> provider, Provider<SearchRepository> provider2, Provider<SearchHistoryRepository> provider3) {
        this.module = searchHistoryModule;
        this.eventTrackerProvider = provider;
        this.searchRepositoryProvider = provider2;
        this.searchHistoryRepositoryProvider = provider3;
    }

    public SearchViewModelFactory get() {
        return provideInstance(this.module, this.eventTrackerProvider, this.searchRepositoryProvider, this.searchHistoryRepositoryProvider);
    }

    public static SearchViewModelFactory provideInstance(SearchHistoryModule searchHistoryModule, Provider<EventTracker> provider, Provider<SearchRepository> provider2, Provider<SearchHistoryRepository> provider3) {
        return proxyProvidesViewModelFactory(searchHistoryModule, (EventTracker) provider.get(), (SearchRepository) provider2.get(), (SearchHistoryRepository) provider3.get());
    }

    public static SearchHistoryModule_ProvidesViewModelFactoryFactory create(SearchHistoryModule searchHistoryModule, Provider<EventTracker> provider, Provider<SearchRepository> provider2, Provider<SearchHistoryRepository> provider3) {
        return new SearchHistoryModule_ProvidesViewModelFactoryFactory(searchHistoryModule, provider, provider2, provider3);
    }

    public static SearchViewModelFactory proxyProvidesViewModelFactory(SearchHistoryModule searchHistoryModule, EventTracker eventTracker, SearchRepository searchRepository, SearchHistoryRepository searchHistoryRepository) {
        return (SearchViewModelFactory) Preconditions.checkNotNull(searchHistoryModule.providesViewModelFactory(eventTracker, searchRepository, searchHistoryRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
