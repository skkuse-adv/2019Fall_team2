package kr.co.popone.fitts.viewmodel.search.result;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.search.view.FittieSearchResultFragment;

public final class FittieSearchResultModule_ProvideStoreViewModelFactory implements Factory<SearchResultViewModel> {
    private final Provider<FittieSearchResultFragment> fragmentProvider;
    private final FittieSearchResultModule module;
    private final Provider<SearchResultViewModelFactory> viewModelFactoryProvider;

    public FittieSearchResultModule_ProvideStoreViewModelFactory(FittieSearchResultModule fittieSearchResultModule, Provider<FittieSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        this.module = fittieSearchResultModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public SearchResultViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static SearchResultViewModel provideInstance(FittieSearchResultModule fittieSearchResultModule, Provider<FittieSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(fittieSearchResultModule, (FittieSearchResultFragment) provider.get(), (SearchResultViewModelFactory) provider2.get());
    }

    public static FittieSearchResultModule_ProvideStoreViewModelFactory create(FittieSearchResultModule fittieSearchResultModule, Provider<FittieSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return new FittieSearchResultModule_ProvideStoreViewModelFactory(fittieSearchResultModule, provider, provider2);
    }

    public static SearchResultViewModel proxyProvideStoreViewModel(FittieSearchResultModule fittieSearchResultModule, FittieSearchResultFragment fittieSearchResultFragment, SearchResultViewModelFactory searchResultViewModelFactory) {
        return (SearchResultViewModel) Preconditions.checkNotNull(fittieSearchResultModule.provideStoreViewModel(fittieSearchResultFragment, searchResultViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
