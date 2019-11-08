package kr.co.popone.fitts.viewmodel.ncommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.ncommerce.PointRevenueDetailFragment;

public final class RevenueDetailModule_ProvideOrderViewModelFactory implements Factory<NCommerceViewModel> {
    private final Provider<PointRevenueDetailFragment> fragmentProvider;
    private final RevenueDetailModule module;
    private final Provider<NCommerceViewModelFactory> viewModelFactoryProvider;

    public RevenueDetailModule_ProvideOrderViewModelFactory(RevenueDetailModule revenueDetailModule, Provider<PointRevenueDetailFragment> provider, Provider<NCommerceViewModelFactory> provider2) {
        this.module = revenueDetailModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public NCommerceViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static NCommerceViewModel provideInstance(RevenueDetailModule revenueDetailModule, Provider<PointRevenueDetailFragment> provider, Provider<NCommerceViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(revenueDetailModule, (PointRevenueDetailFragment) provider.get(), (NCommerceViewModelFactory) provider2.get());
    }

    public static RevenueDetailModule_ProvideOrderViewModelFactory create(RevenueDetailModule revenueDetailModule, Provider<PointRevenueDetailFragment> provider, Provider<NCommerceViewModelFactory> provider2) {
        return new RevenueDetailModule_ProvideOrderViewModelFactory(revenueDetailModule, provider, provider2);
    }

    public static NCommerceViewModel proxyProvideOrderViewModel(RevenueDetailModule revenueDetailModule, PointRevenueDetailFragment pointRevenueDetailFragment, NCommerceViewModelFactory nCommerceViewModelFactory) {
        return (NCommerceViewModel) Preconditions.checkNotNull(revenueDetailModule.provideOrderViewModel(pointRevenueDetailFragment, nCommerceViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
