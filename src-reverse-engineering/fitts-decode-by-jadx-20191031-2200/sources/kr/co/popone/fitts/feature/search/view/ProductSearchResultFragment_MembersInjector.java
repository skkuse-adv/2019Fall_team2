package kr.co.popone.fitts.feature.search.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;

public final class ProductSearchResultFragment_MembersInjector implements MembersInjector<ProductSearchResultFragment> {
    private final Provider<SearchResultViewModel> viewModelProvider;

    public ProductSearchResultFragment_MembersInjector(Provider<SearchResultViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<ProductSearchResultFragment> create(Provider<SearchResultViewModel> provider) {
        return new ProductSearchResultFragment_MembersInjector(provider);
    }

    public void injectMembers(ProductSearchResultFragment productSearchResultFragment) {
        injectViewModel(productSearchResultFragment, (SearchResultViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(ProductSearchResultFragment productSearchResultFragment, SearchResultViewModel searchResultViewModel) {
        productSearchResultFragment.viewModel = searchResultViewModel;
    }
}
