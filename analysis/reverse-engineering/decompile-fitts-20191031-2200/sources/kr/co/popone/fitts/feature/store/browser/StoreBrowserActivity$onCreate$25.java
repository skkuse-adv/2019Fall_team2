package kr.co.popone.fitts.feature.store.browser;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.product.AffiliatesProduct;

final class StoreBrowserActivity$onCreate$25<T> implements Observer<AffiliatesProduct> {
    final /* synthetic */ StoreBrowserActivity this$0;

    StoreBrowserActivity$onCreate$25(StoreBrowserActivity storeBrowserActivity) {
        this.this$0 = storeBrowserActivity;
    }

    public final void onChanged(AffiliatesProduct affiliatesProduct) {
        if (affiliatesProduct != null) {
            this.this$0.updateOptionSelectView(affiliatesProduct);
            this.this$0.handleOrderableType(affiliatesProduct.getOrderableType());
        }
    }
}
