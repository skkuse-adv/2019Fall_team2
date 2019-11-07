package kr.co.popone.fitts.viewmodel.ncommerce;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.ncommerce.NCommerceActivity;

public final class NCommerceModule_ProvideOrderViewModelFactory implements Factory<NCommerceViewModel> {
    private final Provider<NCommerceActivity> activityProvider;
    private final NCommerceModule module;
    private final Provider<NCommerceViewModelFactory> viewModelFactoryProvider;

    public NCommerceModule_ProvideOrderViewModelFactory(NCommerceModule nCommerceModule, Provider<NCommerceActivity> provider, Provider<NCommerceViewModelFactory> provider2) {
        this.module = nCommerceModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public NCommerceViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static NCommerceViewModel provideInstance(NCommerceModule nCommerceModule, Provider<NCommerceActivity> provider, Provider<NCommerceViewModelFactory> provider2) {
        return proxyProvideOrderViewModel(nCommerceModule, (NCommerceActivity) provider.get(), (NCommerceViewModelFactory) provider2.get());
    }

    public static NCommerceModule_ProvideOrderViewModelFactory create(NCommerceModule nCommerceModule, Provider<NCommerceActivity> provider, Provider<NCommerceViewModelFactory> provider2) {
        return new NCommerceModule_ProvideOrderViewModelFactory(nCommerceModule, provider, provider2);
    }

    public static NCommerceViewModel proxyProvideOrderViewModel(NCommerceModule nCommerceModule, NCommerceActivity nCommerceActivity, NCommerceViewModelFactory nCommerceViewModelFactory) {
        return (NCommerceViewModel) Preconditions.checkNotNull(nCommerceModule.provideOrderViewModel(nCommerceActivity, nCommerceViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
