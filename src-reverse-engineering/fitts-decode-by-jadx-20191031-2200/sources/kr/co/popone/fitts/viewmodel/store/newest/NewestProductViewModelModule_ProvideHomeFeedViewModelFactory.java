package kr.co.popone.fitts.viewmodel.store.newest;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.store.newest.StoreNewFeedFragment;

public final class NewestProductViewModelModule_ProvideHomeFeedViewModelFactory implements Factory<NewestProductViewModel> {
    private final Provider<StoreNewFeedFragment> fragmentProvider;
    private final NewestProductViewModelModule module;
    private final Provider<NewestProductViewModelFactory> viewModelFactoryProvider;

    public NewestProductViewModelModule_ProvideHomeFeedViewModelFactory(NewestProductViewModelModule newestProductViewModelModule, Provider<StoreNewFeedFragment> provider, Provider<NewestProductViewModelFactory> provider2) {
        this.module = newestProductViewModelModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public NewestProductViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static NewestProductViewModel provideInstance(NewestProductViewModelModule newestProductViewModelModule, Provider<StoreNewFeedFragment> provider, Provider<NewestProductViewModelFactory> provider2) {
        return proxyProvideHomeFeedViewModel(newestProductViewModelModule, (StoreNewFeedFragment) provider.get(), (NewestProductViewModelFactory) provider2.get());
    }

    public static NewestProductViewModelModule_ProvideHomeFeedViewModelFactory create(NewestProductViewModelModule newestProductViewModelModule, Provider<StoreNewFeedFragment> provider, Provider<NewestProductViewModelFactory> provider2) {
        return new NewestProductViewModelModule_ProvideHomeFeedViewModelFactory(newestProductViewModelModule, provider, provider2);
    }

    public static NewestProductViewModel proxyProvideHomeFeedViewModel(NewestProductViewModelModule newestProductViewModelModule, StoreNewFeedFragment storeNewFeedFragment, NewestProductViewModelFactory newestProductViewModelFactory) {
        return (NewestProductViewModel) Preconditions.checkNotNull(newestProductViewModelModule.provideHomeFeedViewModel(storeNewFeedFragment, newestProductViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
