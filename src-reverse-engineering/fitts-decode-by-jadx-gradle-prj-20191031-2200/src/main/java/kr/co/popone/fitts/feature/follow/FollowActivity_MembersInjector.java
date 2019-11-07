package kr.co.popone.fitts.feature.follow;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.user.UserAPI;

public final class FollowActivity_MembersInjector implements MembersInjector<FollowActivity> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public FollowActivity_MembersInjector(Provider<UserAPI> provider, Provider<SessionManager> provider2, Provider<EventTracker> provider3) {
        this.userAPIProvider = provider;
        this.sessionManagerProvider = provider2;
        this.eventTrackerProvider = provider3;
    }

    public static MembersInjector<FollowActivity> create(Provider<UserAPI> provider, Provider<SessionManager> provider2, Provider<EventTracker> provider3) {
        return new FollowActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(FollowActivity followActivity) {
        injectUserAPI(followActivity, (UserAPI) this.userAPIProvider.get());
        injectSessionManager(followActivity, (SessionManager) this.sessionManagerProvider.get());
        injectEventTracker(followActivity, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectUserAPI(FollowActivity followActivity, UserAPI userAPI) {
        followActivity.userAPI = userAPI;
    }

    public static void injectSessionManager(FollowActivity followActivity, SessionManager sessionManager) {
        followActivity.sessionManager = sessionManager;
    }

    public static void injectEventTracker(FollowActivity followActivity, EventTracker eventTracker) {
        followActivity.eventTracker = eventTracker;
    }
}
