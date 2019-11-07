package kr.co.popone.fitts.viewmodel.store.browser;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.CartRepository;
import kr.co.popone.fitts.repository.ProductRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class StoreBrowserModule_ProvidesViewModelFactoryFactory implements Factory<StoreBrowserViewModelFactory> {
    private final Provider<CartRepository> cartRepositoryProvider;
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final StoreBrowserModule module;
    private final Provider<ProductRepository> productRepositoryProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<StoreRepository> storeRepositoryProvider;

    public StoreBrowserModule_ProvidesViewModelFactoryFactory(StoreBrowserModule storeBrowserModule, Provider<FittsCommerceRepository> provider, Provider<ProductRepository> provider2, Provider<StoreRepository> provider3, Provider<CartRepository> provider4, Provider<EventTracker> provider5, Provider<FittsSchemeHandler> provider6) {
        this.module = storeBrowserModule;
        this.commerceRepositoryProvider = provider;
        this.productRepositoryProvider = provider2;
        this.storeRepositoryProvider = provider3;
        this.cartRepositoryProvider = provider4;
        this.eventTrackerProvider = provider5;
        this.schemeHandlerProvider = provider6;
    }

    public StoreBrowserViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.productRepositoryProvider, this.storeRepositoryProvider, this.cartRepositoryProvider, this.eventTrackerProvider, this.schemeHandlerProvider);
    }

    public static StoreBrowserViewModelFactory provideInstance(StoreBrowserModule storeBrowserModule, Provider<FittsCommerceRepository> provider, Provider<ProductRepository> provider2, Provider<StoreRepository> provider3, Provider<CartRepository> provider4, Provider<EventTracker> provider5, Provider<FittsSchemeHandler> provider6) {
        return proxyProvidesViewModelFactory(storeBrowserModule, (FittsCommerceRepository) provider.get(), (ProductRepository) provider2.get(), (StoreRepository) provider3.get(), (CartRepository) provider4.get(), (EventTracker) provider5.get(), (FittsSchemeHandler) provider6.get());
    }

    public static StoreBrowserModule_ProvidesViewModelFactoryFactory create(StoreBrowserModule storeBrowserModule, Provider<FittsCommerceRepository> provider, Provider<ProductRepository> provider2, Provider<StoreRepository> provider3, Provider<CartRepository> provider4, Provider<EventTracker> provider5, Provider<FittsSchemeHandler> provider6) {
        StoreBrowserModule_ProvidesViewModelFactoryFactory storeBrowserModule_ProvidesViewModelFactoryFactory = new StoreBrowserModule_ProvidesViewModelFactoryFactory(storeBrowserModule, provider, provider2, provider3, provider4, provider5, provider6);
        return storeBrowserModule_ProvidesViewModelFactoryFactory;
    }

    public static StoreBrowserViewModelFactory proxyProvidesViewModelFactory(StoreBrowserModule storeBrowserModule, FittsCommerceRepository fittsCommerceRepository, ProductRepository productRepository, StoreRepository storeRepository, CartRepository cartRepository, EventTracker eventTracker, FittsSchemeHandler fittsSchemeHandler) {
        return (StoreBrowserViewModelFactory) Preconditions.checkNotNull(storeBrowserModule.providesViewModelFactory(fittsCommerceRepository, productRepository, storeRepository, cartRepository, eventTracker, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
