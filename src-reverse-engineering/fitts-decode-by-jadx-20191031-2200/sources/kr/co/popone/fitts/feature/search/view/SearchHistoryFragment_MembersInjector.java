package kr.co.popone.fitts.feature.search.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel;

public final class SearchHistoryFragment_MembersInjector implements MembersInjector<SearchHistoryFragment> {
    private final Provider<SearchViewModel> viewModelProvider;

    public SearchHistoryFragment_MembersInjector(Provider<SearchViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<SearchHistoryFragment> create(Provider<SearchViewModel> provider) {
        return new SearchHistoryFragment_MembersInjector(provider);
    }

    public void injectMembers(SearchHistoryFragment searchHistoryFragment) {
        injectViewModel(searchHistoryFragment, (SearchViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(SearchHistoryFragment searchHistoryFragment, SearchViewModel searchViewModel) {
        searchHistoryFragment.viewModel = searchViewModel;
    }
}
