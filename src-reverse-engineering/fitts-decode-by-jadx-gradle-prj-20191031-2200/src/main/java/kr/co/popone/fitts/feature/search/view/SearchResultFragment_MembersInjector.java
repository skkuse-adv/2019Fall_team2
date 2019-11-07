package kr.co.popone.fitts.feature.search.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;

public final class SearchResultFragment_MembersInjector implements MembersInjector<SearchResultFragment> {
    private final Provider<SearchResultViewModel> viewModelProvider;

    public SearchResultFragment_MembersInjector(Provider<SearchResultViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<SearchResultFragment> create(Provider<SearchResultViewModel> provider) {
        return new SearchResultFragment_MembersInjector(provider);
    }

    public void injectMembers(SearchResultFragment searchResultFragment) {
        injectViewModel(searchResultFragment, (SearchResultViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(SearchResultFragment searchResultFragment, SearchResultViewModel searchResultViewModel) {
        searchResultFragment.viewModel = searchResultViewModel;
    }
}
