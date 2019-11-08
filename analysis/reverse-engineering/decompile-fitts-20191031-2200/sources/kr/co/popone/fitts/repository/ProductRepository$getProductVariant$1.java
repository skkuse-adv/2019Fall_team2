package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.ProductEntityExtensionKt;
import kr.co.popone.fitts.model.product.VariantInfo;
import kr.co.popone.fitts.model.store.OrderableOptionViewData;
import org.jetbrains.annotations.NotNull;

final class ProductRepository$getProductVariant$1<T, R> implements Function<T, R> {
    public static final ProductRepository$getProductVariant$1 INSTANCE = new ProductRepository$getProductVariant$1();

    ProductRepository$getProductVariant$1() {
    }

    @NotNull
    public final OrderableOptionViewData apply(@NotNull VariantInfo variantInfo) {
        Intrinsics.checkParameterIsNotNull(variantInfo, "it");
        return ProductEntityExtensionKt.mapToDomain(variantInfo);
    }
}
