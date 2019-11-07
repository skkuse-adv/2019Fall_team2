package kr.co.popone.fitts.feature.store;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.store.StoreViewModel;

public final class StoreFragment_MembersInjector implements MembersInjector<StoreFragment> {
    private final Provider<StoreViewModel> viewModelProvider;

    public StoreFragment_MembersInjector(Provider<StoreViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<StoreFragment> create(Provider<StoreViewModel> provider) {
        return new StoreFragment_MembersInjector(provider);
    }

    public void injectMembers(StoreFragment storeFragment) {
        injectViewModel(storeFragment, (StoreViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(StoreFragment storeFragment, StoreViewModel storeViewModel) {
        storeFragment.viewModel = storeViewModel;
    }
}
