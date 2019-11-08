package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.VariantTotalPrice;
import org.jetbrains.annotations.NotNull;

final class ProductRepository$getProductVariantsTotalPrice$1<T, R> implements Function<T, R> {
    public static final ProductRepository$getProductVariantsTotalPrice$1 INSTANCE = new ProductRepository$getProductVariantsTotalPrice$1();

    ProductRepository$getProductVariantsTotalPrice$1() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Integer.valueOf(apply((VariantTotalPrice) obj));
    }

    public final int apply(@NotNull VariantTotalPrice variantTotalPrice) {
        Intrinsics.checkParameterIsNotNull(variantTotalPrice, "it");
        return variantTotalPrice.getTotalPrice();
    }
}
