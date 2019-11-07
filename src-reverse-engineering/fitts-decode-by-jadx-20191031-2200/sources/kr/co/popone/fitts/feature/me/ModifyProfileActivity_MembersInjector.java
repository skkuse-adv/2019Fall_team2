package kr.co.popone.fitts.feature.me;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class ModifyProfileActivity_MembersInjector implements MembersInjector<ModifyProfileActivity> {
    private final Provider<UserAPI> userAPIProvider;

    public ModifyProfileActivity_MembersInjector(Provider<UserAPI> provider) {
        this.userAPIProvider = provider;
    }

    public static MembersInjector<ModifyProfileActivity> create(Provider<UserAPI> provider) {
        return new ModifyProfileActivity_MembersInjector(provider);
    }

    public void injectMembers(ModifyProfileActivity modifyProfileActivity) {
        injectUserAPI(modifyProfileActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectUserAPI(ModifyProfileActivity modifyProfileActivity, UserAPI userAPI) {
        modifyProfileActivity.userAPI = userAPI;
    }
}
