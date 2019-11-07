package kr.co.popone.fitts.feature.identification.view;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;

public final class IdentificationWebViewFragment_MembersInjector implements MembersInjector<IdentificationWebViewFragment> {
    private final Provider<SessionManager> sessionManagerProvider;

    public IdentificationWebViewFragment_MembersInjector(Provider<SessionManager> provider) {
        this.sessionManagerProvider = provider;
    }

    public static MembersInjector<IdentificationWebViewFragment> create(Provider<SessionManager> provider) {
        return new IdentificationWebViewFragment_MembersInjector(provider);
    }

    public void injectMembers(IdentificationWebViewFragment identificationWebViewFragment) {
        injectSessionManager(identificationWebViewFragment, (SessionManager) this.sessionManagerProvider.get());
    }

    public static void injectSessionManager(IdentificationWebViewFragment identificationWebViewFragment, SessionManager sessionManager) {
        identificationWebViewFragment.sessionManager = sessionManager;
    }
}
