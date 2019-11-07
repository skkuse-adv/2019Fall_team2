package kr.co.popone.fitts.viewmodel.category;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.category.CategorySearchActivity;

public final class CategorySearchModule_ProvideCategorySearchActivityViewModelFactory implements Factory<CategorySearchViewModel> {
    private final Provider<CategorySearchActivity> activityProvider;
    private final CategorySearchModule module;
    private final Provider<CategorySearchViewModelFactory> viewModelFactoryProvider;

    public CategorySearchModule_ProvideCategorySearchActivityViewModelFactory(CategorySearchModule categorySearchModule, Provider<CategorySearchActivity> provider, Provider<CategorySearchViewModelFactory> provider2) {
        this.module = categorySearchModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public CategorySearchViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static CategorySearchViewModel provideInstance(CategorySearchModule categorySearchModule, Provider<CategorySearchActivity> provider, Provider<CategorySearchViewModelFactory> provider2) {
        return proxyProvideCategorySearchActivityViewModel(categorySearchModule, (CategorySearchActivity) provider.get(), (CategorySearchViewModelFactory) provider2.get());
    }

    public static CategorySearchModule_ProvideCategorySearchActivityViewModelFactory create(CategorySearchModule categorySearchModule, Provider<CategorySearchActivity> provider, Provider<CategorySearchViewModelFactory> provider2) {
        return new CategorySearchModule_ProvideCategorySearchActivityViewModelFactory(categorySearchModule, provider, provider2);
    }

    public static CategorySearchViewModel proxyProvideCategorySearchActivityViewModel(CategorySearchModule categorySearchModule, CategorySearchActivity categorySearchActivity, CategorySearchViewModelFactory categorySearchViewModelFactory) {
        return (CategorySearchViewModel) Preconditions.checkNotNull(categorySearchModule.provideCategorySearchActivityViewModel(categorySearchActivity, categorySearchViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
