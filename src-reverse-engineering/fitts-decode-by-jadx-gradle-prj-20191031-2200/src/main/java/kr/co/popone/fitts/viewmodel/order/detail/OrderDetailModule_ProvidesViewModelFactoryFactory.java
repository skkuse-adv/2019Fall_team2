package kr.co.popone.fitts.viewmodel.order.detail;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.post.upload.create.CreatePostActivityUtil;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;

public final class OrderDetailModule_ProvidesViewModelFactoryFactory implements Factory<OrderDetailViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<CreatePostActivityUtil> createPostActivityUtilProvider;
    private final OrderDetailModule module;

    public OrderDetailModule_ProvidesViewModelFactoryFactory(OrderDetailModule orderDetailModule, Provider<FittsCommerceRepository> provider, Provider<CreatePostActivityUtil> provider2) {
        this.module = orderDetailModule;
        this.commerceRepositoryProvider = provider;
        this.createPostActivityUtilProvider = provider2;
    }

    public OrderDetailViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.createPostActivityUtilProvider);
    }

    public static OrderDetailViewModelFactory provideInstance(OrderDetailModule orderDetailModule, Provider<FittsCommerceRepository> provider, Provider<CreatePostActivityUtil> provider2) {
        return proxyProvidesViewModelFactory(orderDetailModule, (FittsCommerceRepository) provider.get(), (CreatePostActivityUtil) provider2.get());
    }

    public static OrderDetailModule_ProvidesViewModelFactoryFactory create(OrderDetailModule orderDetailModule, Provider<FittsCommerceRepository> provider, Provider<CreatePostActivityUtil> provider2) {
        return new OrderDetailModule_ProvidesViewModelFactoryFactory(orderDetailModule, provider, provider2);
    }

    public static OrderDetailViewModelFactory proxyProvidesViewModelFactory(OrderDetailModule orderDetailModule, FittsCommerceRepository fittsCommerceRepository, CreatePostActivityUtil createPostActivityUtil) {
        return (OrderDetailViewModelFactory) Preconditions.checkNotNull(orderDetailModule.providesViewModelFactory(fittsCommerceRepository, createPostActivityUtil), "Cannot return null from a non-@Nullable @Provides method");
    }
}
