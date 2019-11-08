package kr.co.popone.fitts.feature.coupon;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;

public final class CouponHomeActivity_MembersInjector implements MembersInjector<CouponHomeActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public CouponHomeActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<UserAPI> provider3) {
        this.fragmentInjectorProvider = provider;
        this.sessionManagerProvider = provider2;
        this.userAPIProvider = provider3;
    }

    public static MembersInjector<CouponHomeActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<UserAPI> provider3) {
        return new CouponHomeActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(CouponHomeActivity couponHomeActivity) {
        injectFragmentInjector(couponHomeActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
        injectSessionManager(couponHomeActivity, (SessionManager) this.sessionManagerProvider.get());
        injectUserAPI(couponHomeActivity, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectFragmentInjector(CouponHomeActivity couponHomeActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        couponHomeActivity.fragmentInjector = dispatchingAndroidInjector;
    }

    public static void injectSessionManager(CouponHomeActivity couponHomeActivity, SessionManager sessionManager) {
        couponHomeActivity.sessionManager = sessionManager;
    }

    public static void injectUserAPI(CouponHomeActivity couponHomeActivity, UserAPI userAPI) {
        couponHomeActivity.userAPI = userAPI;
    }
}
