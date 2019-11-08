package kr.co.popone.fitts.feature.search.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;

public final class FittieSearchResultFragment_MembersInjector implements MembersInjector<FittieSearchResultFragment> {
    private final Provider<SearchResultViewModel> viewModelProvider;

    public FittieSearchResultFragment_MembersInjector(Provider<SearchResultViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<FittieSearchResultFragment> create(Provider<SearchResultViewModel> provider) {
        return new FittieSearchResultFragment_MembersInjector(provider);
    }

    public void injectMembers(FittieSearchResultFragment fittieSearchResultFragment) {
        injectViewModel(fittieSearchResultFragment, (SearchResultViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(FittieSearchResultFragment fittieSearchResultFragment, SearchResultViewModel searchResultViewModel) {
        fittieSearchResultFragment.viewModel = searchResultViewModel;
    }
}
