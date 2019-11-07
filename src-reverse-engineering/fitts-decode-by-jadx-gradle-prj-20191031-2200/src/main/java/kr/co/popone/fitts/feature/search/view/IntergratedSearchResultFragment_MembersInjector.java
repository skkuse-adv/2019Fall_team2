package kr.co.popone.fitts.feature.search.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;

public final class IntergratedSearchResultFragment_MembersInjector implements MembersInjector<IntergratedSearchResultFragment> {
    private final Provider<SearchResultViewModel> viewModelProvider;

    public IntergratedSearchResultFragment_MembersInjector(Provider<SearchResultViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<IntergratedSearchResultFragment> create(Provider<SearchResultViewModel> provider) {
        return new IntergratedSearchResultFragment_MembersInjector(provider);
    }

    public void injectMembers(IntergratedSearchResultFragment intergratedSearchResultFragment) {
        injectViewModel(intergratedSearchResultFragment, (SearchResultViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(IntergratedSearchResultFragment intergratedSearchResultFragment, SearchResultViewModel searchResultViewModel) {
        intergratedSearchResultFragment.viewModel = searchResultViewModel;
    }
}
