package kr.co.popone.fitts.viewmodel.search.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.search.view.SearchHomeFragment;

public final class SearchHomeModule_ProvideHomeViewModelFactory implements Factory<SearchViewModel> {
    private final Provider<SearchHomeFragment> fragmentProvider;
    private final SearchHomeModule module;
    private final Provider<SearchViewModelFactory> viewModelFactoryProvider;

    public SearchHomeModule_ProvideHomeViewModelFactory(SearchHomeModule searchHomeModule, Provider<SearchHomeFragment> provider, Provider<SearchViewModelFactory> provider2) {
        this.module = searchHomeModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public SearchViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static SearchViewModel provideInstance(SearchHomeModule searchHomeModule, Provider<SearchHomeFragment> provider, Provider<SearchViewModelFactory> provider2) {
        return proxyProvideHomeViewModel(searchHomeModule, (SearchHomeFragment) provider.get(), (SearchViewModelFactory) provider2.get());
    }

    public static SearchHomeModule_ProvideHomeViewModelFactory create(SearchHomeModule searchHomeModule, Provider<SearchHomeFragment> provider, Provider<SearchViewModelFactory> provider2) {
        return new SearchHomeModule_ProvideHomeViewModelFactory(searchHomeModule, provider, provider2);
    }

    public static SearchViewModel proxyProvideHomeViewModel(SearchHomeModule searchHomeModule, SearchHomeFragment searchHomeFragment, SearchViewModelFactory searchViewModelFactory) {
        return (SearchViewModel) Preconditions.checkNotNull(searchHomeModule.provideHomeViewModel(searchHomeFragment, searchViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
