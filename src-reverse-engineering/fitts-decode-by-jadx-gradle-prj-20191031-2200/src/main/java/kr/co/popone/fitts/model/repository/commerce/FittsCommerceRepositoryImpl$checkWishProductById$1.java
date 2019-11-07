package kr.co.popone.fitts.model.repository.commerce;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.wish.WishProduct;
import org.jetbrains.annotations.NotNull;

final class FittsCommerceRepositoryImpl$checkWishProductById$1<T, R> implements Function<T, R> {
    public static final FittsCommerceRepositoryImpl$checkWishProductById$1 INSTANCE = new FittsCommerceRepositoryImpl$checkWishProductById$1();

    FittsCommerceRepositoryImpl$checkWishProductById$1() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((WishProduct) obj));
    }

    public final boolean apply(@NotNull WishProduct wishProduct) {
        Intrinsics.checkParameterIsNotNull(wishProduct, "it");
        return wishProduct.isWishProduct();
    }
}
