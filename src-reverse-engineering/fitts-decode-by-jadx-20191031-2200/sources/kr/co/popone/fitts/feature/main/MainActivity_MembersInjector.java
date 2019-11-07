package kr.co.popone.fitts.feature.main;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.AppManager;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.search.SearchAPI;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.CategoryRepository;
import kr.co.popone.fitts.services.FittsNotificationHandler;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
    private final Provider<ActionLogAPI> actionLogAPIProvider;
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<AppManager> appManagerProvider;
    private final Provider<CategoryRepository> categoryRepositoryProvider;
    private final Provider<CreatePostActivityUtil> createPostActivityUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<FittsNotificationHandler> fittsNotificationHandlerProvider;
    private final Provider<FittsServiceRepository> fittsServiceRepositoryProvider;
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<SearchAPI> searchAPIProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userApiProvider;

    public MainActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<FittsNotificationHandler> provider2, Provider<FittsSchemeHandler> provider3, Provider<SessionManager> provider4, Provider<AppManager> provider5, Provider<EventTracker> provider6, Provider<SearchAPI> provider7, Provider<CreatePostActivityUtil> provider8, Provider<ActionLogUtil> provider9, Provider<CategoryRepository> provider10, Provider<FittsServiceRepository> provider11, Provider<UserAPI> provider12, Provider<ActionLogAPI> provider13) {
        this.fragmentInjectorProvider = provider;
        this.fittsNotificationHandlerProvider = provider2;
        this.schemeHandlerProvider = provider3;
        this.sessionManagerProvider = provider4;
        this.appManagerProvider = provider5;
        this.eventTrackerProvider = provider6;
        this.searchAPIProvider = provider7;
        this.createPostActivityUtilProvider = provider8;
        this.actionLogUtilProvider = provider9;
        this.categoryRepositoryProvider = provider10;
        this.fittsServiceRepositoryProvider = provider11;
        this.userApiProvider = provider12;
        this.actionLogAPIProvider = provider13;
    }

    public static MembersInjector<MainActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<FittsNotificationHandler> provider2, Provider<FittsSchemeHandler> provider3, Provider<SessionManager> provider4, Provider<AppManager> provider5, Provider<EventTracker> provider6, Provider<SearchAPI> provider7, Provider<CreatePostActivityUtil> provider8, Provider<ActionLogUtil> provider9, Provider<CategoryRepository> provider10, Provider<FittsServiceRepository> provider11, Provider<UserAPI> provider12, Provider<ActionLogAPI> provider13) {
        MainActivity_MembersInjector mainActivity_MembersInjector = new MainActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
        return mainActivity_MembersInjector;
    }

    public void injectMembers(MainActivity mainActivity) {
        injectFragmentInjector(mainActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
        injectFittsNotificationHandler(mainActivity, (FittsNotificationHandler) this.fittsNotificationHandlerProvider.get());
        injectSchemeHandler(mainActivity, (FittsSchemeHandler) this.schemeHandlerProvider.get());
        injectSessionManager(mainActivity, (SessionManager) this.sessionManagerProvider.get());
        injectAppManager(mainActivity, (AppManager) this.appManagerProvider.get());
        injectEventTracker(mainActivity, (EventTracker) this.eventTrackerProvider.get());
        injectSearchAPI(mainActivity, (SearchAPI) this.searchAPIProvider.get());
        injectCreatePostActivityUtil(mainActivity, (CreatePostActivityUtil) this.createPostActivityUtilProvider.get());
        injectActionLogUtil(mainActivity, (ActionLogUtil) this.actionLogUtilProvider.get());
        injectCategoryRepository(mainActivity, (CategoryRepository) this.categoryRepositoryProvider.get());
        injectFittsServiceRepository(mainActivity, (FittsServiceRepository) this.fittsServiceRepositoryProvider.get());
        injectUserApi(mainActivity, (UserAPI) this.userApiProvider.get());
        injectActionLogAPI(mainActivity, (ActionLogAPI) this.actionLogAPIProvider.get());
    }

    public static void injectFragmentInjector(MainActivity mainActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        mainActivity.fragmentInjector = dispatchingAndroidInjector;
    }

    public static void injectFittsNotificationHandler(MainActivity mainActivity, FittsNotificationHandler fittsNotificationHandler) {
        mainActivity.fittsNotificationHandler = fittsNotificationHandler;
    }

    public static void injectSchemeHandler(MainActivity mainActivity, FittsSchemeHandler fittsSchemeHandler) {
        mainActivity.schemeHandler = fittsSchemeHandler;
    }

    public static void injectSessionManager(MainActivity mainActivity, SessionManager sessionManager) {
        mainActivity.sessionManager = sessionManager;
    }

    public static void injectAppManager(MainActivity mainActivity, AppManager appManager) {
        mainActivity.appManager = appManager;
    }

    public static void injectEventTracker(MainActivity mainActivity, EventTracker eventTracker) {
        mainActivity.eventTracker = eventTracker;
    }

    public static void injectSearchAPI(MainActivity mainActivity, SearchAPI searchAPI) {
        mainActivity.searchAPI = searchAPI;
    }

    public static void injectCreatePostActivityUtil(MainActivity mainActivity, CreatePostActivityUtil createPostActivityUtil) {
        mainActivity.createPostActivityUtil = createPostActivityUtil;
    }

    public static void injectActionLogUtil(MainActivity mainActivity, ActionLogUtil actionLogUtil) {
        mainActivity.actionLogUtil = actionLogUtil;
    }

    public static void injectCategoryRepository(MainActivity mainActivity, CategoryRepository categoryRepository) {
        mainActivity.categoryRepository = categoryRepository;
    }

    public static void injectFittsServiceRepository(MainActivity mainActivity, FittsServiceRepository fittsServiceRepository) {
        mainActivity.fittsServiceRepository = fittsServiceRepository;
    }

    public static void injectUserApi(MainActivity mainActivity, UserAPI userAPI) {
        mainActivity.userApi = userAPI;
    }

    public static void injectActionLogAPI(MainActivity mainActivity, ActionLogAPI actionLogAPI) {
        mainActivity.actionLogAPI = actionLogAPI;
    }
}
