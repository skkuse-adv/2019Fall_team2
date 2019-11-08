package kr.co.popone.fitts.feature.home;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.user.UserAPI;

public final class WelcomeActivity_MembersInjector implements MembersInjector<WelcomeActivity> {
    private final Provider<CreatePostActivityUtil> createPostActivityUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public WelcomeActivity_MembersInjector(Provider<SessionManager> provider, Provider<UserAPI> provider2, Provider<EventTracker> provider3, Provider<CreatePostActivityUtil> provider4) {
        this.sessionManagerProvider = provider;
        this.userAPIProvider = provider2;
        this.eventTrackerProvider = provider3;
        this.createPostActivityUtilProvider = provider4;
    }

    public static MembersInjector<WelcomeActivity> create(Provider<SessionManager> provider, Provider<UserAPI> provider2, Provider<EventTracker> provider3, Provider<CreatePostActivityUtil> provider4) {
        return new WelcomeActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(WelcomeActivity welcomeActivity) {
        injectSessionManager(welcomeActivity, (SessionManager) this.sessionManagerProvider.get());
        injectUserAPI(welcomeActivity, (UserAPI) this.userAPIProvider.get());
        injectEventTracker(welcomeActivity, (EventTracker) this.eventTrackerProvider.get());
        injectCreatePostActivityUtil(welcomeActivity, (CreatePostActivityUtil) this.createPostActivityUtilProvider.get());
    }

    public static void injectSessionManager(WelcomeActivity welcomeActivity, SessionManager sessionManager) {
        welcomeActivity.sessionManager = sessionManager;
    }

    public static void injectUserAPI(WelcomeActivity welcomeActivity, UserAPI userAPI) {
        welcomeActivity.userAPI = userAPI;
    }

    public static void injectEventTracker(WelcomeActivity welcomeActivity, EventTracker eventTracker) {
        welcomeActivity.eventTracker = eventTracker;
    }

    public static void injectCreatePostActivityUtil(WelcomeActivity welcomeActivity, CreatePostActivityUtil createPostActivityUtil) {
        welcomeActivity.createPostActivityUtil = createPostActivityUtil;
    }
}
