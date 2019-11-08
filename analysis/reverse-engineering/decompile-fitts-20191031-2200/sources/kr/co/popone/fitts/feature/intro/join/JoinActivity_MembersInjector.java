package kr.co.popone.fitts.feature.intro.join;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.user.UserAPI;

public final class JoinActivity_MembersInjector implements MembersInjector<JoinActivity> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public JoinActivity_MembersInjector(Provider<EventTracker> provider, Provider<SessionManager> provider2, Provider<UserAPI> provider3) {
        this.eventTrackerProvider = provider;
        this.sessionManagerProvider = provider2;
        this.userAPIProvider = provider3;
    }

    public static MembersInjector<JoinActivity> create(Provider<EventTracker> provider, Provider<SessionManager> provider2, Provider<UserAPI> provider3) {
        return new JoinActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(JoinActivity joinActivity) {
        injectEventTracker(joinActivity, (EventTracker) this.eventTrackerProvider.get());
        injectSessionManager(joinActivity, (SessionManager) this.sessionManagerProvider.get());
        injectUserAPI(joinActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectEventTracker(JoinActivity joinActivity, EventTracker eventTracker) {
        joinActivity.eventTracker = eventTracker;
    }

    public static void injectSessionManager(JoinActivity joinActivity, SessionManager sessionManager) {
        joinActivity.sessionManager = sessionManager;
    }

    public static void injectUserAPI(JoinActivity joinActivity, UserAPI userAPI) {
        joinActivity.userAPI = userAPI;
    }
}
