package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.home.HomeRepository;

public final class RepositoryModule_ProvideHomeRepositoryFactory implements Factory<HomeRepository> {
    private final RepositoryModule module;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<UserAPI> userAPIProvider;

    public RepositoryModule_ProvideHomeRepositoryFactory(RepositoryModule repositoryModule, Provider<UserAPI> provider, Provider<SessionManager> provider2) {
        this.module = repositoryModule;
        this.userAPIProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public HomeRepository get() {
        return provideInstance(this.module, this.userAPIProvider, this.sessionManagerProvider);
    }

    public static HomeRepository provideInstance(RepositoryModule repositoryModule, Provider<UserAPI> provider, Provider<SessionManager> provider2) {
        return proxyProvideHomeRepository(repositoryModule, (UserAPI) provider.get(), (SessionManager) provider2.get());
    }

    public static RepositoryModule_ProvideHomeRepositoryFactory create(RepositoryModule repositoryModule, Provider<UserAPI> provider, Provider<SessionManager> provider2) {
        return new RepositoryModule_ProvideHomeRepositoryFactory(repositoryModule, provider, provider2);
    }

    public static HomeRepository proxyProvideHomeRepository(RepositoryModule repositoryModule, UserAPI userAPI, SessionManager sessionManager) {
        return (HomeRepository) Preconditions.checkNotNull(repositoryModule.provideHomeRepository(userAPI, sessionManager), "Cannot return null from a non-@Nullable @Provides method");
    }
}
