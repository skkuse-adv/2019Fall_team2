package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.repository.UserRepository;

public final class RepositoryModule_ProvideUserRepositoryFactory implements Factory<UserRepository> {
    private final RepositoryModule module;
    private final Provider<UserAPI> userAPIProvider;

    public RepositoryModule_ProvideUserRepositoryFactory(RepositoryModule repositoryModule, Provider<UserAPI> provider) {
        this.module = repositoryModule;
        this.userAPIProvider = provider;
    }

    public UserRepository get() {
        return provideInstance(this.module, this.userAPIProvider);
    }

    public static UserRepository provideInstance(RepositoryModule repositoryModule, Provider<UserAPI> provider) {
        return proxyProvideUserRepository(repositoryModule, (UserAPI) provider.get());
    }

    public static RepositoryModule_ProvideUserRepositoryFactory create(RepositoryModule repositoryModule, Provider<UserAPI> provider) {
        return new RepositoryModule_ProvideUserRepositoryFactory(repositoryModule, provider);
    }

    public static UserRepository proxyProvideUserRepository(RepositoryModule repositoryModule, UserAPI userAPI) {
        return (UserRepository) Preconditions.checkNotNull(repositoryModule.provideUserRepository(userAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
