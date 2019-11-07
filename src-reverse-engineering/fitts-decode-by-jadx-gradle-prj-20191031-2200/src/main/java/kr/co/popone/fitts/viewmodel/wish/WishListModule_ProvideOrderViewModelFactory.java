package kr.co.popone.fitts.viewmodel.wish;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.wish.WishListActvitity;

public final class WishListModule_ProvideOrderViewModelFactory implements Factory<WishListViewModel> {
    private final Provider<WishListActvitity> activityProvider;
    private final WishListModule module;
    private final Provider<WishListViewModelFactory> viewModelFactoryProvider;

    public WishListModule_ProvideOrderViewModelFactory(WishListModule wishListModule, Provider<WishListActvitity> provider, Provider<WishListViewModelFactory> provider2) {
        this.module = wishListModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public WishListViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static WishListViewModel provideInstance(WishListModule wishListModule, Provider<WishListActvitity> provider, Provider<WishListViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(wishListModule, (WishListActvitity) provider.get(), (WishListViewModelFactory) provider2.get());
    }

    public static WishListModule_ProvideOrderViewModelFactory create(WishListModule wishListModule, Provider<WishListActvitity> provider, Provider<WishListViewModelFactory> provider2) {
        return new WishListModule_ProvideOrderViewModelFactory(wishListModule, provider, provider2);
    }

    public static WishListViewModel proxyProvideOrderViewModel(WishListModule wishListModule, WishListActvitity wishListActvitity, WishListViewModelFactory wishListViewModelFactory) {
        return (WishListViewModel) Preconditions.checkNotNull(wishListModule.provideOrderViewModel(wishListActvitity, wishListViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
