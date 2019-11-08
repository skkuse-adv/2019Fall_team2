package kr.co.popone.fitts.feature.setting;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class ModifyUserInfoActivity_MembersInjector implements MembersInjector<ModifyUserInfoActivity> {
    private final Provider<UserAPI> userAPIProvider;

    public ModifyUserInfoActivity_MembersInjector(Provider<UserAPI> provider) {
        this.userAPIProvider = provider;
    }

    public static MembersInjector<ModifyUserInfoActivity> create(Provider<UserAPI> provider) {
        return new ModifyUserInfoActivity_MembersInjector(provider);
    }

    public void injectMembers(ModifyUserInfoActivity modifyUserInfoActivity) {
        injectUserAPI(modifyUserInfoActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectUserAPI(ModifyUserInfoActivity modifyUserInfoActivity, UserAPI userAPI) {
        modifyUserInfoActivity.userAPI = userAPI;
    }
}
