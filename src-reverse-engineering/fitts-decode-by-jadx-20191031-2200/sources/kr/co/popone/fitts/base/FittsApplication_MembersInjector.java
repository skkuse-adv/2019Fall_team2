package kr.co.popone.fitts.base;

import android.app.Activity;
import android.app.Service;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class FittsApplication_MembersInjector implements MembersInjector<FittsApplication> {
    private final Provider<DispatchingAndroidInjector<Activity>> dispatchingAndroidInjectorProvider;
    private final Provider<DispatchingAndroidInjector<Service>> dispatchingServiceInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public FittsApplication_MembersInjector(Provider<SessionManager> provider, Provider<DispatchingAndroidInjector<Activity>> provider2, Provider<DispatchingAndroidInjector<Service>> provider3, Provider<UserAPI> provider4) {
        this.sessionManagerProvider = provider;
        this.dispatchingAndroidInjectorProvider = provider2;
        this.dispatchingServiceInjectorProvider = provider3;
        this.userAPIProvider = provider4;
    }

    public static MembersInjector<FittsApplication> create(Provider<SessionManager> provider, Provider<DispatchingAndroidInjector<Activity>> provider2, Provider<DispatchingAndroidInjector<Service>> provider3, Provider<UserAPI> provider4) {
        return new FittsApplication_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(FittsApplication fittsApplication) {
        injectSessionManager(fittsApplication, (SessionManager) this.sessionManagerProvider.get());
        injectDispatchingAndroidInjector(fittsApplication, (DispatchingAndroidInjector) this.dispatchingAndroidInjectorProvider.get());
        injectDispatchingServiceInjector(fittsApplication, (DispatchingAndroidInjector) this.dispatchingServiceInjectorProvider.get());
        injectUserAPI(fittsApplication, (UserAPI) this.userAPIProvider.get());
    }

    public static void injectSessionManager(FittsApplication fittsApplication, SessionManager sessionManager) {
        fittsApplication.sessionManager = sessionManager;
    }

    public static void injectDispatchingAndroidInjector(FittsApplication fittsApplication, DispatchingAndroidInjector<Activity> dispatchingAndroidInjector) {
        fittsApplication.dispatchingAndroidInjector = dispatchingAndroidInjector;
    }

    public static void injectDispatchingServiceInjector(FittsApplication fittsApplication, DispatchingAndroidInjector<Service> dispatchingAndroidInjector) {
        fittsApplication.dispatchingServiceInjector = dispatchingAndroidInjector;
    }

    public static void injectUserAPI(FittsApplication fittsApplication, UserAPI userAPI) {
        fittsApplication.userAPI = userAPI;
    }
}
