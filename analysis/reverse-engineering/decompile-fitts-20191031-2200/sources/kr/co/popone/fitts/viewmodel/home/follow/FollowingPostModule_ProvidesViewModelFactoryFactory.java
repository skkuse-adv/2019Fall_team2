package kr.co.popone.fitts.viewmodel.home.follow;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.PostRepository;

public final class FollowingPostModule_ProvidesViewModelFactoryFactory implements Factory<FollowingPostViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final FollowingPostModule module;
    private final Provider<PostRepository> postRepositoryProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public FollowingPostModule_ProvidesViewModelFactoryFactory(FollowingPostModule followingPostModule, Provider<UserAPI> provider, Provider<PostRepository> provider2, Provider<EventTracker> provider3, Provider<SessionManager> provider4) {
        this.module = followingPostModule;
        this.userAPIProvider = provider;
        this.postRepositoryProvider = provider2;
        this.eventTrackerProvider = provider3;
        this.sessionManagerProvider = provider4;
    }

    public FollowingPostViewModelFactory get() {
        return provideInstance(this.module, this.userAPIProvider, this.postRepositoryProvider, this.eventTrackerProvider, this.sessionManagerProvider);
    }

    public static FollowingPostViewModelFactory provideInstance(FollowingPostModule followingPostModule, Provider<UserAPI> provider, Provider<PostRepository> provider2, Provider<EventTracker> provider3, Provider<SessionManager> provider4) {
        return proxyProvidesViewModelFactory(followingPostModule, (UserAPI) provider.get(), (PostRepository) provider2.get(), (EventTracker) provider3.get(), (SessionManager) provider4.get());
    }

    public static FollowingPostModule_ProvidesViewModelFactoryFactory create(FollowingPostModule followingPostModule, Provider<UserAPI> provider, Provider<PostRepository> provider2, Provider<EventTracker> provider3, Provider<SessionManager> provider4) {
        FollowingPostModule_ProvidesViewModelFactoryFactory followingPostModule_ProvidesViewModelFactoryFactory = new FollowingPostModule_ProvidesViewModelFactoryFactory(followingPostModule, provider, provider2, provider3, provider4);
        return followingPostModule_ProvidesViewModelFactoryFactory;
    }

    public static FollowingPostViewModelFactory proxyProvidesViewModelFactory(FollowingPostModule followingPostModule, UserAPI userAPI, PostRepository postRepository, EventTracker eventTracker, SessionManager sessionManager) {
        return (FollowingPostViewModelFactory) Preconditions.checkNotNull(followingPostModule.providesViewModelFactory(userAPI, postRepository, eventTracker, sessionManager), "Cannot return null from a non-@Nullable @Provides method");
    }
}
