package kr.co.popone.fitts.model.repository.commerce;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderDetailListItem;
import kr.co.popone.fitts.model.order.OrderDetailViewData;
import kr.co.popone.fitts.model.order.OrderExtensionKt;
import org.jetbrains.annotations.NotNull;

final class FittsCommerceRepositoryImpl$getOrderLineItem$1<T, R> implements Function<T, R> {
    public static final FittsCommerceRepositoryImpl$getOrderLineItem$1 INSTANCE = new FittsCommerceRepositoryImpl$getOrderLineItem$1();

    FittsCommerceRepositoryImpl$getOrderLineItem$1() {
    }

    @NotNull
    public final OrderDetailViewData apply(@NotNull OrderDetailListItem orderDetailListItem) {
        Intrinsics.checkParameterIsNotNull(orderDetailListItem, "it");
        return OrderExtensionKt.mapToOrderDetailViewData(orderDetailListItem);
    }
}
