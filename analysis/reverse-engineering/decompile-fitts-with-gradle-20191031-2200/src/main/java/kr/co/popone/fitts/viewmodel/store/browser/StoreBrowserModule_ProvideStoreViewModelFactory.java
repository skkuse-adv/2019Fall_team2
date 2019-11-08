package kr.co.popone.fitts.viewmodel.store.browser;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.store.browser.StoreBrowserActivity;

public final class StoreBrowserModule_ProvideStoreViewModelFactory implements Factory<StoreBrowserViewModel> {
    private final Provider<StoreBrowserActivity> activityProvider;
    private final StoreBrowserModule module;
    private final Provider<StoreBrowserViewModelFactory> viewModelFactoryProvider;

    public StoreBrowserModule_ProvideStoreViewModelFactory(StoreBrowserModule storeBrowserModule, Provider<StoreBrowserActivity> provider, Provider<StoreBrowserViewModelFactory> provider2) {
        this.module = storeBrowserModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public StoreBrowserViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static StoreBrowserViewModel provideInstance(StoreBrowserModule storeBrowserModule, Provider<StoreBrowserActivity> provider, Provider<StoreBrowserViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(storeBrowserModule, (StoreBrowserActivity) provider.get(), (StoreBrowserViewModelFactory) provider2.get());
    }

    public static StoreBrowserModule_ProvideStoreViewModelFactory create(StoreBrowserModule storeBrowserModule, Provider<StoreBrowserActivity> provider, Provider<StoreBrowserViewModelFactory> provider2) {
        return new StoreBrowserModule_ProvideStoreViewModelFactory(storeBrowserModule, provider, provider2);
    }

    public static StoreBrowserViewModel proxyProvideStoreViewModel(StoreBrowserModule storeBrowserModule, StoreBrowserActivity storeBrowserActivity, StoreBrowserViewModelFactory storeBrowserViewModelFactory) {
        return (StoreBrowserViewModel) Preconditions.checkNotNull(storeBrowserModule.provideStoreViewModel(storeBrowserActivity, storeBrowserViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
