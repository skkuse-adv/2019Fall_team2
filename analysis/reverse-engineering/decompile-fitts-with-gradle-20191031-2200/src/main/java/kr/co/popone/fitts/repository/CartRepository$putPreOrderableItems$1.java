package kr.co.popone.fitts.repository;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartEntityExtensionKt;
import kr.co.popone.fitts.model.cart.CartOrderableItem;
import kr.co.popone.fitts.model.order.OrderInfoViewData;
import org.jetbrains.annotations.NotNull;

final class CartRepository$putPreOrderableItems$1<T, R> implements Function<T, R> {
    public static final CartRepository$putPreOrderableItems$1 INSTANCE = new CartRepository$putPreOrderableItems$1();

    CartRepository$putPreOrderableItems$1() {
    }

    @NotNull
    public final OrderInfoViewData apply(@NotNull CartOrderableItem cartOrderableItem) {
        Intrinsics.checkParameterIsNotNull(cartOrderableItem, "it");
        return CartEntityExtensionKt.mapToOrderableViewData(cartOrderableItem);
    }
}
