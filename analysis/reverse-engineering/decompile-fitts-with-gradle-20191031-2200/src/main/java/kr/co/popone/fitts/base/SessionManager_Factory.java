package kr.co.popone.fitts.base;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;

public final class SessionManager_Factory implements Factory<SessionManager> {
    private final Provider<Context> contextProvider;
    private final Provider<UserAPI> userAPIProvider;

    public SessionManager_Factory(Provider<Context> provider, Provider<UserAPI> provider2) {
        this.contextProvider = provider;
        this.userAPIProvider = provider2;
    }

    public SessionManager get() {
        return provideInstance(this.contextProvider, this.userAPIProvider);
    }

    public static SessionManager provideInstance(Provider<Context> provider, Provider<UserAPI> provider2) {
        SessionManager sessionManager = new SessionManager((Context) provider.get());
        SessionManager_MembersInjector.injectUserAPI(sessionManager, (UserAPI) provider2.get());
        return sessionManager;
    }

    public static SessionManager_Factory create(Provider<Context> provider, Provider<UserAPI> provider2) {
        return new SessionManager_Factory(provider, provider2);
    }

    public static SessionManager newSessionManager(Context context) {
        return new SessionManager(context);
    }
}
