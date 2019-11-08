package kr.co.popone.fitts.feature.post;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class UserSizeInputActivity_MembersInjector implements MembersInjector<UserSizeInputActivity> {
    private final Provider<UserAPI> userAPIProvider;

    public UserSizeInputActivity_MembersInjector(Provider<UserAPI> provider) {
        this.userAPIProvider = provider;
    }

    public static MembersInjector<UserSizeInputActivity> create(Provider<UserAPI> provider) {
        return new UserSizeInputActivity_MembersInjector(provider);
    }

    public void injectMembers(UserSizeInputActivity userSizeInputActivity) {
        injectUserAPI(userSizeInputActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectUserAPI(UserSizeInputActivity userSizeInputActivity, UserAPI userAPI) {
        userSizeInputActivity.userAPI = userAPI;
    }
}
