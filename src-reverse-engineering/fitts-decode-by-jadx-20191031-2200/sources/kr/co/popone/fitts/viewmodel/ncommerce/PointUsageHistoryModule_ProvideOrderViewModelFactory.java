package kr.co.popone.fitts.viewmodel.ncommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.ncommerce.PointUsageHistoryFragment;

public final class PointUsageHistoryModule_ProvideOrderViewModelFactory implements Factory<NCommerceViewModel> {
    private final Provider<PointUsageHistoryFragment> fragmentProvider;
    private final PointUsageHistoryModule module;
    private final Provider<NCommerceViewModelFactory> viewModelFactoryProvider;

    public PointUsageHistoryModule_ProvideOrderViewModelFactory(PointUsageHistoryModule pointUsageHistoryModule, Provider<PointUsageHistoryFragment> provider, Provider<NCommerceViewModelFactory> provider2) {
        this.module = pointUsageHistoryModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public NCommerceViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static NCommerceViewModel provideInstance(PointUsageHistoryModule pointUsageHistoryModule, Provider<PointUsageHistoryFragment> provider, Provider<NCommerceViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(pointUsageHistoryModule, (PointUsageHistoryFragment) provider.get(), (NCommerceViewModelFactory) provider2.get());
    }

    public static PointUsageHistoryModule_ProvideOrderViewModelFactory create(PointUsageHistoryModule pointUsageHistoryModule, Provider<PointUsageHistoryFragment> provider, Provider<NCommerceViewModelFactory> provider2) {
        return new PointUsageHistoryModule_ProvideOrderViewModelFactory(pointUsageHistoryModule, provider, provider2);
    }

    public static NCommerceViewModel proxyProvideOrderViewModel(PointUsageHistoryModule pointUsageHistoryModule, PointUsageHistoryFragment pointUsageHistoryFragment, NCommerceViewModelFactory nCommerceViewModelFactory) {
        return (NCommerceViewModel) Preconditions.checkNotNull(pointUsageHistoryModule.provideOrderViewModel(pointUsageHistoryFragment, nCommerceViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
