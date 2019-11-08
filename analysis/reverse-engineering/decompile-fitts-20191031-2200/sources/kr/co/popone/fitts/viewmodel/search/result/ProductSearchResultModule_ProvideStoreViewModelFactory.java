package kr.co.popone.fitts.viewmodel.search.result;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.search.view.ProductSearchResultFragment;

public final class ProductSearchResultModule_ProvideStoreViewModelFactory implements Factory<SearchResultViewModel> {
    private final Provider<ProductSearchResultFragment> fragmentProvider;
    private final ProductSearchResultModule module;
    private final Provider<SearchResultViewModelFactory> viewModelFactoryProvider;

    public ProductSearchResultModule_ProvideStoreViewModelFactory(ProductSearchResultModule productSearchResultModule, Provider<ProductSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        this.module = productSearchResultModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public SearchResultViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static SearchResultViewModel provideInstance(ProductSearchResultModule productSearchResultModule, Provider<ProductSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(productSearchResultModule, (ProductSearchResultFragment) provider.get(), (SearchResultViewModelFactory) provider2.get());
    }

    public static ProductSearchResultModule_ProvideStoreViewModelFactory create(ProductSearchResultModule productSearchResultModule, Provider<ProductSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return new ProductSearchResultModule_ProvideStoreViewModelFactory(productSearchResultModule, provider, provider2);
    }

    public static SearchResultViewModel proxyProvideStoreViewModel(ProductSearchResultModule productSearchResultModule, ProductSearchResultFragment productSearchResultFragment, SearchResultViewModelFactory searchResultViewModelFactory) {
        return (SearchResultViewModel) Preconditions.checkNotNull(productSearchResultModule.provideStoreViewModel(productSearchResultFragment, searchResultViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
