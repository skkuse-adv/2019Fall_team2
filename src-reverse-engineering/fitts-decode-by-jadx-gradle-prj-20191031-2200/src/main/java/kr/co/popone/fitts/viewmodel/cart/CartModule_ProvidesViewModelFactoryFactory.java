package kr.co.popone.fitts.viewmodel.cart;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.repository.CartRepository;

public final class CartModule_ProvidesViewModelFactoryFactory implements Factory<CartViewModelFactory> {
    private final Provider<CartRepository> cartRepositoryProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final CartModule module;

    public CartModule_ProvidesViewModelFactoryFactory(CartModule cartModule, Provider<CartRepository> provider, Provider<EventTracker> provider2) {
        this.module = cartModule;
        this.cartRepositoryProvider = provider;
        this.eventTrackerProvider = provider2;
    }

    public CartViewModelFactory get() {
        return provideInstance(this.module, this.cartRepositoryProvider, this.eventTrackerProvider);
    }

    public static CartViewModelFactory provideInstance(CartModule cartModule, Provider<CartRepository> provider, Provider<EventTracker> provider2) {
        return proxyProvidesViewModelFactory(cartModule, (CartRepository) provider.get(), (EventTracker) provider2.get());
    }

    public static CartModule_ProvidesViewModelFactoryFactory create(CartModule cartModule, Provider<CartRepository> provider, Provider<EventTracker> provider2) {
        return new CartModule_ProvidesViewModelFactoryFactory(cartModule, provider, provider2);
    }

    public static CartViewModelFactory proxyProvidesViewModelFactory(CartModule cartModule, CartRepository cartRepository, EventTracker eventTracker) {
        return (CartViewModelFactory) Preconditions.checkNotNull(cartModule.providesViewModelFactory(cartRepository, eventTracker), "Cannot return null from a non-@Nullable @Provides method");
    }
}
