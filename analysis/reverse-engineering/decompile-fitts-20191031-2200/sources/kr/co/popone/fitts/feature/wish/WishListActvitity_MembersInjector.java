package kr.co.popone.fitts.feature.wish;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.wish.WishListViewModel;

public final class WishListActvitity_MembersInjector implements MembersInjector<WishListActvitity> {
    private final Provider<WishListViewModel> viewModelProvider;

    public WishListActvitity_MembersInjector(Provider<WishListViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<WishListActvitity> create(Provider<WishListViewModel> provider) {
        return new WishListActvitity_MembersInjector(provider);
    }

    public void injectMembers(WishListActvitity wishListActvitity) {
        injectViewModel(wishListActvitity, (WishListViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(WishListActvitity wishListActvitity, WishListViewModel wishListViewModel) {
        wishListActvitity.viewModel = wishListViewModel;
    }
}
