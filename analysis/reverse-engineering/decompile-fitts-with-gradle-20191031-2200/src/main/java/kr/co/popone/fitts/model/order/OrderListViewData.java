package kr.co.popone.fitts.model.order;

import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderListViewData {
    @NotNull
    private final Date orderDate;
    private final long orderId;
    @NotNull
    private List<OrderListItemViewData> orderListItems;
    @NotNull
    private final String orderNumber;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.order.OrderListItemViewData>, for r11v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.order.OrderListViewData copy$default(kr.co.popone.fitts.model.order.OrderListViewData r6, long r7, java.util.Date r9, java.lang.String r10, java.util.List<kr.co.popone.fitts.model.order.OrderListItemViewData> r11, int r12, java.lang.Object r13) {
        /*
            r13 = r12 & 1
            if (r13 == 0) goto L_0x0006
            long r7 = r6.orderId
        L_0x0006:
            r1 = r7
            r7 = r12 & 2
            if (r7 == 0) goto L_0x000d
            java.util.Date r9 = r6.orderDate
        L_0x000d:
            r3 = r9
            r7 = r12 & 4
            if (r7 == 0) goto L_0x0014
            java.lang.String r10 = r6.orderNumber
        L_0x0014:
            r4 = r10
            r7 = r12 & 8
            if (r7 == 0) goto L_0x001b
            java.util.List<kr.co.popone.fitts.model.order.OrderListItemViewData> r11 = r6.orderListItems
        L_0x001b:
            r5 = r11
            r0 = r6
            kr.co.popone.fitts.model.order.OrderListViewData r6 = r0.copy(r1, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.order.OrderListViewData.copy$default(kr.co.popone.fitts.model.order.OrderListViewData, long, java.util.Date, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.order.OrderListViewData");
    }

    public final long component1() {
        return this.orderId;
    }

    @NotNull
    public final Date component2() {
        return this.orderDate;
    }

    @NotNull
    public final String component3() {
        return this.orderNumber;
    }

    @NotNull
    public final List<OrderListItemViewData> component4() {
        return this.orderListItems;
    }

    @NotNull
    public final OrderListViewData copy(long j, @NotNull Date date, @NotNull String str, @NotNull List<OrderListItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(date, "orderDate");
        Intrinsics.checkParameterIsNotNull(str, "orderNumber");
        Intrinsics.checkParameterIsNotNull(list, "orderListItems");
        OrderListViewData orderListViewData = new OrderListViewData(j, date, str, list);
        return orderListViewData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderListViewData) {
                OrderListViewData orderListViewData = (OrderListViewData) obj;
                if (!(this.orderId == orderListViewData.orderId) || !Intrinsics.areEqual((Object) this.orderDate, (Object) orderListViewData.orderDate) || !Intrinsics.areEqual((Object) this.orderNumber, (Object) orderListViewData.orderNumber) || !Intrinsics.areEqual((Object) this.orderListItems, (Object) orderListViewData.orderListItems)) {
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
        Date date = this.orderDate;
        int i2 = 0;
        int hashCode = (i + (date != null ? date.hashCode() : 0)) * 31;
        String str = this.orderNumber;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<OrderListItemViewData> list = this.orderListItems;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderListViewData(orderId=");
        sb.append(this.orderId);
        sb.append(", orderDate=");
        sb.append(this.orderDate);
        sb.append(", orderNumber=");
        sb.append(this.orderNumber);
        sb.append(", orderListItems=");
        sb.append(this.orderListItems);
        sb.append(")");
        return sb.toString();
    }

    public OrderListViewData(long j, @NotNull Date date, @NotNull String str, @NotNull List<OrderListItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(date, "orderDate");
        Intrinsics.checkParameterIsNotNull(str, "orderNumber");
        Intrinsics.checkParameterIsNotNull(list, "orderListItems");
        this.orderId = j;
        this.orderDate = date;
        this.orderNumber = str;
        this.orderListItems = list;
    }

    public final long getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final Date getOrderDate() {
        return this.orderDate;
    }

    @NotNull
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    @NotNull
    public final List<OrderListItemViewData> getOrderListItems() {
        return this.orderListItems;
    }

    public final void setOrderListItems(@NotNull List<OrderListItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.orderListItems = list;
    }
}
