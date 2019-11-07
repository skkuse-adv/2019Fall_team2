package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.product.Product;

final class ProductSquareFeedHolder$updateProductRectanngleFeedUi$$inlined$run$lambda$2 implements OnClickListener {
    final /* synthetic */ Product $this_run;
    final /* synthetic */ ProductSquareFeedHolder this$0;

    ProductSquareFeedHolder$updateProductRectanngleFeedUi$$inlined$run$lambda$2(Product product, ProductSquareFeedHolder productSquareFeedHolder) {
        this.$this_run = product;
        this.this$0 = productSquareFeedHolder;
    }

    public final void onClick(View view) {
        this.$this_run.getShopLinkUrl();
        this.this$0.delegate.onProductClick(this.$this_run.getId(), this.$this_run.getShopLinkUrl());
    }
}
