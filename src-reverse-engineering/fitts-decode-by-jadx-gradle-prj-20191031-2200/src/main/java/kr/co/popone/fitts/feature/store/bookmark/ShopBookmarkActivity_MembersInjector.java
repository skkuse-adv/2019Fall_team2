package kr.co.popone.fitts.feature.store.bookmark;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.store.list.ShopBookmarkViewModel;

public final class ShopBookmarkActivity_MembersInjector implements MembersInjector<ShopBookmarkActivity> {
    private final Provider<ShopBookmarkViewModel> viewModelProvider;

    public ShopBookmarkActivity_MembersInjector(Provider<ShopBookmarkViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<ShopBookmarkActivity> create(Provider<ShopBookmarkViewModel> provider) {
        return new ShopBookmarkActivity_MembersInjector(provider);
    }

    public void injectMembers(ShopBookmarkActivity shopBookmarkActivity) {
        injectViewModel(shopBookmarkActivity, (ShopBookmarkViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(ShopBookmarkActivity shopBookmarkActivity, ShopBookmarkViewModel shopBookmarkViewModel) {
        shopBookmarkActivity.viewModel = shopBookmarkViewModel;
    }
}
