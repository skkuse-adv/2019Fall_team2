package kr.co.popone.fitts.feature.setting;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;

public final class SettingActivity_MembersInjector implements MembersInjector<SettingActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public SettingActivity_MembersInjector(Provider<SessionManager> provider, Provider<UserAPI> provider2) {
        this.sessionManagerProvider = provider;
        this.userAPIProvider = provider2;
    }

    public static MembersInjector<SettingActivity> create(Provider<SessionManager> provider, Provider<UserAPI> provider2) {
        return new SettingActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(SettingActivity settingActivity) {
        injectSessionManager(settingActivity, (SessionManager) this.sessionManagerProvider.get());
        injectUserAPI(settingActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectSessionManager(SettingActivity settingActivity, SessionManager sessionManager) {
        settingActivity.sessionManager = sessionManager;
    }

    public static void injectUserAPI(SettingActivity settingActivity, UserAPI userAPI) {
        settingActivity.userAPI = userAPI;
    }
}
