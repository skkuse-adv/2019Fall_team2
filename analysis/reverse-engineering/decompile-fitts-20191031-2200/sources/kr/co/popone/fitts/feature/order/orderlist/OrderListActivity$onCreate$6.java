package kr.co.popone.fitts.feature.order.orderlist;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent;
import org.jetbrains.annotations.NotNull;

final class OrderListActivity$onCreate$6<T, R> implements Function<T, R> {
    public static final OrderListActivity$onCreate$6 INSTANCE = new OrderListActivity$onCreate$6();

    OrderListActivity$onCreate$6() {
    }

    @NotNull
    public final OrderEvent$OrderStateChangeEvent apply(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
        return (OrderEvent$OrderStateChangeEvent) obj;
    }
}
