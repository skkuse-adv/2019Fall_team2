package kr.co.popone.fitts.viewmodel.search.result;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.search.view.IntergratedSearchResultFragment;

public final class UnifiedSearchResultModule_ProvideStoreViewModelFactory implements Factory<SearchResultViewModel> {
    private final Provider<IntergratedSearchResultFragment> fragmentProvider;
    private final UnifiedSearchResultModule module;
    private final Provider<SearchResultViewModelFactory> viewModelFactoryProvider;

    public UnifiedSearchResultModule_ProvideStoreViewModelFactory(UnifiedSearchResultModule unifiedSearchResultModule, Provider<IntergratedSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        this.module = unifiedSearchResultModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public SearchResultViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static SearchResultViewModel provideInstance(UnifiedSearchResultModule unifiedSearchResultModule, Provider<IntergratedSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(unifiedSearchResultModule, (IntergratedSearchResultFragment) provider.get(), (SearchResultViewModelFactory) provider2.get());
    }

    public static UnifiedSearchResultModule_ProvideStoreViewModelFactory create(UnifiedSearchResultModule unifiedSearchResultModule, Provider<IntergratedSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return new UnifiedSearchResultModule_ProvideStoreViewModelFactory(unifiedSearchResultModule, provider, provider2);
    }

    public static SearchResultViewModel proxyProvideStoreViewModel(UnifiedSearchResultModule unifiedSearchResultModule, IntergratedSearchResultFragment intergratedSearchResultFragment, SearchResultViewModelFactory searchResultViewModelFactory) {
        return (SearchResultViewModel) Preconditions.checkNotNull(unifiedSearchResultModule.provideStoreViewModel(intergratedSearchResultFragment, searchResultViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
