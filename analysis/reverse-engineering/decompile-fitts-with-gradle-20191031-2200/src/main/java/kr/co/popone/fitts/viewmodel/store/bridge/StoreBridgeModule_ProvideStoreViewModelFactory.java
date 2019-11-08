package kr.co.popone.fitts.viewmodel.store.bridge;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity;

public final class StoreBridgeModule_ProvideStoreViewModelFactory implements Factory<ShopBridgeViewModel> {
    private final Provider<ShopBridgeActivity> activityProvider;
    private final StoreBridgeModule module;
    private final Provider<StoreBridgeViewModelFactory> viewModelFactoryProvider;

    public StoreBridgeModule_ProvideStoreViewModelFactory(StoreBridgeModule storeBridgeModule, Provider<ShopBridgeActivity> provider, Provider<StoreBridgeViewModelFactory> provider2) {
        this.module = storeBridgeModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public ShopBridgeViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static ShopBridgeViewModel provideInstance(StoreBridgeModule storeBridgeModule, Provider<ShopBridgeActivity> provider, Provider<StoreBridgeViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(storeBridgeModule, (ShopBridgeActivity) provider.get(), (StoreBridgeViewModelFactory) provider2.get());
    }

    public static StoreBridgeModule_ProvideStoreViewModelFactory create(StoreBridgeModule storeBridgeModule, Provider<ShopBridgeActivity> provider, Provider<StoreBridgeViewModelFactory> provider2) {
        return new StoreBridgeModule_ProvideStoreViewModelFactory(storeBridgeModule, provider, provider2);
    }

    public static ShopBridgeViewModel proxyProvideStoreViewModel(StoreBridgeModule storeBridgeModule, ShopBridgeActivity shopBridgeActivity, StoreBridgeViewModelFactory storeBridgeViewModelFactory) {
        return (ShopBridgeViewModel) Preconditions.checkNotNull(storeBridgeModule.provideStoreViewModel(shopBridgeActivity, storeBridgeViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
