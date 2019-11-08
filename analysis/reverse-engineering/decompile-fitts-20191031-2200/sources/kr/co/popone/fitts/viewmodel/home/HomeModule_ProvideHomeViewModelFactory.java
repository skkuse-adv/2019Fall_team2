package kr.co.popone.fitts.viewmodel.home;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.home.HomeFragment;

public final class HomeModule_ProvideHomeViewModelFactory implements Factory<HomeViewModel> {
    private final Provider<HomeFragment> fragmentProvider;
    private final HomeModule module;
    private final Provider<HomeViewModelFactory> viewModelFactoryProvider;

    public HomeModule_ProvideHomeViewModelFactory(HomeModule homeModule, Provider<HomeFragment> provider, Provider<HomeViewModelFactory> provider2) {
        this.module = homeModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public HomeViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static HomeViewModel provideInstance(HomeModule homeModule, Provider<HomeFragment> provider, Provider<HomeViewModelFactory> provider2) {
        return proxyProvideHomeViewModel(homeModule, (HomeFragment) provider.get(), (HomeViewModelFactory) provider2.get());
    }

    public static HomeModule_ProvideHomeViewModelFactory create(HomeModule homeModule, Provider<HomeFragment> provider, Provider<HomeViewModelFactory> provider2) {
        return new HomeModule_ProvideHomeViewModelFactory(homeModule, provider, provider2);
    }

    public static HomeViewModel proxyProvideHomeViewModel(HomeModule homeModule, HomeFragment homeFragment, HomeViewModelFactory homeViewModelFactory) {
        return (HomeViewModel) Preconditions.checkNotNull(homeModule.provideHomeViewModel(homeFragment, homeViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
