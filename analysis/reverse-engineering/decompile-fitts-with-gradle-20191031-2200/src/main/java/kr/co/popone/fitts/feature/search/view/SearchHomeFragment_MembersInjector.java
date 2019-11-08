package kr.co.popone.fitts.feature.search.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel;

public final class SearchHomeFragment_MembersInjector implements MembersInjector<SearchHomeFragment> {
    private final Provider<SearchViewModel> viewModelProvider;

    public SearchHomeFragment_MembersInjector(Provider<SearchViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<SearchHomeFragment> create(Provider<SearchViewModel> provider) {
        return new SearchHomeFragment_MembersInjector(provider);
    }

    public void injectMembers(SearchHomeFragment searchHomeFragment) {
        injectViewModel(searchHomeFragment, (SearchViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(SearchHomeFragment searchHomeFragment, SearchViewModel searchViewModel) {
        searchHomeFragment.viewModel = searchViewModel;
    }
}
