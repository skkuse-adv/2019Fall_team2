package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.post.PostAPI;
import kr.co.popone.fitts.repository.PostRepository;

public final class RepositoryModule_ProvidePostRepositoryFactory implements Factory<PostRepository> {
    private final RepositoryModule module;
    private final Provider<PostAPI> postAPIProvider;

    public RepositoryModule_ProvidePostRepositoryFactory(RepositoryModule repositoryModule, Provider<PostAPI> provider) {
        this.module = repositoryModule;
        this.postAPIProvider = provider;
    }

    public PostRepository get() {
        return provideInstance(this.module, this.postAPIProvider);
    }

    public static PostRepository provideInstance(RepositoryModule repositoryModule, Provider<PostAPI> provider) {
        return proxyProvidePostRepository(repositoryModule, (PostAPI) provider.get());
    }

    public static RepositoryModule_ProvidePostRepositoryFactory create(RepositoryModule repositoryModule, Provider<PostAPI> provider) {
        return new RepositoryModule_ProvidePostRepositoryFactory(repositoryModule, provider);
    }

    public static PostRepository proxyProvidePostRepository(RepositoryModule repositoryModule, PostAPI postAPI) {
        return (PostRepository) Preconditions.checkNotNull(repositoryModule.providePostRepository(postAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
