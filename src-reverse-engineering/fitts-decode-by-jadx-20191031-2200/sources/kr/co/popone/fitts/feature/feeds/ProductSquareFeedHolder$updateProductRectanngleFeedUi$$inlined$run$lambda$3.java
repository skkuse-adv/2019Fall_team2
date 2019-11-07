package kr.co.popone.fitts.feature.feeds;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.model.product.Product;

final class ProductSquareFeedHolder$updateProductRectanngleFeedUi$$inlined$run$lambda$3<T> implements Consumer<WishStateUpdateEvent> {
    final /* synthetic */ Product $this_run;
    final /* synthetic */ ProductSquareFeedHolder this$0;

    ProductSquareFeedHolder$updateProductRectanngleFeedUi$$inlined$run$lambda$3(Product product, ProductSquareFeedHolder productSquareFeedHolder) {
        this.$this_run = product;
        this.this$0 = productSquareFeedHolder;
    }

    public final void accept(WishStateUpdateEvent wishStateUpdateEvent) {
        this.$this_run.setInWishList(wishStateUpdateEvent.isInWishList());
        this.this$0.updateWishIconState(wishStateUpdateEvent.isInWishList());
    }
}
