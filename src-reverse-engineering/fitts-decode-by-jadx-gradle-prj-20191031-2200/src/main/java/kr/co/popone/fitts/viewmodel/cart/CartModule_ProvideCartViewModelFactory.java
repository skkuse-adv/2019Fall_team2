package kr.co.popone.fitts.viewmodel.cart;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.cart.CartActivity;

public final class CartModule_ProvideCartViewModelFactory implements Factory<CartViewModel> {
    private final Provider<CartActivity> activityProvider;
    private final CartModule module;
    private final Provider<CartViewModelFactory> viewModelFactoryProvider;

    public CartModule_ProvideCartViewModelFactory(CartModule cartModule, Provider<CartActivity> provider, Provider<CartViewModelFactory> provider2) {
        this.module = cartModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public CartViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static CartViewModel provideInstance(CartModule cartModule, Provider<CartActivity> provider, Provider<CartViewModelFactory> provider2) {
        return proxyProvideCartViewModel(cartModule, (CartActivity) provider.get(), (CartViewModelFactory) provider2.get());
    }

    public static CartModule_ProvideCartViewModelFactory create(CartModule cartModule, Provider<CartActivity> provider, Provider<CartViewModelFactory> provider2) {
        return new CartModule_ProvideCartViewModelFactory(cartModule, provider, provider2);
    }

    public static CartViewModel proxyProvideCartViewModel(CartModule cartModule, CartActivity cartActivity, CartViewModelFactory cartViewModelFactory) {
        return (CartViewModel) Preconditions.checkNotNull(cartModule.provideCartViewModel(cartActivity, cartViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
