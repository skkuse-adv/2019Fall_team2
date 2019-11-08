package kr.co.popone.fitts.viewmodel.category;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;

public final class CategorySearchModule_ProvidesViewModelFactoryFactory implements Factory<CategorySearchViewModelFactory> {
    private final Provider<EventTracker> eventTrackerProvider;
    private final CategorySearchModule module;

    public CategorySearchModule_ProvidesViewModelFactoryFactory(CategorySearchModule categorySearchModule, Provider<EventTracker> provider) {
        this.module = categorySearchModule;
        this.eventTrackerProvider = provider;
    }

    public CategorySearchViewModelFactory get() {
        return provideInstance(this.module, this.eventTrackerProvider);
    }

    public static CategorySearchViewModelFactory provideInstance(CategorySearchModule categorySearchModule, Provider<EventTracker> provider) {
        return proxyProvidesViewModelFactory(categorySearchModule, (EventTracker) provider.get());
    }

    public static CategorySearchModule_ProvidesViewModelFactoryFactory create(CategorySearchModule categorySearchModule, Provider<EventTracker> provider) {
        return new CategorySearchModule_ProvidesViewModelFactoryFactory(categorySearchModule, provider);
    }

    public static CategorySearchViewModelFactory proxyProvidesViewModelFactory(CategorySearchModule categorySearchModule, EventTracker eventTracker) {
        return (CategorySearchViewModelFactory) Preconditions.checkNotNull(categorySearchModule.providesViewModelFactory(eventTracker), "Cannot return null from a non-@Nullable @Provides method");
    }
}
