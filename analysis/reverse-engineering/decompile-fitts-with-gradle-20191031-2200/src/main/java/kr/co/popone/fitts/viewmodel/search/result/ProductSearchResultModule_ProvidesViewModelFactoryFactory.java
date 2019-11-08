package kr.co.popone.fitts.viewmodel.search.result;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.eventtracker.EventTracker;
import kr.co.popone.fitts.feature.search.view.ProductSearchResultFragment;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.repository.SearchRepository;
import kr.co.popone.fitts.repository.UserRepository;

public final class ProductSearchResultModule_ProvidesViewModelFactoryFactory implements Factory<SearchResultViewModelFactory> {
    private final Provider<ActionLogAPI> actionLogProvider;
    private final Provider<EventTracker> eventTrackerProvider;
    private final Provider<ProductSearchResultFragment> fragmentProvider;
    private final ProductSearchResultModule module;
    private final Provider<SearchRepository> searchRepositoryProvider;
    private final Provider<UserRepository> userRepositoryProvider;

    public ProductSearchResultModule_ProvidesViewModelFactoryFactory(ProductSearchResultModule productSearchResultModule, Provider<ProductSearchResultFragment> provider, Provider<SearchRepository> provider2, Provider<UserRepository> provider3, Provider<EventTracker> provider4, Provider<ActionLogAPI> provider5) {
        this.module = productSearchResultModule;
        this.fragmentProvider = provider;
        this.searchRepositoryProvider = provider2;
        this.userRepositoryProvider = provider3;
        this.eventTrackerProvider = provider4;
        this.actionLogProvider = provider5;
    }

    public SearchResultViewModelFactory get() {
        return provideInstance(this.module, this.fragmentProvider, this.searchRepositoryProvider, this.userRepositoryProvider, this.eventTrackerProvider, this.actionLogProvider);
    }

    public static SearchResultViewModelFactory provideInstance(ProductSearchResultModule productSearchResultModule, Provider<ProductSearchResultFragment> provider, Provider<SearchRepository> provider2, Provider<UserRepository> provider3, Provider<EventTracker> provider4, Provider<ActionLogAPI> provider5) {
        return proxyProvidesViewModelFactory(productSearchResultModule, (ProductSearchResultFragment) provider.get(), (SearchRepository) provider2.get(), (UserRepository) provider3.get(), (EventTracker) provider4.get(), (ActionLogAPI) provider5.get());
    }

    public static ProductSearchResultModule_ProvidesViewModelFactoryFactory create(ProductSearchResultModule productSearchResultModule, Provider<ProductSearchResultFragment> provider, Provider<SearchRepository> provider2, Provider<UserRepository> provider3, Provider<EventTracker> provider4, Provider<ActionLogAPI> provider5) {
        ProductSearchResultModule_ProvidesViewModelFactoryFactory productSearchResultModule_ProvidesViewModelFactoryFactory = new ProductSearchResultModule_ProvidesViewModelFactoryFactory(productSearchResultModule, provider, provider2, provider3, provider4, provider5);
        return productSearchResultModule_ProvidesViewModelFactoryFactory;
    }

    public static SearchResultViewModelFactory proxyProvidesViewModelFactory(ProductSearchResultModule productSearchResultModule, ProductSearchResultFragment productSearchResultFragment, SearchRepository searchRepository, UserRepository userRepository, EventTracker eventTracker, ActionLogAPI actionLogAPI) {
        return (SearchResultViewModelFactory) Preconditions.checkNotNull(productSearchResultModule.providesViewModelFactory(productSearchResultFragment, searchRepository, userRepository, eventTracker, actionLogAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
