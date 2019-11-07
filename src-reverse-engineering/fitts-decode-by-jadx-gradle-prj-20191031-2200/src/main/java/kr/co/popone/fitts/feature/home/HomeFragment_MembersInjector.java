package kr.co.popone.fitts.feature.home;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.home.HomeViewModel;

public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {
    private final Provider<HomeViewModel> viewModelProvider;

    public HomeFragment_MembersInjector(Provider<HomeViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<HomeFragment> create(Provider<HomeViewModel> provider) {
        return new HomeFragment_MembersInjector(provider);
    }

    public void injectMembers(HomeFragment homeFragment) {
        injectViewModel(homeFragment, (HomeViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(HomeFragment homeFragment, HomeViewModel homeViewModel) {
        homeFragment.viewModel = homeViewModel;
    }
}
