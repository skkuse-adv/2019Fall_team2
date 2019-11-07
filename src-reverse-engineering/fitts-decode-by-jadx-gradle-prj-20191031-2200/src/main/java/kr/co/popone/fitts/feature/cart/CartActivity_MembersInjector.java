package kr.co.popone.fitts.feature.cart;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.cart.CartViewModel;

public final class CartActivity_MembersInjector implements MembersInjector<CartActivity> {
    private final Provider<CartViewModel> viewModelProvider;

    public CartActivity_MembersInjector(Provider<CartViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<CartActivity> create(Provider<CartViewModel> provider) {
        return new CartActivity_MembersInjector(provider);
    }

    public void injectMembers(CartActivity cartActivity) {
        injectViewModel(cartActivity, (CartViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(CartActivity cartActivity, CartViewModel cartViewModel) {
        cartActivity.viewModel = cartViewModel;
    }
}
