package kr.co.popone.fitts.feature.coupon;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;

public final class CouponPointInputUserInfoActivity_MembersInjector implements MembersInjector<CouponPointInputUserInfoActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public CouponPointInputUserInfoActivity_MembersInjector(Provider<SessionManager> provider, Provider<UserAPI> provider2) {
        this.sessionManagerProvider = provider;
        this.userAPIProvider = provider2;
    }

    public static MembersInjector<CouponPointInputUserInfoActivity> create(Provider<SessionManager> provider, Provider<UserAPI> provider2) {
        return new CouponPointInputUserInfoActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity) {
        injectSessionManager(couponPointInputUserInfoActivity, (SessionManager) this.sessionManagerProvider.get());
        injectUserAPI(couponPointInputUserInfoActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectSessionManager(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity, SessionManager sessionManager) {
        couponPointInputUserInfoActivity.sessionManager = sessionManager;
    }

    public static void injectUserAPI(CouponPointInputUserInfoActivity couponPointInputUserInfoActivity, UserAPI userAPI) {
        couponPointInputUserInfoActivity.userAPI = userAPI;
    }
}
