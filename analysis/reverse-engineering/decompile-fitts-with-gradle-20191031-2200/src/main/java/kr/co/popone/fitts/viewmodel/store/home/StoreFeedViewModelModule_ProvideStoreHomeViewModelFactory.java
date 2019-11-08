package kr.co.popone.fitts.viewmodel.store.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.store.recommend.StoreFeedFragment;

public final class StoreFeedViewModelModule_ProvideStoreHomeViewModelFactory implements Factory<StoreFeedViewModel> {
    private final Provider<StoreFeedFragment> fragmentProvider;
    private final StoreFeedViewModelModule module;
    private final Provider<StoreFeedViewModelFactory> viewModelFactoryProvider;

    public StoreFeedViewModelModule_ProvideStoreHomeViewModelFactory(StoreFeedViewModelModule storeFeedViewModelModule, Provider<StoreFeedFragment> provider, Provider<StoreFeedViewModelFactory> provider2) {
        this.module = storeFeedViewModelModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public StoreFeedViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static StoreFeedViewModel provideInstance(StoreFeedViewModelModule storeFeedViewModelModule, Provider<StoreFeedFragment> provider, Provider<StoreFeedViewModelFactory> provider2) {
        return proxyProvideStoreHomeViewModel(storeFeedViewModelModule, (StoreFeedFragment) provider.get(), (StoreFeedViewModelFactory) provider2.get());
    }

    public static StoreFeedViewModelModule_ProvideStoreHomeViewModelFactory create(StoreFeedViewModelModule storeFeedViewModelModule, Provider<StoreFeedFragment> provider, Provider<StoreFeedViewModelFactory> provider2) {
        return new StoreFeedViewModelModule_ProvideStoreHomeViewModelFactory(storeFeedViewModelModule, provider, provider2);
    }

    public static StoreFeedViewModel proxyProvideStoreHomeViewModel(StoreFeedViewModelModule storeFeedViewModelModule, StoreFeedFragment storeFeedFragment, StoreFeedViewModelFactory storeFeedViewModelFactory) {
        return (StoreFeedViewModel) Preconditions.checkNotNull(storeFeedViewModelModule.provideStoreHomeViewModel(storeFeedFragment, storeFeedViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
