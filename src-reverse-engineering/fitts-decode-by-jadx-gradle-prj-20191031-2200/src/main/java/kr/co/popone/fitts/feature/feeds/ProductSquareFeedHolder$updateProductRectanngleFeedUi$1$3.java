package kr.co.popone.fitts.feature.feeds;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.WishStateUpdateEvent;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;

final class ProductSquareFeedHolder$updateProductRectanngleFeedUi$1$3<T> implements Predicate<WishStateUpdateEvent> {
    final /* synthetic */ Product $this_run;

    ProductSquareFeedHolder$updateProductRectanngleFeedUi$1$3(Product product) {
        this.$this_run = product;
    }

    public final boolean test(@NotNull WishStateUpdateEvent wishStateUpdateEvent) {
        Intrinsics.checkParameterIsNotNull(wishStateUpdateEvent, "it");
        return this.$this_run.getId() == wishStateUpdateEvent.getProductId();
    }
}
