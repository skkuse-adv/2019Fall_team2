package kr.co.popone.fitts.feature.post;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.user.UserAPI;

public final class ProfileInputActivity_MembersInjector implements MembersInjector<ProfileInputActivity> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public ProfileInputActivity_MembersInjector(Provider<UserAPI> provider, Provider<PostAPI> provider2, Provider<SessionManager> provider3, Provider<EventTracker> provider4) {
        this.userAPIProvider = provider;
        this.postAPIProvider = provider2;
        this.sessionManagerProvider = provider3;
        this.eventTrackerProvider = provider4;
    }

    public static MembersInjector<ProfileInputActivity> create(Provider<UserAPI> provider, Provider<PostAPI> provider2, Provider<SessionManager> provider3, Provider<EventTracker> provider4) {
        return new ProfileInputActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(ProfileInputActivity profileInputActivity) {
        injectUserAPI(profileInputActivity, (UserAPI) this.userAPIProvider.get());
        injectPostAPI(profileInputActivity, (PostAPI) this.postAPIProvider.get());
        injectSessionManager(profileInputActivity, (SessionManager) this.sessionManagerProvider.get());
        injectEventTracker(profileInputActivity, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectUserAPI(ProfileInputActivity profileInputActivity, UserAPI userAPI) {
        profileInputActivity.userAPI = userAPI;
    }

    public static void injectPostAPI(ProfileInputActivity profileInputActivity, PostAPI postAPI) {
        profileInputActivity.postAPI = postAPI;
    }

    public static void injectSessionManager(ProfileInputActivity profileInputActivity, SessionManager sessionManager) {
        profileInputActivity.sessionManager = sessionManager;
    }

    public static void injectEventTracker(ProfileInputActivity profileInputActivity, EventTracker eventTracker) {
        profileInputActivity.eventTracker = eventTracker;
    }
}
