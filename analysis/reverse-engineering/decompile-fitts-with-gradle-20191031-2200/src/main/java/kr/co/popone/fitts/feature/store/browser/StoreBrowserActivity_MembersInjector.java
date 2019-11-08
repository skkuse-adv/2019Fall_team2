package kr.co.popone.fitts.feature.store.browser;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.store.browser.StoreBrowserViewModel;

public final class StoreBrowserActivity_MembersInjector implements MembersInjector<StoreBrowserActivity> {
    private final Provider<StoreBrowserViewModel> viewModelProvider;

    public StoreBrowserActivity_MembersInjector(Provider<StoreBrowserViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<StoreBrowserActivity> create(Provider<StoreBrowserViewModel> provider) {
        return new StoreBrowserActivity_MembersInjector(provider);
    }

    public void injectMembers(StoreBrowserActivity storeBrowserActivity) {
        injectViewModel(storeBrowserActivity, (StoreBrowserViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(StoreBrowserActivity storeBrowserActivity, StoreBrowserViewModel storeBrowserViewModel) {
        storeBrowserActivity.viewModel = storeBrowserViewModel;
    }
}
