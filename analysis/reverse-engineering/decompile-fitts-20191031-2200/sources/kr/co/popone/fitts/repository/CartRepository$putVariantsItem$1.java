package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartEntityExtensionKt;
import kr.co.popone.fitts.model.cart.CartLineItemEntity;
import kr.co.popone.fitts.model.cart.CartLineItemsDomain;
import org.jetbrains.annotations.NotNull;

final class CartRepository$putVariantsItem$1<T, R> implements Function<T, R> {
    public static final CartRepository$putVariantsItem$1 INSTANCE = new CartRepository$putVariantsItem$1();

    CartRepository$putVariantsItem$1() {
    }

    @NotNull
    public final CartLineItemsDomain apply(@NotNull CartLineItemEntity cartLineItemEntity) {
        Intrinsics.checkParameterIsNotNull(cartLineItemEntity, "it");
        return CartEntityExtensionKt.mapToCartLineItemDomain(cartLineItemEntity);
    }
}
