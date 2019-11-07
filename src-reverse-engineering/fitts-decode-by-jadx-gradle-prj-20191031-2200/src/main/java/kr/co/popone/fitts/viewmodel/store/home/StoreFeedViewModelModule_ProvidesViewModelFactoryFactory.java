package kr.co.popone.fitts.viewmodel.store.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.store.recommend.StoreFeedFragment;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class StoreFeedViewModelModule_ProvidesViewModelFactoryFactory implements Factory<StoreFeedViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<StoreFeedFragment> fragmentProvider;
    private final StoreFeedViewModelModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<StoreRepository> storeRepositoryProvider;

    public StoreFeedViewModelModule_ProvidesViewModelFactoryFactory(StoreFeedViewModelModule storeFeedViewModelModule, Provider<StoreFeedFragment> provider, Provider<StoreRepository> provider2, Provider<FittsCommerceRepository> provider3, Provider<FittsSchemeHandler> provider4, Provider<EventTracker> provider5, Provider<SessionManager> provider6, Provider<FittsServiceRepository> provider7) {
        this.module = storeFeedViewModelModule;
        this.fragmentProvider = provider;
        this.storeRepositoryProvider = provider2;
        this.commerceRepositoryProvider = provider3;
        this.schemeHandlerProvider = provider4;
        this.eventTrackerProvider = provider5;
        this.sessionManagerProvider = provider6;
        this.serviceRepositoryProvider = provider7;
    }

    public StoreFeedViewModelFactory get() {
        return provideInstance(this.module, this.fragmentProvider, this.storeRepositoryProvider, this.commerceRepositoryProvider, this.schemeHandlerProvider, this.eventTrackerProvider, this.sessionManagerProvider, this.serviceRepositoryProvider);
    }

    public static StoreFeedViewModelFactory provideInstance(StoreFeedViewModelModule storeFeedViewModelModule, Provider<StoreFeedFragment> provider, Provider<StoreRepository> provider2, Provider<FittsCommerceRepository> provider3, Provider<FittsSchemeHandler> provider4, Provider<EventTracker> provider5, Provider<SessionManager> provider6, Provider<FittsServiceRepository> provider7) {
        return proxyProvidesViewModelFactory(storeFeedViewModelModule, (StoreFeedFragment) provider.get(), (StoreRepository) provider2.get(), (FittsCommerceRepository) provider3.get(), (FittsSchemeHandler) provider4.get(), (EventTracker) provider5.get(), (SessionManager) provider6.get(), (FittsServiceRepository) provider7.get());
    }

    public static StoreFeedViewModelModule_ProvidesViewModelFactoryFactory create(StoreFeedViewModelModule storeFeedViewModelModule, Provider<StoreFeedFragment> provider, Provider<StoreRepository> provider2, Provider<FittsCommerceRepository> provider3, Provider<FittsSchemeHandler> provider4, Provider<EventTracker> provider5, Provider<SessionManager> provider6, Provider<FittsServiceRepository> provider7) {
        StoreFeedViewModelModule_ProvidesViewModelFactoryFactory storeFeedViewModelModule_ProvidesViewModelFactoryFactory = new StoreFeedViewModelModule_ProvidesViewModelFactoryFactory(storeFeedViewModelModule, provider, provider2, provider3, provider4, provider5, provider6, provider7);
        return storeFeedViewModelModule_ProvidesViewModelFactoryFactory;
    }

    public static StoreFeedViewModelFactory proxyProvidesViewModelFactory(StoreFeedViewModelModule storeFeedViewModelModule, StoreFeedFragment storeFeedFragment, StoreRepository storeRepository, FittsCommerceRepository fittsCommerceRepository, FittsSchemeHandler fittsSchemeHandler, EventTracker eventTracker, SessionManager sessionManager, FittsServiceRepository fittsServiceRepository) {
        return (StoreFeedViewModelFactory) Preconditions.checkNotNull(storeFeedViewModelModule.providesViewModelFactory(storeFeedFragment, storeRepository, fittsCommerceRepository, fittsSchemeHandler, eventTracker, sessionManager, fittsServiceRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
