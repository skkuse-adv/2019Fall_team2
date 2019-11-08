package kr.co.popone.fitts.feature.showroom;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class ShowRoomActivity_MembersInjector implements MembersInjector<ShowRoomActivity> {
    private final Provider<ActionLogAPI> actionLogAPIProvider;
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<CreatePostActivityUtil> createPostActivityUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public ShowRoomActivity_MembersInjector(Provider<UserAPI> provider, Provider<PostAPI> provider2, Provider<EventTracker> provider3, Provider<SessionManager> provider4, Provider<CreatePostActivityUtil> provider5, Provider<ActionLogUtil> provider6, Provider<ActionLogAPI> provider7) {
        this.userAPIProvider = provider;
        this.postAPIProvider = provider2;
        this.eventTrackerProvider = provider3;
        this.sessionManagerProvider = provider4;
        this.createPostActivityUtilProvider = provider5;
        this.actionLogUtilProvider = provider6;
        this.actionLogAPIProvider = provider7;
    }

    public static MembersInjector<ShowRoomActivity> create(Provider<UserAPI> provider, Provider<PostAPI> provider2, Provider<EventTracker> provider3, Provider<SessionManager> provider4, Provider<CreatePostActivityUtil> provider5, Provider<ActionLogUtil> provider6, Provider<ActionLogAPI> provider7) {
        ShowRoomActivity_MembersInjector showRoomActivity_MembersInjector = new ShowRoomActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
        return showRoomActivity_MembersInjector;
    }

    public void injectMembers(ShowRoomActivity showRoomActivity) {
        injectUserAPI(showRoomActivity, (UserAPI) this.userAPIProvider.get());
        injectPostAPI(showRoomActivity, (PostAPI) this.postAPIProvider.get());
        injectEventTracker(showRoomActivity, (EventTracker) this.eventTrackerProvider.get());
        injectSessionManager(showRoomActivity, (SessionManager) this.sessionManagerProvider.get());
        injectCreatePostActivityUtil(showRoomActivity, (CreatePostActivityUtil) this.createPostActivityUtilProvider.get());
        injectActionLogUtil(showRoomActivity, (ActionLogUtil) this.actionLogUtilProvider.get());
        injectActionLogAPI(showRoomActivity, (ActionLogAPI) this.actionLogAPIProvider.get());
    }

    public static void injectUserAPI(ShowRoomActivity showRoomActivity, UserAPI userAPI) {
        showRoomActivity.userAPI = userAPI;
    }

    public static void injectPostAPI(ShowRoomActivity showRoomActivity, PostAPI postAPI) {
        showRoomActivity.postAPI = postAPI;
    }

    public static void injectEventTracker(ShowRoomActivity showRoomActivity, EventTracker eventTracker) {
        showRoomActivity.eventTracker = eventTracker;
    }

    public static void injectSessionManager(ShowRoomActivity showRoomActivity, SessionManager sessionManager) {
        showRoomActivity.sessionManager = sessionManager;
    }

    public static void injectCreatePostActivityUtil(ShowRoomActivity showRoomActivity, CreatePostActivityUtil createPostActivityUtil) {
        showRoomActivity.createPostActivityUtil = createPostActivityUtil;
    }

    public static void injectActionLogUtil(ShowRoomActivity showRoomActivity, ActionLogUtil actionLogUtil) {
        showRoomActivity.actionLogUtil = actionLogUtil;
    }

    public static void injectActionLogAPI(ShowRoomActivity showRoomActivity, ActionLogAPI actionLogAPI) {
        showRoomActivity.actionLogAPI = actionLogAPI;
    }
}
