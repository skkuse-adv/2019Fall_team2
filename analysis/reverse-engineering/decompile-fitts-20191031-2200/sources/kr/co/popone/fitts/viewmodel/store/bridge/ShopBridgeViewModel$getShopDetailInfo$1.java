package kr.co.popone.fitts.viewmodel.store.bridge;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.StoreInfo;

final class ShopBridgeViewModel$getShopDetailInfo$1<T> implements Consumer<StoreInfo> {
    final /* synthetic */ ShopBridgeViewModel this$0;

    ShopBridgeViewModel$getShopDetailInfo$1(ShopBridgeViewModel shopBridgeViewModel) {
        this.this$0 = shopBridgeViewModel;
    }

    public final void accept(StoreInfo storeInfo) {
        ShopBridgeViewModel shopBridgeViewModel = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(storeInfo, "it");
        shopBridgeViewModel.updateShopInfo(storeInfo);
    }
}
