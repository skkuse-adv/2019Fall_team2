package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.product.Product;

final class ProductSquareFeedHolder$updateProductRectanngleFeedUi$$inlined$run$lambda$1 implements OnClickListener {
    final /* synthetic */ Product $this_run;
    final /* synthetic */ ProductSquareFeedHolder this$0;

    ProductSquareFeedHolder$updateProductRectanngleFeedUi$$inlined$run$lambda$1(Product product, ProductSquareFeedHolder productSquareFeedHolder) {
        this.$this_run = product;
        this.this$0 = productSquareFeedHolder;
    }

    public final void onClick(View view) {
        if (this.$this_run.isInWishList()) {
            this.this$0.delegate.onRemoveLikeProduct(this.$this_run.getId());
        } else {
            this.this$0.delegate.onAddLikeProduct(this.$this_run.getId());
        }
    }
}
