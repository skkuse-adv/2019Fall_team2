package kr.co.popone.fitts.feature.post.upload.preview;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.user.UserAPI;

public final class PostPreviewActivity_MembersInjector implements MembersInjector<PostPreviewActivity> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public PostPreviewActivity_MembersInjector(Provider<SessionManager> provider, Provider<PostAPI> provider2, Provider<UserAPI> provider3, Provider<EventTracker> provider4) {
        this.sessionManagerProvider = provider;
        this.postAPIProvider = provider2;
        this.userAPIProvider = provider3;
        this.eventTrackerProvider = provider4;
    }

    public static MembersInjector<PostPreviewActivity> create(Provider<SessionManager> provider, Provider<PostAPI> provider2, Provider<UserAPI> provider3, Provider<EventTracker> provider4) {
        return new PostPreviewActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(PostPreviewActivity postPreviewActivity) {
        injectSessionManager(postPreviewActivity, (SessionManager) this.sessionManagerProvider.get());
        injectPostAPI(postPreviewActivity, (PostAPI) this.postAPIProvider.get());
        injectUserAPI(postPreviewActivity, (UserAPI) this.userAPIProvider.get());
        injectEventTracker(postPreviewActivity, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectSessionManager(PostPreviewActivity postPreviewActivity, SessionManager sessionManager) {
        postPreviewActivity.sessionManager = sessionManager;
    }

    public static void injectPostAPI(PostPreviewActivity postPreviewActivity, PostAPI postAPI) {
        postPreviewActivity.postAPI = postAPI;
    }

    public static void injectUserAPI(PostPreviewActivity postPreviewActivity, UserAPI userAPI) {
        postPreviewActivity.userAPI = userAPI;
    }

    public static void injectEventTracker(PostPreviewActivity postPreviewActivity, EventTracker eventTracker) {
        postPreviewActivity.eventTracker = eventTracker;
    }
}
