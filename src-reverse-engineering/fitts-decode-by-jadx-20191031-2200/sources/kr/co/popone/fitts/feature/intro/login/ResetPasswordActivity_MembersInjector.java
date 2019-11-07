package kr.co.popone.fitts.feature.intro.login;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class ResetPasswordActivity_MembersInjector implements MembersInjector<ResetPasswordActivity> {
    private final Provider<UserAPI> userAPIProvider;

    public ResetPasswordActivity_MembersInjector(Provider<UserAPI> provider) {
        this.userAPIProvider = provider;
    }

    public static MembersInjector<ResetPasswordActivity> create(Provider<UserAPI> provider) {
        return new ResetPasswordActivity_MembersInjector(provider);
    }

    public void injectMembers(ResetPasswordActivity resetPasswordActivity) {
        injectUserAPI(resetPasswordActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectUserAPI(ResetPasswordActivity resetPasswordActivity, UserAPI userAPI) {
        resetPasswordActivity.userAPI = userAPI;
    }
}
