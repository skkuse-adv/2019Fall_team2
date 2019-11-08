package kr.co.popone.fitts.viewmodel.store.newest;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.base.SessionManager;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class NewestProductViewModelModule_ProvidesViewModelFactoryFactory implements Factory<NewestProductViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final NewestProductViewModelModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<StoreRepository> storeRepositoryProvider;

    public NewestProductViewModelModule_ProvidesViewModelFactoryFactory(NewestProductViewModelModule newestProductViewModelModule, Provider<StoreRepository> provider, Provider<FittsServiceRepository> provider2, Provider<FittsCommerceRepository> provider3, Provider<FittsSchemeHandler> provider4, Provider<SessionManager> provider5, Provider<EventTracker> provider6) {
        this.module = newestProductViewModelModule;
        this.storeRepositoryProvider = provider;
        this.serviceRepositoryProvider = provider2;
        this.commerceRepositoryProvider = provider3;
        this.schemeHandlerProvider = provider4;
        this.sessionManagerProvider = provider5;
        this.eventTrackerProvider = provider6;
    }

    public NewestProductViewModelFactory get() {
        return provideInstance(this.module, this.storeRepositoryProvider, this.serviceRepositoryProvider, this.commerceRepositoryProvider, this.schemeHandlerProvider, this.sessionManagerProvider, this.eventTrackerProvider);
    }

    public static NewestProductViewModelFactory provideInstance(NewestProductViewModelModule newestProductViewModelModule, Provider<StoreRepository> provider, Provider<FittsServiceRepository> provider2, Provider<FittsCommerceRepository> provider3, Provider<FittsSchemeHandler> provider4, Provider<SessionManager> provider5, Provider<EventTracker> provider6) {
        return proxyProvidesViewModelFactory(newestProductViewModelModule, (StoreRepository) provider.get(), (FittsServiceRepository) provider2.get(), (FittsCommerceRepository) provider3.get(), (FittsSchemeHandler) provider4.get(), (SessionManager) provider5.get(), (EventTracker) provider6.get());
    }

    public static NewestProductViewModelModule_ProvidesViewModelFactoryFactory create(NewestProductViewModelModule newestProductViewModelModule, Provider<StoreRepository> provider, Provider<FittsServiceRepository> provider2, Provider<FittsCommerceRepository> provider3, Provider<FittsSchemeHandler> provider4, Provider<SessionManager> provider5, Provider<EventTracker> provider6) {
        NewestProductViewModelModule_ProvidesViewModelFactoryFactory newestProductViewModelModule_ProvidesViewModelFactoryFactory = new NewestProductViewModelModule_ProvidesViewModelFactoryFactory(newestProductViewModelModule, provider, provider2, provider3, provider4, provider5, provider6);
        return newestProductViewModelModule_ProvidesViewModelFactoryFactory;
    }

    public static NewestProductViewModelFactory proxyProvidesViewModelFactory(NewestProductViewModelModule newestProductViewModelModule, StoreRepository storeRepository, FittsServiceRepository fittsServiceRepository, FittsCommerceRepository fittsCommerceRepository, FittsSchemeHandler fittsSchemeHandler, SessionManager sessionManager, EventTracker eventTracker) {
        return (NewestProductViewModelFactory) Preconditions.checkNotNull(newestProductViewModelModule.providesViewModelFactory(storeRepository, fittsServiceRepository, fittsCommerceRepository, fittsSchemeHandler, sessionManager, eventTracker), "Cannot return null from a non-@Nullable @Provides method");
    }
}
