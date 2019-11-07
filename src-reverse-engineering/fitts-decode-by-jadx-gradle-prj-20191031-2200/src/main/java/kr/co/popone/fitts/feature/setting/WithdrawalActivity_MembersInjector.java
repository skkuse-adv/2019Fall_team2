package kr.co.popone.fitts.feature.setting;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;

public final class WithdrawalActivity_MembersInjector implements MembersInjector<WithdrawalActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public WithdrawalActivity_MembersInjector(Provider<UserAPI> provider, Provider<SessionManager> provider2) {
        this.userAPIProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<WithdrawalActivity> create(Provider<UserAPI> provider, Provider<SessionManager> provider2) {
        return new WithdrawalActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(WithdrawalActivity withdrawalActivity) {
        injectUserAPI(withdrawalActivity, (UserAPI) this.userAPIProvider.get());
        injectSessionManager(withdrawalActivity, (SessionManager) this.sessionManagerProvider.get());
    }

    public static void injectUserAPI(WithdrawalActivity withdrawalActivity, UserAPI userAPI) {
        withdrawalActivity.userAPI = userAPI;
    }

    public static void injectSessionManager(WithdrawalActivity withdrawalActivity, SessionManager sessionManager) {
        withdrawalActivity.sessionManager = sessionManager;
    }
}
