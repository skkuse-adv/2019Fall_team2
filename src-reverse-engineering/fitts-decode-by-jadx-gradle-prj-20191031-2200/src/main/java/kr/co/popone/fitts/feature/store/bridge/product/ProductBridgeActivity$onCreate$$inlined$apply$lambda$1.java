package kr.co.popone.fitts.feature.store.bridge.product;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import kr.co.popone.fitts.feature.common.ImageRatioViewHolder;

public final class ProductBridgeActivity$onCreate$$inlined$apply$lambda$1 extends SpanSizeLookup {
    final /* synthetic */ ProductBridgeActivity this$0;

    ProductBridgeActivity$onCreate$$inlined$apply$lambda$1(ProductBridgeActivity productBridgeActivity) {
        this.this$0 = productBridgeActivity;
    }

    public int getSpanSize(int i) {
        int itemViewType = this.this$0.getProductBridgeAdapter().getItemViewType(i);
        return (itemViewType == ProductBridgeHeaderViewHolder.Companion.getId() || itemViewType == ImageRatioViewHolder.Companion.getId()) ? 3 : 1;
    }
}
