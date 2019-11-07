package kr.co.popone.fitts.viewmodel.search.result;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.repository.SearchRepository;
import kr.co.popone.fitts.repository.UserRepository;

public final class SearchResultModule_ProvidesViewModelFactoryFactory implements Factory<SearchResultViewModelFactory> {
    private final Provider<ActionLogAPI> actionLogProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<SearchResultFragment> fragmentProvider;
    private final SearchResultModule module;
    private final Provider<SearchRepository> searchRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public SearchResultModule_ProvidesViewModelFactoryFactory(SearchResultModule searchResultModule, Provider<SearchResultFragment> provider, Provider<SearchRepository> provider2, Provider<UserRepository> provider3, Provider<EventTracker> provider4, Provider<ActionLogAPI> provider5) {
        this.module = searchResultModule;
        this.fragmentProvider = provider;
        this.searchRepositoryProvider = provider2;
        this.userRepositoryProvider = provider3;
        this.eventTrackerProvider = provider4;
        this.actionLogProvider = provider5;
    }

    public SearchResultViewModelFactory get() {
        return provideInstance(this.module, this.fragmentProvider, this.searchRepositoryProvider, this.userRepositoryProvider, this.eventTrackerProvider, this.actionLogProvider);
    }

    public static SearchResultViewModelFactory provideInstance(SearchResultModule searchResultModule, Provider<SearchResultFragment> provider, Provider<SearchRepository> provider2, Provider<UserRepository> provider3, Provider<EventTracker> provider4, Provider<ActionLogAPI> provider5) {
        return proxyProvidesViewModelFactory(searchResultModule, (SearchResultFragment) provider.get(), (SearchRepository) provider2.get(), (UserRepository) provider3.get(), (EventTracker) provider4.get(), (ActionLogAPI) provider5.get());
    }

    public static SearchResultModule_ProvidesViewModelFactoryFactory create(SearchResultModule searchResultModule, Provider<SearchResultFragment> provider, Provider<SearchRepository> provider2, Provider<UserRepository> provider3, Provider<EventTracker> provider4, Provider<ActionLogAPI> provider5) {
        SearchResultModule_ProvidesViewModelFactoryFactory searchResultModule_ProvidesViewModelFactoryFactory = new SearchResultModule_ProvidesViewModelFactoryFactory(searchResultModule, provider, provider2, provider3, provider4, provider5);
        return searchResultModule_ProvidesViewModelFactoryFactory;
    }

    public static SearchResultViewModelFactory proxyProvidesViewModelFactory(SearchResultModule searchResultModule, SearchResultFragment searchResultFragment, SearchRepository searchRepository, UserRepository userRepository, EventTracker eventTracker, ActionLogAPI actionLogAPI) {
        return (SearchResultViewModelFactory) Preconditions.checkNotNull(searchResultModule.providesViewModelFactory(searchResultFragment, searchRepository, userRepository, eventTracker, actionLogAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
