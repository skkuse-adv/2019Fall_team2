package kr.co.popone.fitts.feature.collection;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class PostCollectionActivity_MembersInjector implements MembersInjector<PostCollectionActivity> {
    private final Provider<ActionLogAPI> actionLogAPIProvider;
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<CollectionAPI> collectionAPIProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;

    public PostCollectionActivity_MembersInjector(Provider<CollectionAPI> provider, Provider<FittsSchemeHandler> provider2, Provider<EventTracker> provider3, Provider<ActionLogUtil> provider4, Provider<ActionLogAPI> provider5) {
        this.collectionAPIProvider = provider;
        this.schemeHandlerProvider = provider2;
        this.eventTrackerProvider = provider3;
        this.actionLogUtilProvider = provider4;
        this.actionLogAPIProvider = provider5;
    }

    public static MembersInjector<PostCollectionActivity> create(Provider<CollectionAPI> provider, Provider<FittsSchemeHandler> provider2, Provider<EventTracker> provider3, Provider<ActionLogUtil> provider4, Provider<ActionLogAPI> provider5) {
        PostCollectionActivity_MembersInjector postCollectionActivity_MembersInjector = new PostCollectionActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
        return postCollectionActivity_MembersInjector;
    }

    public void injectMembers(PostCollectionActivity postCollectionActivity) {
        injectCollectionAPI(postCollectionActivity, (CollectionAPI) this.collectionAPIProvider.get());
        injectSchemeHandler(postCollectionActivity, (FittsSchemeHandler) this.schemeHandlerProvider.get());
        injectEventTracker(postCollectionActivity, (EventTracker) this.eventTrackerProvider.get());
        injectActionLogUtil(postCollectionActivity, (ActionLogUtil) this.actionLogUtilProvider.get());
        injectActionLogAPI(postCollectionActivity, (ActionLogAPI) this.actionLogAPIProvider.get());
    }

    public static void injectCollectionAPI(PostCollectionActivity postCollectionActivity, CollectionAPI collectionAPI) {
        postCollectionActivity.collectionAPI = collectionAPI;
    }

    public static void injectSchemeHandler(PostCollectionActivity postCollectionActivity, FittsSchemeHandler fittsSchemeHandler) {
        postCollectionActivity.schemeHandler = fittsSchemeHandler;
    }

    public static void injectEventTracker(PostCollectionActivity postCollectionActivity, EventTracker eventTracker) {
        postCollectionActivity.eventTracker = eventTracker;
    }

    public static void injectActionLogUtil(PostCollectionActivity postCollectionActivity, ActionLogUtil actionLogUtil) {
        postCollectionActivity.actionLogUtil = actionLogUtil;
    }

    public static void injectActionLogAPI(PostCollectionActivity postCollectionActivity, ActionLogAPI actionLogAPI) {
        postCollectionActivity.actionLogAPI = actionLogAPI;
    }
}
