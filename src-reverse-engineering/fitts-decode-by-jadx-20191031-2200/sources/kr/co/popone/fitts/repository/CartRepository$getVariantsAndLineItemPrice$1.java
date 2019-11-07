package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartEntityExtensionKt;
import kr.co.popone.fitts.model.cart.CartLineItemsDomain;
import kr.co.popone.fitts.model.cart.CartPriceItemEntity;
import org.jetbrains.annotations.NotNull;

final class CartRepository$getVariantsAndLineItemPrice$1<T, R> implements Function<T, R> {
    public static final CartRepository$getVariantsAndLineItemPrice$1 INSTANCE = new CartRepository$getVariantsAndLineItemPrice$1();

    CartRepository$getVariantsAndLineItemPrice$1() {
    }

    @NotNull
    public final CartLineItemsDomain apply(@NotNull CartPriceItemEntity cartPriceItemEntity) {
        Intrinsics.checkParameterIsNotNull(cartPriceItemEntity, "it");
        return CartEntityExtensionKt.mapToCartLineItemsDomain(cartPriceItemEntity);
    }
}
