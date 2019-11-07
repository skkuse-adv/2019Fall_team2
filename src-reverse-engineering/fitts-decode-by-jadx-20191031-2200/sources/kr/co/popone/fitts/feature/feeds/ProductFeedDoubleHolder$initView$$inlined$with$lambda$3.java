package kr.co.popone.fitts.feature.feeds;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.model.datamodel.service.view.ProductDoubleFeedView;
import kr.co.popone.fitts.model.product.Product;

final class ProductFeedDoubleHolder$initView$$inlined$with$lambda$3 implements OnClickListener {
    final /* synthetic */ Product $item$inlined;
    final /* synthetic */ ProductFeedDoubleHolder this$0;

    ProductFeedDoubleHolder$initView$$inlined$with$lambda$3(ProductFeedDoubleHolder productFeedDoubleHolder, Product product, ProductDoubleFeedView productDoubleFeedView) {
        this.this$0 = productFeedDoubleHolder;
        this.$item$inlined = product;
    }

    public final void onClick(View view) {
        if (this.$item$inlined.isInWishList()) {
            this.this$0.getDelegate().onRemoveLikeProduct(this.$item$inlined.getId());
        } else {
            this.this$0.getDelegate().onAddLikeProduct(this.$item$inlined.getId());
        }
    }
}
