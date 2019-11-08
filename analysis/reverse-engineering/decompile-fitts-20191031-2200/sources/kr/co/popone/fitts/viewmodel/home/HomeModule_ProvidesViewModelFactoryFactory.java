package kr.co.popone.fitts.viewmodel.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.repository.home.HomeRepository;

public final class HomeModule_ProvidesViewModelFactoryFactory implements Factory<HomeViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final HomeModule module;
    private final Provider<HomeRepository> repositoryProvider;

    public HomeModule_ProvidesViewModelFactoryFactory(HomeModule homeModule, Provider<HomeRepository> provider, Provider<EventTracker> provider2) {
        this.module = homeModule;
        this.repositoryProvider = provider;
        this.eventTrackerProvider = provider2;
    }

    public HomeViewModelFactory get() {
        return provideInstance(this.module, this.repositoryProvider, this.eventTrackerProvider);
    }

    public static HomeViewModelFactory provideInstance(HomeModule homeModule, Provider<HomeRepository> provider, Provider<EventTracker> provider2) {
        return proxyProvidesViewModelFactory(homeModule, (HomeRepository) provider.get(), (EventTracker) provider2.get());
    }

    public static HomeModule_ProvidesViewModelFactoryFactory create(HomeModule homeModule, Provider<HomeRepository> provider, Provider<EventTracker> provider2) {
        return new HomeModule_ProvidesViewModelFactoryFactory(homeModule, provider, provider2);
    }

    public static HomeViewModelFactory proxyProvidesViewModelFactory(HomeModule homeModule, HomeRepository homeRepository, EventTracker eventTracker) {
        return (HomeViewModelFactory) Preconditions.checkNotNull(homeModule.providesViewModelFactory(homeRepository, eventTracker), "Cannot return null from a non-@Nullable @Provides method");
    }
}
