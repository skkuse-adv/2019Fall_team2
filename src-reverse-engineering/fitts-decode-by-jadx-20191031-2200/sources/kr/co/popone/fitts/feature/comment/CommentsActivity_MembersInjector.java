package kr.co.popone.fitts.feature.comment;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.post.PostAPI;

public final class CommentsActivity_MembersInjector implements MembersInjector<CommentsActivity> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<SessionManager> sessionManagerProvider;

    public CommentsActivity_MembersInjector(Provider<EventTracker> provider, Provider<SessionManager> provider2, Provider<PostAPI> provider3) {
        this.eventTrackerProvider = provider;
        this.sessionManagerProvider = provider2;
        this.postAPIProvider = provider3;
    }

    public static MembersInjector<CommentsActivity> create(Provider<EventTracker> provider, Provider<SessionManager> provider2, Provider<PostAPI> provider3) {
        return new CommentsActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CommentsActivity commentsActivity) {
        injectEventTracker(commentsActivity, (EventTracker) this.eventTrackerProvider.get());
        injectSessionManager(commentsActivity, (SessionManager) this.sessionManagerProvider.get());
        injectPostAPI(commentsActivity, (PostAPI) this.postAPIProvider.get());
    }

    public static void injectEventTracker(CommentsActivity commentsActivity, EventTracker eventTracker) {
        commentsActivity.eventTracker = eventTracker;
    }

    public static void injectSessionManager(CommentsActivity commentsActivity, SessionManager sessionManager) {
        commentsActivity.sessionManager = sessionManager;
    }

    public static void injectPostAPI(CommentsActivity commentsActivity, PostAPI postAPI) {
        commentsActivity.postAPI = postAPI;
    }
}
