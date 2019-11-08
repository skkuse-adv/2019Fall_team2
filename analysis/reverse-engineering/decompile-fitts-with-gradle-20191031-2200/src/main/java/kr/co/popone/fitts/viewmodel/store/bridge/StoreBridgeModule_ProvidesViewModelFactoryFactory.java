package kr.co.popone.fitts.viewmodel.store.bridge;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.store.bridge.ShopBridgeActivity;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class StoreBridgeModule_ProvidesViewModelFactoryFactory implements Factory<StoreBridgeViewModelFactory> {
    private final Provider<ActionLogAPI> actionLogAPIProvider;
    private final Provider<ShopBridgeActivity> activityProvider;
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final StoreBridgeModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<StoreRepository> storeRepositoryProvider;

    public StoreBridgeModule_ProvidesViewModelFactoryFactory(StoreBridgeModule storeBridgeModule, Provider<ShopBridgeActivity> provider, Provider<FittsCommerceRepository> provider2, Provider<StoreRepository> provider3, Provider<ActionLogAPI> provider4, Provider<FittsSchemeHandler> provider5, Provider<SessionManager> provider6, Provider<EventTracker> provider7) {
        this.module = storeBridgeModule;
        this.activityProvider = provider;
        this.commerceRepositoryProvider = provider2;
        this.storeRepositoryProvider = provider3;
        this.actionLogAPIProvider = provider4;
        this.schemeHandlerProvider = provider5;
        this.sessionManagerProvider = provider6;
        this.eventTrackerProvider = provider7;
    }

    public StoreBridgeViewModelFactory get() {
        return provideInstance(this.module, this.activityProvider, this.commerceRepositoryProvider, this.storeRepositoryProvider, this.actionLogAPIProvider, this.schemeHandlerProvider, this.sessionManagerProvider, this.eventTrackerProvider);
    }

    public static StoreBridgeViewModelFactory provideInstance(StoreBridgeModule storeBridgeModule, Provider<ShopBridgeActivity> provider, Provider<FittsCommerceRepository> provider2, Provider<StoreRepository> provider3, Provider<ActionLogAPI> provider4, Provider<FittsSchemeHandler> provider5, Provider<SessionManager> provider6, Provider<EventTracker> provider7) {
        return proxyProvidesViewModelFactory(storeBridgeModule, (ShopBridgeActivity) provider.get(), (FittsCommerceRepository) provider2.get(), (StoreRepository) provider3.get(), (ActionLogAPI) provider4.get(), (FittsSchemeHandler) provider5.get(), (SessionManager) provider6.get(), (EventTracker) provider7.get());
    }

    public static StoreBridgeModule_ProvidesViewModelFactoryFactory create(StoreBridgeModule storeBridgeModule, Provider<ShopBridgeActivity> provider, Provider<FittsCommerceRepository> provider2, Provider<StoreRepository> provider3, Provider<ActionLogAPI> provider4, Provider<FittsSchemeHandler> provider5, Provider<SessionManager> provider6, Provider<EventTracker> provider7) {
        StoreBridgeModule_ProvidesViewModelFactoryFactory storeBridgeModule_ProvidesViewModelFactoryFactory = new StoreBridgeModule_ProvidesViewModelFactoryFactory(storeBridgeModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
        return storeBridgeModule_ProvidesViewModelFactoryFactory;
    }

    public static StoreBridgeViewModelFactory proxyProvidesViewModelFactory(StoreBridgeModule storeBridgeModule, ShopBridgeActivity shopBridgeActivity, FittsCommerceRepository fittsCommerceRepository, StoreRepository storeRepository, ActionLogAPI actionLogAPI, FittsSchemeHandler fittsSchemeHandler, SessionManager sessionManager, EventTracker eventTracker) {
        return (StoreBridgeViewModelFactory) Preconditions.checkNotNull(storeBridgeModule.providesViewModelFactory(shopBridgeActivity, fittsCommerceRepository, storeRepository, actionLogAPI, fittsSchemeHandler, sessionManager, eventTracker), "Cannot return null from a non-@Nullable @Provides method");
    }
}
