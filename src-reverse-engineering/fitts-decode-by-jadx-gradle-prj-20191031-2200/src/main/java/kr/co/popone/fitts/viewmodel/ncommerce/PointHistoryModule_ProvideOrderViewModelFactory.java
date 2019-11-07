package kr.co.popone.fitts.viewmodel.ncommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.ncommerce.PointHistoryFragment;

public final class PointHistoryModule_ProvideOrderViewModelFactory implements Factory<NCommerceViewModel> {
    private final Provider<PointHistoryFragment> fragmentProvider;
    private final PointHistoryModule module;
    private final Provider<NCommerceViewModelFactory> viewModelFactoryProvider;

    public PointHistoryModule_ProvideOrderViewModelFactory(PointHistoryModule pointHistoryModule, Provider<PointHistoryFragment> provider, Provider<NCommerceViewModelFactory> provider2) {
        this.module = pointHistoryModule;
        this.fragmentProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public NCommerceViewModel get() {
        return provideInstance(this.module, this.fragmentProvider, this.viewModelFactoryProvider);
    }

    public static NCommerceViewModel provideInstance(PointHistoryModule pointHistoryModule, Provider<PointHistoryFragment> provider, Provider<NCommerceViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(pointHistoryModule, (PointHistoryFragment) provider.get(), (NCommerceViewModelFactory) provider2.get());
    }

    public static PointHistoryModule_ProvideOrderViewModelFactory create(PointHistoryModule pointHistoryModule, Provider<PointHistoryFragment> provider, Provider<NCommerceViewModelFactory> provider2) {
        return new PointHistoryModule_ProvideOrderViewModelFactory(pointHistoryModule, provider, provider2);
    }

    public static NCommerceViewModel proxyProvideOrderViewModel(PointHistoryModule pointHistoryModule, PointHistoryFragment pointHistoryFragment, NCommerceViewModelFactory nCommerceViewModelFactory) {
        return (NCommerceViewModel) Preconditions.checkNotNull(pointHistoryModule.provideOrderViewModel(pointHistoryFragment, nCommerceViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
