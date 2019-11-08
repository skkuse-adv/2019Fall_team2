package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import kr.co.popone.fitts.model.product.ProductEntityExtensionKt;
import kr.co.popone.fitts.model.product.ProductOrderableItem;
import org.jetbrains.annotations.NotNull;

final class ProductRepository$getProductVariantsPreOrderData$1<T, R> implements Function<T, R> {
    public static final ProductRepository$getProductVariantsPreOrderData$1 INSTANCE = new ProductRepository$getProductVariantsPreOrderData$1();

    ProductRepository$getProductVariantsPreOrderData$1() {
    }

    @NotNull
    public final OrderInfoViewData apply(@NotNull ProductOrderableItem productOrderableItem) {
        Intrinsics.checkParameterIsNotNull(productOrderableItem, "it");
        return ProductEntityExtensionKt.mapToOrderInfoViewData(productOrderableItem);
    }
}
