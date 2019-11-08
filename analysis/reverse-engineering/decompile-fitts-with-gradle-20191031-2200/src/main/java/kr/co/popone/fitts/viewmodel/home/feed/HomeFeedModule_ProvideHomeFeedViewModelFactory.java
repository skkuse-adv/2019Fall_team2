package kr.co.popone.fitts.viewmodel.home.feed;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.home.feed.HomeFeedFragment;

public final class HomeFeedModule_ProvideHomeFeedViewModelFactory implements Factory<HomeFeedViewModel> {
    private final Provider<HomeFeedFragment> fragmentProvider;
    private final HomeFeedModule module;
    private final Provider<HomeFeedViewModelFactory> viewModelFactoryProvider;

    public HomeFeedModule_ProvideHomeFeedViewModelFactory(HomeFeedModule homeFeedModule, Provider<HomeFeedFragment> provider, Provider<HomeFeedViewModelFactory> provider2) {
        this.module = homeFeedModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public HomeFeedViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static HomeFeedViewModel provideInstance(HomeFeedModule homeFeedModule, Provider<HomeFeedFragment> provider, Provider<HomeFeedViewModelFactory> provider2) {
        return proxyProvideHomeFeedViewModel(homeFeedModule, (HomeFeedFragment) provider.get(), (HomeFeedViewModelFactory) provider2.get());
    }

    public static HomeFeedModule_ProvideHomeFeedViewModelFactory create(HomeFeedModule homeFeedModule, Provider<HomeFeedFragment> provider, Provider<HomeFeedViewModelFactory> provider2) {
        return new HomeFeedModule_ProvideHomeFeedViewModelFactory(homeFeedModule, provider, provider2);
    }

    public static HomeFeedViewModel proxyProvideHomeFeedViewModel(HomeFeedModule homeFeedModule, HomeFeedFragment homeFeedFragment, HomeFeedViewModelFactory homeFeedViewModelFactory) {
        return (HomeFeedViewModel) Preconditions.checkNotNull(homeFeedModule.provideHomeFeedViewModel(homeFeedFragment, homeFeedViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
