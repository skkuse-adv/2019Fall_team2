package kr.co.popone.fitts.feature.home.feed;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.home.feed.HomeFeedViewModel;

public final class HomeFeedFragment_MembersInjector implements MembersInjector<HomeFeedFragment> {
    private final Provider<HomeFeedViewModel> viewModelProvider;

    public HomeFeedFragment_MembersInjector(Provider<HomeFeedViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<HomeFeedFragment> create(Provider<HomeFeedViewModel> provider) {
        return new HomeFeedFragment_MembersInjector(provider);
    }

    public void injectMembers(HomeFeedFragment homeFeedFragment) {
        injectViewModel(homeFeedFragment, (HomeFeedViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(HomeFeedFragment homeFeedFragment, HomeFeedViewModel homeFeedViewModel) {
        homeFeedFragment.viewModel = homeFeedViewModel;
    }
}
