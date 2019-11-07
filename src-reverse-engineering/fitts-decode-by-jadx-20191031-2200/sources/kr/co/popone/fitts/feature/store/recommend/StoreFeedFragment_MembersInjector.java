package kr.co.popone.fitts.feature.store.recommend;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.store.home.StoreFeedViewModel;

public final class StoreFeedFragment_MembersInjector implements MembersInjector<StoreFeedFragment> {
    private final Provider<StoreFeedViewModel> vmProvider;

    public StoreFeedFragment_MembersInjector(Provider<StoreFeedViewModel> provider) {
        this.vmProvider = provider;
    }

    public static MembersInjector<StoreFeedFragment> create(Provider<StoreFeedViewModel> provider) {
        return new StoreFeedFragment_MembersInjector(provider);
    }

    public void injectMembers(StoreFeedFragment storeFeedFragment) {
        injectVm(storeFeedFragment, (StoreFeedViewModel) this.vmProvider.get());
    }

    public static void injectVm(StoreFeedFragment storeFeedFragment, StoreFeedViewModel storeFeedViewModel) {
        storeFeedFragment.vm = storeFeedViewModel;
    }
}
