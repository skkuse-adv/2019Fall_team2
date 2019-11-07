package kr.co.popone.fitts.feature.search;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class ShopWebViewActivity_MembersInjector implements MembersInjector<ShopWebViewActivity> {
    private final Provider<UserAPI> userAPIProvider;

    public ShopWebViewActivity_MembersInjector(Provider<UserAPI> provider) {
        this.userAPIProvider = provider;
    }

    public static MembersInjector<ShopWebViewActivity> create(Provider<UserAPI> provider) {
        return new ShopWebViewActivity_MembersInjector(provider);
    }

    public void injectMembers(ShopWebViewActivity shopWebViewActivity) {
        injectUserAPI(shopWebViewActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectUserAPI(ShopWebViewActivity shopWebViewActivity, UserAPI userAPI) {
        shopWebViewActivity.userAPI = userAPI;
    }
}
