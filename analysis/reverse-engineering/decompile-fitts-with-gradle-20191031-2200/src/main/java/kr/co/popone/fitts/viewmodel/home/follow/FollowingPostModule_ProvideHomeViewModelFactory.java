package kr.co.popone.fitts.viewmodel.home.follow;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.post.follow.FollowingPostActivity;

public final class FollowingPostModule_ProvideHomeViewModelFactory implements Factory<FollowingPostViewModel> {
    private final Provider<FollowingPostActivity> activityProvider;
    private final FollowingPostModule module;
    private final Provider<FollowingPostViewModelFactory> viewModelFactoryProvider;

    public FollowingPostModule_ProvideHomeViewModelFactory(FollowingPostModule followingPostModule, Provider<FollowingPostActivity> provider, Provider<FollowingPostViewModelFactory> provider2) {
        this.module = followingPostModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public FollowingPostViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static FollowingPostViewModel provideInstance(FollowingPostModule followingPostModule, Provider<FollowingPostActivity> provider, Provider<FollowingPostViewModelFactory> provider2) {
        return proxyProvideHomeViewModel(followingPostModule, (FollowingPostActivity) provider.get(), (FollowingPostViewModelFactory) provider2.get());
    }

    public static FollowingPostModule_ProvideHomeViewModelFactory create(FollowingPostModule followingPostModule, Provider<FollowingPostActivity> provider, Provider<FollowingPostViewModelFactory> provider2) {
        return new FollowingPostModule_ProvideHomeViewModelFactory(followingPostModule, provider, provider2);
    }

    public static FollowingPostViewModel proxyProvideHomeViewModel(FollowingPostModule followingPostModule, FollowingPostActivity followingPostActivity, FollowingPostViewModelFactory followingPostViewModelFactory) {
        return (FollowingPostViewModel) Preconditions.checkNotNull(followingPostModule.provideHomeViewModel(followingPostActivity, followingPostViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
