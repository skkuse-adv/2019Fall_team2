package kr.co.popone.fitts.viewmodel.banner;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.banner.BannerActivity;

public final class BannerModule_ProvideCartViewModelFactory implements Factory<BannerViewModel> {
    private final Provider<BannerActivity> activityProvider;
    private final BannerModule module;
    private final Provider<BannerViewModelFactory> viewModelFactoryProvider;

    public BannerModule_ProvideCartViewModelFactory(BannerModule bannerModule, Provider<BannerActivity> provider, Provider<BannerViewModelFactory> provider2) {
        this.module = bannerModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public BannerViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static BannerViewModel provideInstance(BannerModule bannerModule, Provider<BannerActivity> provider, Provider<BannerViewModelFactory> provider2) {
        return proxyProvideCartViewModel(bannerModule, (BannerActivity) provider.get(), (BannerViewModelFactory) provider2.get());
    }

    public static BannerModule_ProvideCartViewModelFactory create(BannerModule bannerModule, Provider<BannerActivity> provider, Provider<BannerViewModelFactory> provider2) {
        return new BannerModule_ProvideCartViewModelFactory(bannerModule, provider, provider2);
    }

    public static BannerViewModel proxyProvideCartViewModel(BannerModule bannerModule, BannerActivity bannerActivity, BannerViewModelFactory bannerViewModelFactory) {
        return (BannerViewModel) Preconditions.checkNotNull(bannerModule.provideCartViewModel(bannerActivity, bannerViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
