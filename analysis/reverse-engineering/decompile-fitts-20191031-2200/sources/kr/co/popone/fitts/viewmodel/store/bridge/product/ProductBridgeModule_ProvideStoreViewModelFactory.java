package kr.co.popone.fitts.viewmodel.store.bridge.product;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kr.co.popone.fitts.feature.store.bridge.product.ProductBridgeActivity;

public final class ProductBridgeModule_ProvideStoreViewModelFactory implements Factory<ProductBridgeViewModel> {
    private final Provider<ProductBridgeActivity> activityProvider;
    private final ProductBridgeModule module;
    private final Provider<ProductBridgeViewModelFactory> viewModelFactoryProvider;

    public ProductBridgeModule_ProvideStoreViewModelFactory(ProductBridgeModule productBridgeModule, Provider<ProductBridgeActivity> provider, Provider<ProductBridgeViewModelFactory> provider2) {
        this.module = productBridgeModule;
        this.activityProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public ProductBridgeViewModel get() {
        return provideInstance(this.module, this.activityProvider, this.viewModelFactoryProvider);
    }

    public static ProductBridgeViewModel provideInstance(ProductBridgeModule productBridgeModule, Provider<ProductBridgeActivity> provider, Provider<ProductBridgeViewModelFactory> provider2) {
        return proxyProvideStoreViewModel(productBridgeModule, (ProductBridgeActivity) provider.get(), (ProductBridgeViewModelFactory) provider2.get());
    }

    public static ProductBridgeModule_ProvideStoreViewModelFactory create(ProductBridgeModule productBridgeModule, Provider<ProductBridgeActivity> provider, Provider<ProductBridgeViewModelFactory> provider2) {
        return new ProductBridgeModule_ProvideStoreViewModelFactory(productBridgeModule, provider, provider2);
    }

    public static ProductBridgeViewModel proxyProvideStoreViewModel(ProductBridgeModule productBridgeModule, ProductBridgeActivity productBridgeActivity, ProductBridgeViewModelFactory productBridgeViewModelFactory) {
        return (ProductBridgeViewModel) Preconditions.checkNotNull(productBridgeModule.provideStoreViewModel(productBridgeActivity, productBridgeViewModelFactory), "Cannot return null from a non-@Nullable @Provides method");
    }
}
