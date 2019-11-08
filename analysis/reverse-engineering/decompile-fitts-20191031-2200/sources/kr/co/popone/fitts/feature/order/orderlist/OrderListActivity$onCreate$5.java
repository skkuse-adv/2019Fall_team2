package kr.co.popone.fitts.feature.order.orderlist;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent;
import org.jetbrains.annotations.NotNull;

final class OrderListActivity$onCreate$5<T> implements Predicate<Object> {
    public static final OrderListActivity$onCreate$5 INSTANCE = new OrderListActivity$onCreate$5();

    OrderListActivity$onCreate$5() {
    }

    public final boolean test(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
        return obj instanceof OrderEvent$OrderStateChangeEvent;
    }
}
