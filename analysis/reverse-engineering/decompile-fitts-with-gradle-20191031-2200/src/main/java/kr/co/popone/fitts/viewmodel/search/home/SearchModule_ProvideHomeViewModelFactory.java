package kr.co.popone.fitts.viewmodel.search.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.search.view.SearchActivity;

public final class SearchModule_ProvideHomeViewModelFactory implements Factory<SearchViewModel> {
    private final Provider<SearchActivity> activityProvider;
    private final SearchModule module;
    private final Provider<SearchViewModelFactory> viewModelFactoryProvider;

    public SearchModule_ProvideHomeViewModelFactory(SearchModule searchModule, Provider<SearchActivity> provider, Provider<SearchViewModelFactory> provider2) {
        this.module = searchModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public SearchViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static SearchViewModel provideInstance(SearchModule searchModule, Provider<SearchActivity> provider, Provider<SearchViewModelFactory> provider2) {
        return proxyProvideHomeViewModel(searchModule, (SearchActivity) provider.get(), (SearchViewModelFactory) provider2.get());
    }

    public static SearchModule_ProvideHomeViewModelFactory create(SearchModule searchModule, Provider<SearchActivity> provider, Provider<SearchViewModelFactory> provider2) {
        return new SearchModule_ProvideHomeViewModelFactory(searchModule, provider, provider2);
    }

    public static SearchViewModel proxyProvideHomeViewModel(SearchModule searchModule, SearchActivity searchActivity, SearchViewModelFactory searchViewModelFactory) {
        return (SearchViewModel) Preconditions.checkNotNull(searchModule.provideHomeViewModel(searchActivity, searchViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
