package kr.co.popone.fitts.feature.search.view;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.search.home.SearchViewModel;

public final class SearchActivity_MembersInjector implements MembersInjector<SearchActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
    private final Provider<SearchViewModel> viewModelProvider;

    public SearchActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SearchViewModel> provider2) {
        this.fragmentInjectorProvider = provider;
        this.viewModelProvider = provider2;
    }

    public static MembersInjector<SearchActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SearchViewModel> provider2) {
        return new SearchActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(SearchActivity searchActivity) {
        injectFragmentInjector(searchActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
        injectViewModel(searchActivity, (SearchViewModel) this.viewModelProvider.get());
    }

    public static void injectFragmentInjector(SearchActivity searchActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        searchActivity.fragmentInjector = dispatchingAndroidInjector;
    }

    public static void injectViewModel(SearchActivity searchActivity, SearchViewModel searchViewModel) {
        searchActivity.viewModel = searchViewModel;
    }
}
