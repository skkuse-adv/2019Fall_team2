package kr.co.popone.fitts.viewmodel.trend;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.trend.TrendFeedActivity;

public final class TrendFeedModule_ProvideStoreViewModelFactory implements Factory<TrendFeedViewModel> {
    private final Provider<TrendFeedActivity> activityProvider;
    private final TrendFeedModule module;
    private final Provider<TrendFeedViewModelFactory> viewModelFactoryProvider;

    public TrendFeedModule_ProvideStoreViewModelFactory(TrendFeedModule trendFeedModule, Provider<TrendFeedActivity> provider, Provider<TrendFeedViewModelFactory> provider2) {
        this.module = trendFeedModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public TrendFeedViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static TrendFeedViewModel provideInstance(TrendFeedModule trendFeedModule, Provider<TrendFeedActivity> provider, Provider<TrendFeedViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(trendFeedModule, (TrendFeedActivity) provider.get(), (TrendFeedViewModelFactory) provider2.get());
    }

    public static TrendFeedModule_ProvideStoreViewModelFactory create(TrendFeedModule trendFeedModule, Provider<TrendFeedActivity> provider, Provider<TrendFeedViewModelFactory> provider2) {
        return new TrendFeedModule_ProvideStoreViewModelFactory(trendFeedModule, provider, provider2);
    }

    public static TrendFeedViewModel proxyProvideStoreViewModel(TrendFeedModule trendFeedModule, TrendFeedActivity trendFeedActivity, TrendFeedViewModelFactory trendFeedViewModelFactory) {
        return (TrendFeedViewModel) Preconditions.checkNotNull(trendFeedModule.provideStoreViewModel(trendFeedActivity, trendFeedViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
