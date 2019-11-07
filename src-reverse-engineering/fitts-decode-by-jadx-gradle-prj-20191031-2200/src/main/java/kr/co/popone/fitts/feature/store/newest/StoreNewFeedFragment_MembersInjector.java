package kr.co.popone.fitts.feature.store.newest;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.store.newest.NewestProductViewModel;

public final class StoreNewFeedFragment_MembersInjector implements MembersInjector<StoreNewFeedFragment> {
    private final Provider<NewestProductViewModel> vmProvider;

    public StoreNewFeedFragment_MembersInjector(Provider<NewestProductViewModel> provider) {
        this.vmProvider = provider;
    }

    public static MembersInjector<StoreNewFeedFragment> create(Provider<NewestProductViewModel> provider) {
        return new StoreNewFeedFragment_MembersInjector(provider);
    }

    public void injectMembers(StoreNewFeedFragment storeNewFeedFragment) {
        injectVm(storeNewFeedFragment, (NewestProductViewModel) this.vmProvider.get());
    }

    public static void injectVm(StoreNewFeedFragment storeNewFeedFragment, NewestProductViewModel newestProductViewModel) {
        storeNewFeedFragment.vm = newestProductViewModel;
    }
}
