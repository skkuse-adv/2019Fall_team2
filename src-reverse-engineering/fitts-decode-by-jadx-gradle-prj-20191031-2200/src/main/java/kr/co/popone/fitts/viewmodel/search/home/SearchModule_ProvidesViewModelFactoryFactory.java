package kr.co.popone.fitts.viewmodel.search.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.search.SearchHistoryRepository;
import kr.co.popone.fitts.repository.SearchRepository;

public final class SearchModule_ProvidesViewModelFactoryFactory implements Factory<SearchViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final SearchModule module;
    private final Provider<SearchHistoryRepository> searchHistoryRepositoryProvider;
    private final Provider<SearchRepository> searchRepositoryProvider;

    public SearchModule_ProvidesViewModelFactoryFactory(SearchModule searchModule, Provider<EventTracker> provider, Provider<SearchRepository> provider2, Provider<SearchHistoryRepository> provider3) {
        this.module = searchModule;
        this.eventTrackerProvider = provider;
        this.searchRepositoryProvider = provider2;
        this.searchHistoryRepositoryProvider = provider3;
    }

    public SearchViewModelFactory get() {
        return provideInstance(this.module, this.eventTrackerProvider, this.searchRepositoryProvider, this.searchHistoryRepositoryProvider);
    }

    public static SearchViewModelFactory provideInstance(SearchModule searchModule, Provider<EventTracker> provider, Provider<SearchRepository> provider2, Provider<SearchHistoryRepository> provider3) {
        return proxyProvidesViewModelFactory(searchModule, (EventTracker) provider.get(), (SearchRepository) provider2.get(), (SearchHistoryRepository) provider3.get());
    }

    public static SearchModule_ProvidesViewModelFactoryFactory create(SearchModule searchModule, Provider<EventTracker> provider, Provider<SearchRepository> provider2, Provider<SearchHistoryRepository> provider3) {
        return new SearchModule_ProvidesViewModelFactoryFactory(searchModule, provider, provider2, provider3);
    }

    public static SearchViewModelFactory proxyProvidesViewModelFactory(SearchModule searchModule, EventTracker eventTracker, SearchRepository searchRepository, SearchHistoryRepository searchHistoryRepository) {
        return (SearchViewModelFactory) Preconditions.checkNotNull(searchModule.providesViewModelFactory(eventTracker, searchRepository, searchHistoryRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
