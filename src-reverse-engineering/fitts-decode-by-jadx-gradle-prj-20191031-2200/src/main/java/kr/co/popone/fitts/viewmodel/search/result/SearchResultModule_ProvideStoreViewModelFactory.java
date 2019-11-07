package kr.co.popone.fitts.viewmodel.search.result;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.search.view.SearchResultFragment;

public final class SearchResultModule_ProvideStoreViewModelFactory implements Factory<SearchResultViewModel> {
    private final Provider<SearchResultFragment> fragmentProvider;
    private final SearchResultModule module;
    private final Provider<SearchResultViewModelFactory> viewModelFactoryProvider;

    public SearchResultModule_ProvideStoreViewModelFactory(SearchResultModule searchResultModule, Provider<SearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        this.module = searchResultModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public SearchResultViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static SearchResultViewModel provideInstance(SearchResultModule searchResultModule, Provider<SearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(searchResultModule, (SearchResultFragment) provider.get(), (SearchResultViewModelFactory) provider2.get());
    }

    public static SearchResultModule_ProvideStoreViewModelFactory create(SearchResultModule searchResultModule, Provider<SearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return new SearchResultModule_ProvideStoreViewModelFactory(searchResultModule, provider, provider2);
    }

    public static SearchResultViewModel proxyProvideStoreViewModel(SearchResultModule searchResultModule, SearchResultFragment searchResultFragment, SearchResultViewModelFactory searchResultViewModelFactory) {
        return (SearchResultViewModel) Preconditions.checkNotNull(searchResultModule.provideStoreViewModel(searchResultFragment, searchResultViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
