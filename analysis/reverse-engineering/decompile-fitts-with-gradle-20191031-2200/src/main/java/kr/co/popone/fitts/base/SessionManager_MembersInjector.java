package kr.co.popone.fitts.base;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class SessionManager_MembersInjector implements MembersInjector<SessionManager> {
    private final Provider<UserAPI> userAPIProvider;

    public SessionManager_MembersInjector(Provider<UserAPI> provider) {
        this.userAPIProvider = provider;
    }

    public static MembersInjector<SessionManager> create(Provider<UserAPI> provider) {
        return new SessionManager_MembersInjector(provider);
    }

    public void injectMembers(SessionManager sessionManager) {
        injectUserAPI(sessionManager, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectUserAPI(SessionManager sessionManager, UserAPI userAPI) {
        sessionManager.userAPI = userAPI;
    }
}
