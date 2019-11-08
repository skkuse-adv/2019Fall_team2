package kr.co.popone.fitts.feature.me;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;

public final class ModifyBodyActivity_MembersInjector implements MembersInjector<ModifyBodyActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public ModifyBodyActivity_MembersInjector(Provider<UserAPI> provider, Provider<SessionManager> provider2) {
        this.userAPIProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<ModifyBodyActivity> create(Provider<UserAPI> provider, Provider<SessionManager> provider2) {
        return new ModifyBodyActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(ModifyBodyActivity modifyBodyActivity) {
        injectUserAPI(modifyBodyActivity, (UserAPI) this.userAPIProvider.get());
        injectSessionManager(modifyBodyActivity, (SessionManager) this.sessionManagerProvider.get());
    }

    public static void injectUserAPI(ModifyBodyActivity modifyBodyActivity, UserAPI userAPI) {
        modifyBodyActivity.userAPI = userAPI;
    }

    public static void injectSessionManager(ModifyBodyActivity modifyBodyActivity, SessionManager sessionManager) {
        modifyBodyActivity.sessionManager = sessionManager;
    }
}
