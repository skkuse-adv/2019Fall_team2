package kr.co.popone.fitts.viewmodel.wish;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.model.repository.commerce.FittsCommerceRepository;

public final class WishListModule_ProvidesViewModelFactoryFactory implements Factory<WishListViewModelFactory> {
    private final Provider<FittsCommerceRepository> commerceRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final WishListModule module;

    public WishListModule_ProvidesViewModelFactoryFactory(WishListModule wishListModule, Provider<FittsCommerceRepository> provider, Provider<EventTracker> provider2) {
        this.module = wishListModule;
        this.commerceRepositoryProvider = provider;
        this.eventTrackerProvider = provider2;
    }

    public WishListViewModelFactory get() {
        return provideInstance(this.module, this.commerceRepositoryProvider, this.eventTrackerProvider);
    }

    public static WishListViewModelFactory provideInstance(WishListModule wishListModule, Provider<FittsCommerceRepository> provider, Provider<EventTracker> provider2) {
        return proxyProvidesViewModelFactory(wishListModule, (FittsCommerceRepository) provider.get(), (EventTracker) provider2.get());
    }

    public static WishListModule_ProvidesViewModelFactoryFactory create(WishListModule wishListModule, Provider<FittsCommerceRepository> provider, Provider<EventTracker> provider2) {
        return new WishListModule_ProvidesViewModelFactoryFactory(wishListModule, provider, provider2);
    }

    public static WishListViewModelFactory proxyProvidesViewModelFactory(WishListModule wishListModule, FittsCommerceRepository fittsCommerceRepository, EventTracker eventTracker) {
        return (WishListViewModelFactory) Preconditions.checkNotNull(wishListModule.providesViewModelFactory(fittsCommerceRepository, eventTracker), "Cannot return null from a non-@Nullable @Provides method");
    }
}
