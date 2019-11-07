package kr.co.popone.fitts.feature.me;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.coupon.CouponAPI;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class MeFragment_MembersInjector implements MembersInjector<MeFragment> {
    private final Provider<CouponAPI> couponAPIProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<FittsServiceRepository> fittsServiceRepositoryProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public MeFragment_MembersInjector(Provider<EventTracker> provider, Provider<SessionManager> provider2, Provider<FittsSchemeHandler> provider3, Provider<UserAPI> provider4, Provider<CouponAPI> provider5, Provider<FittsServiceRepository> provider6) {
        this.eventTrackerProvider = provider;
        this.sessionManagerProvider = provider2;
        this.schemeHandlerProvider = provider3;
        this.userAPIProvider = provider4;
        this.couponAPIProvider = provider5;
        this.fittsServiceRepositoryProvider = provider6;
    }

    public static MembersInjector<MeFragment> create(Provider<EventTracker> provider, Provider<SessionManager> provider2, Provider<FittsSchemeHandler> provider3, Provider<UserAPI> provider4, Provider<CouponAPI> provider5, Provider<FittsServiceRepository> provider6) {
        MeFragment_MembersInjector meFragment_MembersInjector = new MeFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
        return meFragment_MembersInjector;
    }

    public void injectMembers(MeFragment meFragment) {
        injectEventTracker(meFragment, (EventTracker) this.eventTrackerProvider.get());
        injectSessionManager(meFragment, (SessionManager) this.sessionManagerProvider.get());
        injectSchemeHandler(meFragment, (FittsSchemeHandler) this.schemeHandlerProvider.get());
        injectUserAPI(meFragment, (UserAPI) this.userAPIProvider.get());
        injectCouponAPI(meFragment, (CouponAPI) this.couponAPIProvider.get());
        injectFittsServiceRepository(meFragment, (FittsServiceRepository) this.fittsServiceRepositoryProvider.get());
    }

    public static void injectEventTracker(MeFragment meFragment, EventTracker eventTracker) {
        meFragment.eventTracker = eventTracker;
    }

    public static void injectSessionManager(MeFragment meFragment, SessionManager sessionManager) {
        meFragment.sessionManager = sessionManager;
    }

    public static void injectSchemeHandler(MeFragment meFragment, FittsSchemeHandler fittsSchemeHandler) {
        meFragment.schemeHandler = fittsSchemeHandler;
    }

    public static void injectUserAPI(MeFragment meFragment, UserAPI userAPI) {
        meFragment.userAPI = userAPI;
    }

    public static void injectCouponAPI(MeFragment meFragment, CouponAPI couponAPI) {
        meFragment.couponAPI = couponAPI;
    }

    public static void injectFittsServiceRepository(MeFragment meFragment, FittsServiceRepository fittsServiceRepository) {
        meFragment.fittsServiceRepository = fittsServiceRepository;
    }
}
