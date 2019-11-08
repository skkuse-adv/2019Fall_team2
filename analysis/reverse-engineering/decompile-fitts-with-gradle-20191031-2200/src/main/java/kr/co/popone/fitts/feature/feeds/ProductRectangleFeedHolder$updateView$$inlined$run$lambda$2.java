package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.product.Product;

final class ProductRectangleFeedHolder$updateView$$inlined$run$lambda$2 implements OnClickListener {
    final /* synthetic */ Product $this_run;
    final /* synthetic */ ProductRectangleFeedHolder this$0;

    ProductRectangleFeedHolder$updateView$$inlined$run$lambda$2(Product product, ProductRectangleFeedHolder productRectangleFeedHolder) {
        this.$this_run = product;
        this.this$0 = productRectangleFeedHolder;
    }

    public final void onClick(View view) {
        String mobileLinkUrl = this.$this_run.getMobileLinkUrl();
        if (mobileLinkUrl != null) {
            this.this$0.delegate.onProductClick(this.$this_run.getId(), mobileLinkUrl);
        }
    }
}
