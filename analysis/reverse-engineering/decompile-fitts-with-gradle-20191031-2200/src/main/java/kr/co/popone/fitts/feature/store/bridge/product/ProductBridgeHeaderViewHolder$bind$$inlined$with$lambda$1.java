package kr.co.popone.fitts.feature.store.bridge.product;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.store.bridge.product.ProductBridgeHeaderViewHolder.Delegate;
import kr.co.popone.fitts.model.store.ProductBridgeViewData.HeaderType;

final class ProductBridgeHeaderViewHolder$bind$$inlined$with$lambda$1 implements OnClickListener {
    final /* synthetic */ Delegate $delegate$inlined;
    final /* synthetic */ HeaderType $this_run;

    ProductBridgeHeaderViewHolder$bind$$inlined$with$lambda$1(HeaderType headerType, View view, HeaderType headerType2, boolean z, Delegate delegate) {
        this.$this_run = headerType;
        this.$delegate$inlined = delegate;
    }

    public final void onClick(View view) {
        this.$delegate$inlined.productHeaderClicked(this.$this_run.getLinkUrl());
    }
}
