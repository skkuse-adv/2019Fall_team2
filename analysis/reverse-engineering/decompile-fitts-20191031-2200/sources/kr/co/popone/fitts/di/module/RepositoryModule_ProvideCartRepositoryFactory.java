package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.cart.CartAPI;
import kr.co.popone.fitts.repository.CartRepository;

public final class RepositoryModule_ProvideCartRepositoryFactory implements Factory<CartRepository> {
    private final Provider<CartAPI> cartAPIProvider;
    private final RepositoryModule module;

    public RepositoryModule_ProvideCartRepositoryFactory(RepositoryModule repositoryModule, Provider<CartAPI> provider) {
        this.module = repositoryModule;
        this.cartAPIProvider = provider;
    }

    public CartRepository get() {
        return provideInstance(this.module, this.cartAPIProvider);
    }

    public static CartRepository provideInstance(RepositoryModule repositoryModule, Provider<CartAPI> provider) {
        return proxyProvideCartRepository(repositoryModule, (CartAPI) provider.get());
    }

    public static RepositoryModule_ProvideCartRepositoryFactory create(RepositoryModule repositoryModule, Provider<CartAPI> provider) {
        return new RepositoryModule_ProvideCartRepositoryFactory(repositoryModule, provider);
    }

    public static CartRepository proxyProvideCartRepository(RepositoryModule repositoryModule, CartAPI cartAPI) {
        return (CartRepository) Preconditions.checkNotNull(repositoryModule.provideCartRepository(cartAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
