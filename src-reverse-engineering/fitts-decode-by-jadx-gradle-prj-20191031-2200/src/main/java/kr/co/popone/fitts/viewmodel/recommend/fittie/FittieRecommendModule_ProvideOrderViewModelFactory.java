package kr.co.popone.fitts.viewmodel.recommend.fittie;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.recommend.fittie.FittieRecommendActivity;

public final class FittieRecommendModule_ProvideOrderViewModelFactory implements Factory<FittieRecommendViewModel> {
    private final Provider<FittieRecommendActivity> activityProvider;
    private final FittieRecommendModule module;
    private final Provider<FittieRecommendViewModelFactory> viewModelFactoryProvider;

    public FittieRecommendModule_ProvideOrderViewModelFactory(FittieRecommendModule fittieRecommendModule, Provider<FittieRecommendActivity> provider, Provider<FittieRecommendViewModelFactory> provider2) {
        this.module = fittieRecommendModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public FittieRecommendViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static FittieRecommendViewModel provideInstance(FittieRecommendModule fittieRecommendModule, Provider<FittieRecommendActivity> provider, Provider<FittieRecommendViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(fittieRecommendModule, (FittieRecommendActivity) provider.get(), (FittieRecommendViewModelFactory) provider2.get());
    }

    public static FittieRecommendModule_ProvideOrderViewModelFactory create(FittieRecommendModule fittieRecommendModule, Provider<FittieRecommendActivity> provider, Provider<FittieRecommendViewModelFactory> provider2) {
        return new FittieRecommendModule_ProvideOrderViewModelFactory(fittieRecommendModule, provider, provider2);
    }

    public static FittieRecommendViewModel proxyProvideOrderViewModel(FittieRecommendModule fittieRecommendModule, FittieRecommendActivity fittieRecommendActivity, FittieRecommendViewModelFactory fittieRecommendViewModelFactory) {
        return (FittieRecommendViewModel) Preconditions.checkNotNull(fittieRecommendModule.provideOrderViewModel(fittieRecommendActivity, fittieRecommendViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
