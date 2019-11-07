package kr.co.popone.fitts.viewmodel.store;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.store.StoreFragment;

public final class StoreModule_ProvideStoreViewModelFactory implements Factory<StoreViewModel> {
    private final Provider<StoreFragment> fragmentProvider;
    private final StoreModule module;
    private final Provider<StoreViewModelFactory> viewModelFactoryProvider;

    public StoreModule_ProvideStoreViewModelFactory(StoreModule storeModule, Provider<StoreFragment> provider, Provider<StoreViewModelFactory> provider2) {
        this.module = storeModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public StoreViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static StoreViewModel provideInstance(StoreModule storeModule, Provider<StoreFragment> provider, Provider<StoreViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(storeModule, (StoreFragment) provider.get(), (StoreViewModelFactory) provider2.get());
    }

    public static StoreModule_ProvideStoreViewModelFactory create(StoreModule storeModule, Provider<StoreFragment> provider, Provider<StoreViewModelFactory> provider2) {
        return new StoreModule_ProvideStoreViewModelFactory(storeModule, provider, provider2);
    }

    public static StoreViewModel proxyProvideStoreViewModel(StoreModule storeModule, StoreFragment storeFragment, StoreViewModelFactory storeViewModelFactory) {
        return (StoreViewModel) Preconditions.checkNotNull(storeModule.provideStoreViewModel(storeFragment, storeViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
