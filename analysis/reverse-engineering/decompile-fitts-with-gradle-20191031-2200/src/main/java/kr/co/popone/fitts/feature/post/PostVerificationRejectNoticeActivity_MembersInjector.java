package kr.co.popone.fitts.feature.post;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class PostVerificationRejectNoticeActivity_MembersInjector implements MembersInjector<PostVerificationRejectNoticeActivity> {
    private final Provider<UserAPI> userAPIProvider;

    public PostVerificationRejectNoticeActivity_MembersInjector(Provider<UserAPI> provider) {
        this.userAPIProvider = provider;
    }

    public static MembersInjector<PostVerificationRejectNoticeActivity> create(Provider<UserAPI> provider) {
        return new PostVerificationRejectNoticeActivity_MembersInjector(provider);
    }

    public void injectMembers(PostVerificationRejectNoticeActivity postVerificationRejectNoticeActivity) {
        injectUserAPI(postVerificationRejectNoticeActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectUserAPI(PostVerificationRejectNoticeActivity postVerificationRejectNoticeActivity, UserAPI userAPI) {
        postVerificationRejectNoticeActivity.userAPI = userAPI;
    }
}
