package kr.co.popone.fitts.feature.store.bridge;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.store.StoreInfo;

final class ShopBridgeHeaderHolder$initView$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ StoreInfo $this_with;
    final /* synthetic */ ShopBridgeHeaderHolder this$0;

    ShopBridgeHeaderHolder$initView$$inlined$with$lambda$1(StoreInfo storeInfo, ShopBridgeHeaderHolder shopBridgeHeaderHolder) {
        this.$this_with = storeInfo;
        this.this$0 = shopBridgeHeaderHolder;
    }

    public final void onClick(View view) {
        if (this.$this_with.isBookmark()) {
            this.this$0.delegate.onRemoveShopBookmark(this.$this_with.getId());
        } else {
            this.this$0.delegate.onAddShopBookmark(this.$this_with.getId());
        }
    }
}
