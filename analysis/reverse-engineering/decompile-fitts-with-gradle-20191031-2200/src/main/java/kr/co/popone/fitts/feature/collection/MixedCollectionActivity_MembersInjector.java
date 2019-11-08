package kr.co.popone.fitts.feature.collection;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.collection.CollectionAPI;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class MixedCollectionActivity_MembersInjector implements MembersInjector<MixedCollectionActivity> {
    private final Provider<ActionLogAPI> actionLogAPIProvider;
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<CollectionAPI> collectionAPIProvider;
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public MixedCollectionActivity_MembersInjector(Provider<FittsSchemeHandler> provider, Provider<CollectionAPI> provider2, Provider<UserAPI> provider3, Provider<ActionLogUtil> provider4, Provider<ActionLogAPI> provider5, Provider<EventTracker> provider6, Provider<FittsCommerceRepository> provider7) {
        this.schemeHandlerProvider = provider;
        this.collectionAPIProvider = provider2;
        this.userAPIProvider = provider3;
        this.actionLogUtilProvider = provider4;
        this.actionLogAPIProvider = provider5;
        this.eventTrackerProvider = provider6;
        this.commerceRepositoryProvider = provider7;
    }

    public static MembersInjector<MixedCollectionActivity> create(Provider<FittsSchemeHandler> provider, Provider<CollectionAPI> provider2, Provider<UserAPI> provider3, Provider<ActionLogUtil> provider4, Provider<ActionLogAPI> provider5, Provider<EventTracker> provider6, Provider<FittsCommerceRepository> provider7) {
        MixedCollectionActivity_MembersInjector mixedCollectionActivity_MembersInjector = new MixedCollectionActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
        return mixedCollectionActivity_MembersInjector;
    }

    public void injectMembers(MixedCollectionActivity mixedCollectionActivity) {
        injectSchemeHandler(mixedCollectionActivity, (FittsSchemeHandler) this.schemeHandlerProvider.get());
        injectCollectionAPI(mixedCollectionActivity, (CollectionAPI) this.collectionAPIProvider.get());
        injectUserAPI(mixedCollectionActivity, (UserAPI) this.userAPIProvider.get());
        injectActionLogUtil(mixedCollectionActivity, (ActionLogUtil) this.actionLogUtilProvider.get());
        injectActionLogAPI(mixedCollectionActivity, (ActionLogAPI) this.actionLogAPIProvider.get());
        injectEventTracker(mixedCollectionActivity, (EventTracker) this.eventTrackerProvider.get());
        injectCommerceRepository(mixedCollectionActivity, (FittsCommerceRepository) this.commerceRepositoryProvider.get());
    }

    public static void injectSchemeHandler(MixedCollectionActivity mixedCollectionActivity, FittsSchemeHandler fittsSchemeHandler) {
        mixedCollectionActivity.schemeHandler = fittsSchemeHandler;
    }

    public static void injectCollectionAPI(MixedCollectionActivity mixedCollectionActivity, CollectionAPI collectionAPI) {
        mixedCollectionActivity.collectionAPI = collectionAPI;
    }

    public static void injectUserAPI(MixedCollectionActivity mixedCollectionActivity, UserAPI userAPI) {
        mixedCollectionActivity.userAPI = userAPI;
    }

    public static void injectActionLogUtil(MixedCollectionActivity mixedCollectionActivity, ActionLogUtil actionLogUtil) {
        mixedCollectionActivity.actionLogUtil = actionLogUtil;
    }

    public static void injectActionLogAPI(MixedCollectionActivity mixedCollectionActivity, ActionLogAPI actionLogAPI) {
        mixedCollectionActivity.actionLogAPI = actionLogAPI;
    }

    public static void injectEventTracker(MixedCollectionActivity mixedCollectionActivity, EventTracker eventTracker) {
        mixedCollectionActivity.eventTracker = eventTracker;
    }

    public static void injectCommerceRepository(MixedCollectionActivity mixedCollectionActivity, FittsCommerceRepository fittsCommerceRepository) {
        mixedCollectionActivity.commerceRepository = fittsCommerceRepository;
    }
}
