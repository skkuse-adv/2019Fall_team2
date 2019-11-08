package kr.co.popone.fitts.viewmodel.store.list;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.store.bookmark.ShopBookmarkActivity;

public final class ShopBookmarkModule_ProvideStoreHomeViewModelFactory implements Factory<ShopBookmarkViewModel> {
    private final Provider<ShopBookmarkActivity> activityProvider;
    private final ShopBookmarkModule module;
    private final Provider<ShopBookmarkViewModelFactory> viewModelFactoryProvider;

    public ShopBookmarkModule_ProvideStoreHomeViewModelFactory(ShopBookmarkModule shopBookmarkModule, Provider<ShopBookmarkActivity> provider, Provider<ShopBookmarkViewModelFactory> provider2) {
        this.module = shopBookmarkModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public ShopBookmarkViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static ShopBookmarkViewModel provideInstance(ShopBookmarkModule shopBookmarkModule, Provider<ShopBookmarkActivity> provider, Provider<ShopBookmarkViewModelFactory> provider2) {
        return proxyProvideStoreHomeViewModel(shopBookmarkModule, (ShopBookmarkActivity) provider.get(), (ShopBookmarkViewModelFactory) provider2.get());
    }

    public static ShopBookmarkModule_ProvideStoreHomeViewModelFactory create(ShopBookmarkModule shopBookmarkModule, Provider<ShopBookmarkActivity> provider, Provider<ShopBookmarkViewModelFactory> provider2) {
        return new ShopBookmarkModule_ProvideStoreHomeViewModelFactory(shopBookmarkModule, provider, provider2);
    }

    public static ShopBookmarkViewModel proxyProvideStoreHomeViewModel(ShopBookmarkModule shopBookmarkModule, ShopBookmarkActivity shopBookmarkActivity, ShopBookmarkViewModelFactory shopBookmarkViewModelFactory) {
        return (ShopBookmarkViewModel) Preconditions.checkNotNull(shopBookmarkModule.provideStoreHomeViewModel(shopBookmarkActivity, shopBookmarkViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
