package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.ProductEntityExtensionKt;
import kr.co.popone.fitts.model.product.VariantOptionResult;
import kr.co.popone.fitts.model.store.ProductVariantViewData;
import org.jetbrains.annotations.NotNull;

final class ProductRepository$getProductVariantOptions$1<T, R> implements Function<T, R> {
    public static final ProductRepository$getProductVariantOptions$1 INSTANCE = new ProductRepository$getProductVariantOptions$1();

    ProductRepository$getProductVariantOptions$1() {
    }

    @NotNull
    public final List<ProductVariantViewData> apply(@NotNull VariantOptionResult variantOptionResult) {
        Intrinsics.checkParameterIsNotNull(variantOptionResult, "it");
        return ProductEntityExtensionKt.mapToDomain(variantOptionResult);
    }
}
