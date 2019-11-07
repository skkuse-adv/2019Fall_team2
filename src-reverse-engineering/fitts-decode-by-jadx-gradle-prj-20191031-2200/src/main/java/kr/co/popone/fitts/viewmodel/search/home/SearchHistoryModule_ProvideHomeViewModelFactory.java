package kr.co.popone.fitts.viewmodel.search.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.search.view.SearchHistoryFragment;

public final class SearchHistoryModule_ProvideHomeViewModelFactory implements Factory<SearchViewModel> {
    private final Provider<SearchHistoryFragment> fragmentProvider;
    private final SearchHistoryModule module;
    private final Provider<SearchViewModelFactory> viewModelFactoryProvider;

    public SearchHistoryModule_ProvideHomeViewModelFactory(SearchHistoryModule searchHistoryModule, Provider<SearchHistoryFragment> provider, Provider<SearchViewModelFactory> provider2) {
        this.module = searchHistoryModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public SearchViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static SearchViewModel provideInstance(SearchHistoryModule searchHistoryModule, Provider<SearchHistoryFragment> provider, Provider<SearchViewModelFactory> provider2) {
        return proxyProvideHomeViewModel(searchHistoryModule, (SearchHistoryFragment) provider.get(), (SearchViewModelFactory) provider2.get());
    }

    public static SearchHistoryModule_ProvideHomeViewModelFactory create(SearchHistoryModule searchHistoryModule, Provider<SearchHistoryFragment> provider, Provider<SearchViewModelFactory> provider2) {
        return new SearchHistoryModule_ProvideHomeViewModelFactory(searchHistoryModule, provider, provider2);
    }

    public static SearchViewModel proxyProvideHomeViewModel(SearchHistoryModule searchHistoryModule, SearchHistoryFragment searchHistoryFragment, SearchViewModelFactory searchViewModelFactory) {
        return (SearchViewModel) Preconditions.checkNotNull(searchHistoryModule.provideHomeViewModel(searchHistoryFragment, searchViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
