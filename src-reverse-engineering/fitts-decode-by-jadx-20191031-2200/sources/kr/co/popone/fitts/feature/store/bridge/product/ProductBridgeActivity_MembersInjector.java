package kr.co.popone.fitts.feature.store.bridge.product;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.store.bridge.product.ProductBridgeViewModel;

public final class ProductBridgeActivity_MembersInjector implements MembersInjector<ProductBridgeActivity> {
    private final Provider<ProductBridgeViewModel> viewModelProvider;

    public ProductBridgeActivity_MembersInjector(Provider<ProductBridgeViewModel> provider) {
        this.viewModelProvider = provider;
    }

    public static MembersInjector<ProductBridgeActivity> create(Provider<ProductBridgeViewModel> provider) {
        return new ProductBridgeActivity_MembersInjector(provider);
    }

    public void injectMembers(ProductBridgeActivity productBridgeActivity) {
        injectViewModel(productBridgeActivity, (ProductBridgeViewModel) this.viewModelProvider.get());
    }

    public static void injectViewModel(ProductBridgeActivity productBridgeActivity, ProductBridgeViewModel productBridgeViewModel) {
        productBridgeActivity.viewModel = productBridgeViewModel;
    }
}
