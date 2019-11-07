package kr.co.popone.fitts.viewmodel.banner;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.model.log.ActionLogAPI;
import kr.co.popone.fitts.model.repository.service.FittsServiceRepository;
import kr.co.popone.fitts.services.FittsSchemeHandler;

public final class BannerModule_ProvidesViewModelFactoryFactory implements Factory<BannerViewModelFactory> {
    private final Provider<ActionLogAPI> actionLogAPIProvider;
    private final BannerModule module;
    private final Provider<FittsSchemeHandler> schemeHandlerProvider;
    private final Provider<FittsServiceRepository> serviceRepositoryProvider;

    public BannerModule_ProvidesViewModelFactoryFactory(BannerModule bannerModule, Provider<FittsServiceRepository> provider, Provider<FittsSchemeHandler> provider2, Provider<ActionLogAPI> provider3) {
        this.module = bannerModule;
        this.serviceRepositoryProvider = provider;
        this.schemeHandlerProvider = provider2;
        this.actionLogAPIProvider = provider3;
    }

    public BannerViewModelFactory get() {
        return provideInstance(this.module, this.serviceRepositoryProvider, this.schemeHandlerProvider, this.actionLogAPIProvider);
    }

    public static BannerViewModelFactory provideInstance(BannerModule bannerModule, Provider<FittsServiceRepository> provider, Provider<FittsSchemeHandler> provider2, Provider<ActionLogAPI> provider3) {
        return proxyProvidesViewModelFactory(bannerModule, (FittsServiceRepository) provider.get(), (FittsSchemeHandler) provider2.get(), (ActionLogAPI) provider3.get());
    }

    public static BannerModule_ProvidesViewModelFactoryFactory create(BannerModule bannerModule, Provider<FittsServiceRepository> provider, Provider<FittsSchemeHandler> provider2, Provider<ActionLogAPI> provider3) {
        return new BannerModule_ProvidesViewModelFactoryFactory(bannerModule, provider, provider2, provider3);
    }

    public static BannerViewModelFactory proxyProvidesViewModelFactory(BannerModule bannerModule, FittsServiceRepository fittsServiceRepository, FittsSchemeHandler fittsSchemeHandler, ActionLogAPI actionLogAPI) {
        return (BannerViewModelFactory) Preconditions.checkNotNull(bannerModule.providesViewModelFactory(fittsServiceRepository, fittsSchemeHandler, actionLogAPI), "Cannot return null from a non-@Nullable @Provides method");
    }
}
