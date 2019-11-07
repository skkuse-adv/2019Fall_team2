package kr.co.popone.fitts.viewmodel.store.list;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.repository.StoreRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;
import kr.co.popone.fitts.utils.ActionLogUtil;

public final class ShopBookmarkModule_ProvidesViewModelFactoryFactory implements Factory<ShopBookmarkViewModelFactory> {
    private final Provider<ActionLogUtil> actionLogUtilProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final ShopBookmarkModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<StoreRepository> storeRepositoryProvider;

    public ShopBookmarkModule_ProvidesViewModelFactoryFactory(ShopBookmarkModule shopBookmarkModule, Provider<StoreRepository> provider, Provider<EventTracker> provider2, Provider<ActionLogUtil> provider3, Provider<FittsSchemeHandler> provider4) {
        this.module = shopBookmarkModule;
        this.storeRepositoryProvider = provider;
        this.eventTrackerProvider = provider2;
        this.actionLogUtilProvider = provider3;
        this.schemeHandlerProvider = provider4;
    }

    public ShopBookmarkViewModelFactory get() {
        return provideInstance(this.module, this.storeRepositoryProvider, this.eventTrackerProvider, this.actionLogUtilProvider, this.schemeHandlerProvider);
    }

    public static ShopBookmarkViewModelFactory provideInstance(ShopBookmarkModule shopBookmarkModule, Provider<StoreRepository> provider, Provider<EventTracker> provider2, Provider<ActionLogUtil> provider3, Provider<FittsSchemeHandler> provider4) {
        return proxyProvidesViewModelFactory(shopBookmarkModule, (StoreRepository) provider.get(), (EventTracker) provider2.get(), (ActionLogUtil) provider3.get(), (FittsSchemeHandler) provider4.get());
    }

    public static ShopBookmarkModule_ProvidesViewModelFactoryFactory create(ShopBookmarkModule shopBookmarkModule, Provider<StoreRepository> provider, Provider<EventTracker> provider2, Provider<ActionLogUtil> provider3, Provider<FittsSchemeHandler> provider4) {
        ShopBookmarkModule_ProvidesViewModelFactoryFactory shopBookmarkModule_ProvidesViewModelFactoryFactory = new ShopBookmarkModule_ProvidesViewModelFactoryFactory(shopBookmarkModule, provider, provider2, provider3, provider4);
        return shopBookmarkModule_ProvidesViewModelFactoryFactory;
    }

    public static ShopBookmarkViewModelFactory proxyProvidesViewModelFactory(ShopBookmarkModule shopBookmarkModule, StoreRepository storeRepository, EventTracker eventTracker, ActionLogUtil actionLogUtil, FittsSchemeHandler fittsSchemeHandler) {
        return (ShopBookmarkViewModelFactory) Preconditions.checkNotNull(shopBookmarkModule.providesViewModelFactory(storeRepository, eventTracker, actionLogUtil, fittsSchemeHandler), "Cannot return null from a non-@Nullable @Provides method");
    }
}
