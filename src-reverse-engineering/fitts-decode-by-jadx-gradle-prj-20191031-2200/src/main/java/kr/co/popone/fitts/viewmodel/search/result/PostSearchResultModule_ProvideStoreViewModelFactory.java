package kr.co.popone.fitts.viewmodel.search.result;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.search.view.PostSearchResultFragment;

public final class PostSearchResultModule_ProvideStoreViewModelFactory implements Factory<SearchResultViewModel> {
    private final Provider<PostSearchResultFragment> fragmentProvider;
    private final PostSearchResultModule module;
    private final Provider<SearchResultViewModelFactory> viewModelFactoryProvider;

    public PostSearchResultModule_ProvideStoreViewModelFactory(PostSearchResultModule postSearchResultModule, Provider<PostSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        this.module = postSearchResultModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public SearchResultViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static SearchResultViewModel provideInstance(PostSearchResultModule postSearchResultModule, Provider<PostSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(postSearchResultModule, (PostSearchResultFragment) provider.get(), (SearchResultViewModelFactory) provider2.get());
    }

    public static PostSearchResultModule_ProvideStoreViewModelFactory create(PostSearchResultModule postSearchResultModule, Provider<PostSearchResultFragment> provider, Provider<SearchResultViewModelFactory> provider2) {
        return new PostSearchResultModule_ProvideStoreViewModelFactory(postSearchResultModule, provider, provider2);
    }

    public static SearchResultViewModel proxyProvideStoreViewModel(PostSearchResultModule postSearchResultModule, PostSearchResultFragment postSearchResultFragment, SearchResultViewModelFactory searchResultViewModelFactory) {
        return (SearchResultViewModel) Preconditions.checkNotNull(postSearchResultModule.provideStoreViewModel(postSearchResultFragment, searchResultViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
