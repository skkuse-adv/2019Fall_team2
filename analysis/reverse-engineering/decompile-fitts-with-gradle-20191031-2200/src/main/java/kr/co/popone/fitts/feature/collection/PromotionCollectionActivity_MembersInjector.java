package kr.co.popone.fitts.feature.collection;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class PromotionCollectionActivity_MembersInjector implements MembersInjector<PromotionCollectionActivity> {
    private final Provider<ActionLogAPI> actionLogAPIProvider;
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<CollectionAPI> collectionAPIProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<PostAPI> postAPIProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public PromotionCollectionActivity_MembersInjector(Provider<PostAPI> provider, Provider<CollectionAPI> provider2, Provider<FittsSchemeHandler> provider3, Provider<SessionManager> provider4, Provider<EventTracker> provider5, Provider<ActionLogUtil> provider6, Provider<ActionLogAPI> provider7, Provider<UserAPI> provider8) {
        this.postAPIProvider = provider;
        this.collectionAPIProvider = provider2;
        this.schemeHandlerProvider = provider3;
        this.sessionManagerProvider = provider4;
        this.eventTrackerProvider = provider5;
        this.actionLogUtilProvider = provider6;
        this.actionLogAPIProvider = provider7;
        this.userAPIProvider = provider8;
    }

    public static MembersInjector<PromotionCollectionActivity> create(Provider<PostAPI> provider, Provider<CollectionAPI> provider2, Provider<FittsSchemeHandler> provider3, Provider<SessionManager> provider4, Provider<EventTracker> provider5, Provider<ActionLogUtil> provider6, Provider<ActionLogAPI> provider7, Provider<UserAPI> provider8) {
        PromotionCollectionActivity_MembersInjector promotionCollectionActivity_MembersInjector = new PromotionCollectionActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
        return promotionCollectionActivity_MembersInjector;
    }

    public void injectMembers(PromotionCollectionActivity promotionCollectionActivity) {
        injectPostAPI(promotionCollectionActivity, (PostAPI) this.postAPIProvider.get());
        injectCollectionAPI(promotionCollectionActivity, (CollectionAPI) this.collectionAPIProvider.get());
        injectSchemeHandler(promotionCollectionActivity, (FittsSchemeHandler) this.schemeHandlerProvider.get());
        injectSessionManager(promotionCollectionActivity, (SessionManager) this.sessionManagerProvider.get());
        injectEventTracker(promotionCollectionActivity, (EventTracker) this.eventTrackerProvider.get());
        injectActionLogUtil(promotionCollectionActivity, (ActionLogUtil) this.actionLogUtilProvider.get());
        injectActionLogAPI(promotionCollectionActivity, (ActionLogAPI) this.actionLogAPIProvider.get());
        injectUserAPI(promotionCollectionActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectPostAPI(PromotionCollectionActivity promotionCollectionActivity, PostAPI postAPI) {
        promotionCollectionActivity.postAPI = postAPI;
    }

    public static void injectCollectionAPI(PromotionCollectionActivity promotionCollectionActivity, CollectionAPI collectionAPI) {
        promotionCollectionActivity.collectionAPI = collectionAPI;
    }

    public static void injectSchemeHandler(PromotionCollectionActivity promotionCollectionActivity, FittsSchemeHandler fittsSchemeHandler) {
        promotionCollectionActivity.schemeHandler = fittsSchemeHandler;
    }

    public static void injectSessionManager(PromotionCollectionActivity promotionCollectionActivity, SessionManager sessionManager) {
        promotionCollectionActivity.sessionManager = sessionManager;
    }

    public static void injectEventTracker(PromotionCollectionActivity promotionCollectionActivity, EventTracker eventTracker) {
        promotionCollectionActivity.eventTracker = eventTracker;
    }

    public static void injectActionLogUtil(PromotionCollectionActivity promotionCollectionActivity, ActionLogUtil actionLogUtil) {
        promotionCollectionActivity.actionLogUtil = actionLogUtil;
    }

    public static void injectActionLogAPI(PromotionCollectionActivity promotionCollectionActivity, ActionLogAPI actionLogAPI) {
        promotionCollectionActivity.actionLogAPI = actionLogAPI;
    }

    public static void injectUserAPI(PromotionCollectionActivity promotionCollectionActivity, UserAPI userAPI) {
        promotionCollectionActivity.userAPI = userAPI;
    }
}
