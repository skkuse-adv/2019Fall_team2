package kr.co.popone.fitts.feature.search.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.search.result.SearchResultViewModel;

public final class PostSearchResultFragment_MembersInjector implements MembersInjector<PostSearchResultFragment> {
    private final Provider<SearchResultViewModel> viewModelProvider;

    public PostSearchResultFragment_MembersInjector(Provider<SearchResultViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<PostSearchResultFragment> create(Provider<SearchResultViewModel> provider) {
        return new PostSearchResultFragment_MembersInjector(provider);
    }

    public void injectMembers(PostSearchResultFragment postSearchResultFragment) {
        injectViewModel(postSearchResultFragment, (SearchResultViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(PostSearchResultFragment postSearchResultFragment, SearchResultViewModel searchResultViewModel) {
        postSearchResultFragment.viewModel = searchResultViewModel;
    }
}
