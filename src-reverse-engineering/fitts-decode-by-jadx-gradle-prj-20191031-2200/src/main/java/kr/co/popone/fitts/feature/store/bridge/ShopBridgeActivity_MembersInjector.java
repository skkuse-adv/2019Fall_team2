package kr.co.popone.fitts.feature.store.bridge;

import dagger.MembersInjector;
import javax.inject.Provider;
import kr.co.popone.fitts.viewmodel.store.bridge.ShopBridgeViewModel;

public final class ShopBridgeActivity_MembersInjector implements MembersInjector<ShopBridgeActivity> {
    private final Provider<ShopBridgeViewModel> vmProvider;

    public ShopBridgeActivity_MembersInjector(Provider<ShopBridgeViewModel> provider) {
        this.vmProvider = provider;
    }

    public static MembersInjector<ShopBridgeActivity> create(Provider<ShopBridgeViewModel> provider) {
        return new ShopBridgeActivity_MembersInjector(provider);
    }

    public void injectMembers(ShopBridgeActivity shopBridgeActivity) {
        injectVm(shopBridgeActivity, (ShopBridgeViewModel) this.vmProvider.get());
    }

    public static void injectVm(ShopBridgeActivity shopBridgeActivity, ShopBridgeViewModel shopBridgeViewModel) {
        shopBridgeActivity.vm = shopBridgeViewModel;
    }
}
