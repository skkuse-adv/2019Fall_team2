package kr.co.popone.fitts.feature.intro;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.user.UserAPI;

public final class IntroActivity_MembersInjector implements MembersInjector<IntroActivity> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<DispatchingAndroidInjector<Fragment>> fragmentInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public IntroActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<UserAPI> provider2, Provider<SessionManager> provider3, Provider<EventTracker> provider4) {
        this.fragmentInjectorProvider = provider;
        this.userAPIProvider = provider2;
        this.sessionManagerProvider = provider3;
        this.eventTrackerProvider = provider4;
    }

    public static MembersInjector<IntroActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<UserAPI> provider2, Provider<SessionManager> provider3, Provider<EventTracker> provider4) {
        return new IntroActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(IntroActivity introActivity) {
        injectFragmentInjector(introActivity, (DispatchingAndroidInjector) this.fragmentInjectorProvider.get());
        injectUserAPI(introActivity, (UserAPI) this.userAPIProvider.get());
        injectSessionManager(introActivity, (SessionManager) this.sessionManagerProvider.get());
        injectEventTracker(introActivity, (EventTracker) this.eventTrackerProvider.get());
    }

    public static void injectFragmentInjector(IntroActivity introActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        introActivity.fragmentInjector = dispatchingAndroidInjector;
    }

    public static void injectUserAPI(IntroActivity introActivity, UserAPI userAPI) {
        introActivity.userAPI = userAPI;
    }

    public static void injectSessionManager(IntroActivity introActivity, SessionManager sessionManager) {
        introActivity.sessionManager = sessionManager;
    }

    public static void injectEventTracker(IntroActivity introActivity, EventTracker eventTracker) {
        introActivity.eventTracker = eventTracker;
    }
}
