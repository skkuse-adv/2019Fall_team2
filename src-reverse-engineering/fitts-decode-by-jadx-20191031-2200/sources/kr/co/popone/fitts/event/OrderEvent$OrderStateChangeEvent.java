package kr.co.popone.fitts.event;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.order.OrderListItemViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderEvent$OrderStateChangeEvent {
    private final long orderId;
    @NotNull
    private final List<OrderListItemViewData> orderLineItems;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.order.OrderListItemViewData>, for r3v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent copy$default(kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent r0, long r1, java.util.List<kr.co.popone.fitts.model.order.OrderListItemViewData> r3, int r4, java.lang.Object r5) {
        /*
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0006
            long r1 = r0.orderId
        L_0x0006:
            r4 = r4 & 2
            if (r4 == 0) goto L_0x000c
            java.util.List<kr.co.popone.fitts.model.order.OrderListItemViewData> r3 = r0.orderLineItems
        L_0x000c:
            kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent r0 = r0.copy(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent.copy$default(kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent, long, java.util.List, int, java.lang.Object):kr.co.popone.fitts.event.OrderEvent$OrderStateChangeEvent");
    }

    public final long component1() {
        return this.orderId;
    }

    @NotNull
    public final List<OrderListItemViewData> component2() {
        return this.orderLineItems;
    }

    @NotNull
    public final OrderEvent$OrderStateChangeEvent copy(long j, @NotNull List<OrderListItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "orderLineItems");
        return new OrderEvent$OrderStateChangeEvent(j, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderEvent$OrderStateChangeEvent) {
                OrderEvent$OrderStateChangeEvent orderEvent$OrderStateChangeEvent = (OrderEvent$OrderStateChangeEvent) obj;
                if (!(this.orderId == orderEvent$OrderStateChangeEvent.orderId) || !Intrinsics.areEqual((Object) this.orderLineItems, (Object) orderEvent$OrderStateChangeEvent.orderLineItems)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.orderId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<OrderListItemViewData> list = this.orderLineItems;
        return i + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderStateChangeEvent(orderId=");
        sb.append(this.orderId);
        sb.append(", orderLineItems=");
        sb.append(this.orderLineItems);
        sb.append(")");
        return sb.toString();
    }

    public OrderEvent$OrderStateChangeEvent(long j, @NotNull List<OrderListItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "orderLineItems");
        this.orderId = j;
        this.orderLineItems = list;
    }

    public final long getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final List<OrderListItemViewData> getOrderLineItems() {
        return this.orderLineItems;
    }
}
