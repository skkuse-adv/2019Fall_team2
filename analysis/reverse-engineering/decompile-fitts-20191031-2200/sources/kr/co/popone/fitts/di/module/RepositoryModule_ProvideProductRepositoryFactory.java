package kr.co.popone.fitts.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.product.ProductAPI;
import kr.co.popone.fitts.repository.ProductRepository;

public final class RepositoryModule_ProvideProductRepositoryFactory implements Factory<ProductRepository> {
    private final RepositoryModule module;
    private final Provider<ProductAPI> productAPIProvider;

    public RepositoryModule_ProvideProductRepositoryFactory(RepositoryModule repositoryModule, Provider<ProductAPI> provider) {
        this.module = repositoryModule;
        this.productAPIProvider = provider;
    }

    public ProductRepository get() {
        return provideInstance(this.module, this.productAPIProvider);
    }

    public static ProductRepository provideInstance(RepositoryModule repositoryModule, Provider<ProductAPI> provider) {
        return proxyProvideProductRepository(repositoryModule, (ProductAPI) provider.get());
    }

    public static RepositoryModule_ProvideProductRepositoryFactory create(RepositoryModule repositoryModule, Provider<ProductAPI> provider) {
        return new RepositoryModule_ProvideProductRepositoryFactory(repositoryModule, provider);
    }

    public static ProductRepository proxyProvideProductRepository(RepositoryModule repositoryModule, ProductAPI productAPI) {
        return (ProductRepository) Preconditions.checkNotNull(repositoryModule.provideProductRepository(productAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
