package kr.co.popone.fitts.feature.reward;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.user.UserAPI;

public final class RewardPointUseActivity_MembersInjector implements MembersInjector<RewardPointUseActivity> {
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<UserAPI> userAPIProvider;

    public RewardPointUseActivity_MembersInjector(Provider<UserAPI> provider, Provider<PostAPI> provider2) {
        this.userAPIProvider = provider;
        this.postAPIProvider = provider2;
    }

    public static MembersInjector<RewardPointUseActivity> create(Provider<UserAPI> provider, Provider<PostAPI> provider2) {
        return new RewardPointUseActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(RewardPointUseActivity rewardPointUseActivity) {
        injectUserAPI(rewardPointUseActivity, (UserAPI) this.userAPIProvider.get());
        injectPostAPI(rewardPointUseActivity, (PostAPI) this.postAPIProvider.get());
    }

    public static void injectUserAPI(RewardPointUseActivity rewardPointUseActivity, UserAPI userAPI) {
        rewardPointUseActivity.userAPI = userAPI;
    }

    public static void injectPostAPI(RewardPointUseActivity rewardPointUseActivity, PostAPI postAPI) {
        rewardPointUseActivity.postAPI = postAPI;
    }
}
