package kr.co.popone.fitts.model.repository.commerce;

import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderExtensionKt;
import kr.co.popone.fitts.model.order.OrderListItem;
import kr.co.popone.fitts.model.order.OrderListViewData;
import org.jetbrains.annotations.NotNull;

final class FittsCommerceRepositoryImpl$getOrderLineItemList$1<T, R> implements Function<T, R> {
    public static final FittsCommerceRepositoryImpl$getOrderLineItemList$1 INSTANCE = new FittsCommerceRepositoryImpl$getOrderLineItemList$1();

    FittsCommerceRepositoryImpl$getOrderLineItemList$1() {
    }

    @NotNull
    public final List<OrderListViewData> apply(@NotNull List<OrderListItem> list) {
        Intrinsics.checkParameterIsNotNull(list, "it");
        return OrderExtensionKt.mapToOrderListItems(list);
    }
}
