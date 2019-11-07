package kr.co.popone.fitts.model.repository.commerce;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.Product;
import kr.co.popone.fitts.model.product.ProductEntityExtensionKt;
import kr.co.popone.fitts.model.store.ProductFeedViewData;
import org.jetbrains.annotations.NotNull;

final class FittsCommerceRepositoryImpl$getWishProducts$1<T, R> implements Function<T, R> {
    public static final FittsCommerceRepositoryImpl$getWishProducts$1 INSTANCE = new FittsCommerceRepositoryImpl$getWishProducts$1();

    FittsCommerceRepositoryImpl$getWishProducts$1() {
    }

    @NotNull
    public final List<ProductFeedViewData> apply(@NotNull List<Product> list) {
        Intrinsics.checkParameterIsNotNull(list, "it");
        return ProductEntityExtensionKt.mapToDomain(list);
    }
}
