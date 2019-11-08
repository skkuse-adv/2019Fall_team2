package kr.co.popone.fitts.viewmodel.store;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.model.user.UserAPI;

public final class StoreModule_ProvidesViewModelFactoryFactory implements Factory<StoreViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final StoreModule module;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;
    private final Provider<UserAPI> userAPIProvider;

    public StoreModule_ProvidesViewModelFactoryFactory(StoreModule storeModule, Provider<UserAPI> provider, Provider<EventTracker> provider2, Provider<FittsServiceRepository> provider3) {
        this.module = storeModule;
        this.userAPIProvider = provider;
        this.eventTrackerProvider = provider2;
        this.serviceRepositoryProvider = provider3;
    }

    public StoreViewModelFactory get() {
        return provideInstance(this.module, this.userAPIProvider, this.eventTrackerProvider, this.serviceRepositoryProvider);
    }

    public static StoreViewModelFactory provideInstance(StoreModule storeModule, Provider<UserAPI> provider, Provider<EventTracker> provider2, Provider<FittsServiceRepository> provider3) {
        return proxyProvidesViewModelFactory(storeModule, (UserAPI) provider.get(), (EventTracker) provider2.get(), (FittsServiceRepository) provider3.get());
    }

    public static StoreModule_ProvidesViewModelFactoryFactory create(StoreModule storeModule, Provider<UserAPI> provider, Provider<EventTracker> provider2, Provider<FittsServiceRepository> provider3) {
        return new StoreModule_ProvidesViewModelFactoryFactory(storeModule, provider, provider2, provider3);
    }

    public static StoreViewModelFactory proxyProvidesViewModelFactory(StoreModule storeModule, UserAPI userAPI, EventTracker eventTracker, FittsServiceRepository fittsServiceRepository) {
        return (StoreViewModelFactory) Preconditions.checkNotNull(storeModule.providesViewModelFactory(userAPI, eventTracker, fittsServiceRepository), "Cannot return null from a non-@Nullable @Provides method");
    }
}
