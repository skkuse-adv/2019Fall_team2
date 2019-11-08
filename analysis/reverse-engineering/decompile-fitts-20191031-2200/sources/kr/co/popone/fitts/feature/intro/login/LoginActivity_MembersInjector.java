package kr.co.popone.fitts.feature.intro.login;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;

public final class LoginActivity_MembersInjector implements MembersInjector<LoginActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public LoginActivity_MembersInjector(Provider<UserAPI> provider, Provider<SessionManager> provider2) {
        this.userAPIProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<LoginActivity> create(Provider<UserAPI> provider, Provider<SessionManager> provider2) {
        return new LoginActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(LoginActivity loginActivity) {
        injectUserAPI(loginActivity, (UserAPI) this.userAPIProvider.get());
        injectSessionManager(loginActivity, (SessionManager) this.sessionManagerProvider.get());
    }

    public static void injectUserAPI(LoginActivity loginActivity, UserAPI userAPI) {
        loginActivity.userAPI = userAPI;
    }

    public static void injectSessionManager(LoginActivity loginActivity, SessionManager sessionManager) {
        loginActivity.sessionManager = sessionManager;
    }
}
