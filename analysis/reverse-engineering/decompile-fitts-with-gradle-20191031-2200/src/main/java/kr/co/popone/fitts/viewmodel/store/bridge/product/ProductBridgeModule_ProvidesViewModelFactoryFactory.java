package kr.co.popone.fitts.viewmodel.store.bridge.product;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.repository.PostRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class ProductBridgeModule_ProvidesViewModelFactoryFactory implements Factory<ProductBridgeViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final ProductBridgeModule module;
    private final Provider<PostRepository> postRepositoryProvider;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;
    private final Provider<SessionManager> sessionManagerProvider;

    public ProductBridgeModule_ProvidesViewModelFactoryFactory(ProductBridgeModule productBridgeModule, Provider<FittsServiceRepository> provider, Provider<PostRepository> provider2, Provider<FittsSchemeHandler> provider3, Provider<EventTracker> provider4, Provider<SessionManager> provider5) {
        this.module = productBridgeModule;
        this.serviceRepositoryProvider = provider;
        this.postRepositoryProvider = provider2;
        this.schemeHandlerProvider = provider3;
        this.eventTrackerProvider = provider4;
        this.sessionManagerProvider = provider5;
    }

    public ProductBridgeViewModelFactory get() {
        return provideInstance(this.module, this.serviceRepositoryProvider, this.postRepositoryProvider, this.schemeHandlerProvider, this.eventTrackerProvider, this.sessionManagerProvider);
    }

    public static ProductBridgeViewModelFactory provideInstance(ProductBridgeModule productBridgeModule, Provider<FittsServiceRepository> provider, Provider<PostRepository> provider2, Provider<FittsSchemeHandler> provider3, Provider<EventTracker> provider4, Provider<SessionManager> provider5) {
        return proxyProvidesViewModelFactory(productBridgeModule, (FittsServiceRepository) provider.get(), (PostRepository) provider2.get(), (FittsSchemeHandler) provider3.get(), (EventTracker) provider4.get(), (SessionManager) provider5.get());
    }

    public static ProductBridgeModule_ProvidesViewModelFactoryFactory create(ProductBridgeModule productBridgeModule, Provider<FittsServiceRepository> provider, Provider<PostRepository> provider2, Provider<FittsSchemeHandler> provider3, Provider<EventTracker> provider4, Provider<SessionManager> provider5) {
        ProductBridgeModule_ProvidesViewModelFactoryFactory productBridgeModule_ProvidesViewModelFactoryFactory = new ProductBridgeModule_ProvidesViewModelFactoryFactory(productBridgeModule, provider, provider2, provider3, provider4, provider5);
        return productBridgeModule_ProvidesViewModelFactoryFactory;
    }

    public static ProductBridgeViewModelFactory proxyProvidesViewModelFactory(ProductBridgeModule productBridgeModule, FittsServiceRepository fittsServiceRepository, PostRepository postRepository, FittsSchemeHandler fittsSchemeHandler, EventTracker eventTracker, SessionManager sessionManager) {
        return (ProductBridgeViewModelFactory) Preconditions.checkNotNull(productBridgeModule.providesViewModelFactory(fittsServiceRepository, postRepository, fittsSchemeHandler, eventTracker, sessionManager), "Cannot return null from a non-@Nullable @Provides method");
    }
}
