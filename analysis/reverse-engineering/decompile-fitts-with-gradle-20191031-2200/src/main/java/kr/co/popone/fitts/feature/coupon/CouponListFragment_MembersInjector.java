package kr.co.popone.fitts.feature.coupon;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.coupon.CouponAPI;

public final class CouponListFragment_MembersInjector implements MembersInjector<CouponListFragment> {
    private final Provider<CouponAPI> couponAPIProvider;
    private final Provider<SessionManager> sessionManagerProvider;

    public CouponListFragment_MembersInjector(Provider<CouponAPI> provider, Provider<SessionManager> provider2) {
        this.couponAPIProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<CouponListFragment> create(Provider<CouponAPI> provider, Provider<SessionManager> provider2) {
        return new CouponListFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(CouponListFragment couponListFragment) {
        injectCouponAPI(couponListFragment, (CouponAPI) this.couponAPIProvider.get());
        injectSessionManager(couponListFragment, (SessionManager) this.sessionManagerProvider.get());
    }

    public static void injectCouponAPI(CouponListFragment couponListFragment, CouponAPI couponAPI) {
        couponListFragment.couponAPI = couponAPI;
    }

    public static void injectSessionManager(CouponListFragment couponListFragment, SessionManager sessionManager) {
        couponListFragment.sessionManager = sessionManager;
    }
}
