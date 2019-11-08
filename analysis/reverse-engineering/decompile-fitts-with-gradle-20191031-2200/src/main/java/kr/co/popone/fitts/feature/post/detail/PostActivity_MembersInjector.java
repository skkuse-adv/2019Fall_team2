package kr.co.popone.fitts.feature.post.detail;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class PostActivity_MembersInjector implements MembersInjector<PostActivity> {
    private final Provider<ActionLogAPI> actionLogAPIProvider;
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<CreatePostActivityUtil> createPostActivityUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<StoreRepository> storeRepositoryProvider;
    private final Provider<UserAPI> userAPIProvider;

    public PostActivity_MembersInjector(Provider<EventTracker> provider, Provider<SessionManager> provider2, Provider<CreatePostActivityUtil> provider3, Provider<ActionLogUtil> provider4, Provider<ActionLogAPI> provider5, Provider<StoreRepository> provider6, Provider<FittsServiceRepository> provider7, Provider<PostAPI> provider8, Provider<UserAPI> provider9) {
        this.eventTrackerProvider = provider;
        this.sessionManagerProvider = provider2;
        this.createPostActivityUtilProvider = provider3;
        this.actionLogUtilProvider = provider4;
        this.actionLogAPIProvider = provider5;
        this.storeRepositoryProvider = provider6;
        this.serviceRepositoryProvider = provider7;
        this.postAPIProvider = provider8;
        this.userAPIProvider = provider9;
    }

    public static MembersInjector<PostActivity> create(Provider<EventTracker> provider, Provider<SessionManager> provider2, Provider<CreatePostActivityUtil> provider3, Provider<ActionLogUtil> provider4, Provider<ActionLogAPI> provider5, Provider<StoreRepository> provider6, Provider<FittsServiceRepository> provider7, Provider<PostAPI> provider8, Provider<UserAPI> provider9) {
        PostActivity_MembersInjector postActivity_MembersInjector = new PostActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
        return postActivity_MembersInjector;
    }

    public void injectMembers(PostActivity postActivity) {
        injectEventTracker(postActivity, (EventTracker) this.eventTrackerProvider.get());
        injectSessionManager(postActivity, (SessionManager) this.sessionManagerProvider.get());
        injectCreatePostActivityUtil(postActivity, (CreatePostActivityUtil) this.createPostActivityUtilProvider.get());
        injectActionLogUtil(postActivity, (ActionLogUtil) this.actionLogUtilProvider.get());
        injectActionLogAPI(postActivity, (ActionLogAPI) this.actionLogAPIProvider.get());
        injectStoreRepository(postActivity, (StoreRepository) this.storeRepositoryProvider.get());
        injectServiceRepository(postActivity, (FittsServiceRepository) this.serviceRepositoryProvider.get());
        injectPostAPI(postActivity, (PostAPI) this.postAPIProvider.get());
        injectUserAPI(postActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectEventTracker(PostActivity postActivity, EventTracker eventTracker) {
        postActivity.eventTracker = eventTracker;
    }

    public static void injectSessionManager(PostActivity postActivity, SessionManager sessionManager) {
        postActivity.sessionManager = sessionManager;
    }

    public static void injectCreatePostActivityUtil(PostActivity postActivity, CreatePostActivityUtil createPostActivityUtil) {
        postActivity.createPostActivityUtil = createPostActivityUtil;
    }

    public static void injectActionLogUtil(PostActivity postActivity, ActionLogUtil actionLogUtil) {
        postActivity.actionLogUtil = actionLogUtil;
    }

    public static void injectActionLogAPI(PostActivity postActivity, ActionLogAPI actionLogAPI) {
        postActivity.actionLogAPI = actionLogAPI;
    }

    public static void injectStoreRepository(PostActivity postActivity, StoreRepository storeRepository) {
        postActivity.storeRepository = storeRepository;
    }

    public static void injectServiceRepository(PostActivity postActivity, FittsServiceRepository fittsServiceRepository) {
        postActivity.serviceRepository = fittsServiceRepository;
    }

    public static void injectPostAPI(PostActivity postActivity, PostAPI postAPI) {
        postActivity.postAPI = postAPI;
    }

    public static void injectUserAPI(PostActivity postActivity, UserAPI userAPI) {
        postActivity.userAPI = userAPI;
    }
}
