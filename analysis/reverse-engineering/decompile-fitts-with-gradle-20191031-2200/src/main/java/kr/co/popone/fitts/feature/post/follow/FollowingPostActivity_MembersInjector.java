package kr.co.popone.fitts.feature.post.follow;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.home.follow.FollowingPostViewModel;

public final class FollowingPostActivity_MembersInjector implements MembersInjector<FollowingPostActivity> {
    private final Provider<FollowingPostViewModel> viewModelProvider;

    public FollowingPostActivity_MembersInjector(Provider<FollowingPostViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<FollowingPostActivity> create(Provider<FollowingPostViewModel> provider) {
        return new FollowingPostActivity_MembersInjector(provider);
    }

    public void injectMembers(FollowingPostActivity followingPostActivity) {
        injectViewModel(followingPostActivity, (FollowingPostViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(FollowingPostActivity followingPostActivity, FollowingPostViewModel followingPostViewModel) {
        followingPostActivity.viewModel = followingPostViewModel;
    }
}
