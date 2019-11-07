package kr.co.popone.fitts.model.order;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderListItem {
    private final long id;
    @SerializedName("line_items")
    @NotNull
    private final List<OrderListLineItem> lineItems;
    @SerializedName("order_created_at")
    @NotNull
    private final Date orderCreatedDate;
    @SerializedName("order_number")
    @NotNull
    private final String orderNumber;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.order.OrderListLineItem>, for r11v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.order.OrderListItem copy$default(kr.co.popone.fitts.model.order.OrderListItem r6, long r7, java.util.Date r9, java.lang.String r10, java.util.List<kr.co.popone.fitts.model.order.OrderListLineItem> r11, int r12, java.lang.Object r13) {
        /*
            r13 = r12 & 1
            if (r13 == 0) goto L_0x0006
            long r7 = r6.id
        L_0x0006:
            r1 = r7
            r7 = r12 & 2
            if (r7 == 0) goto L_0x000d
            java.util.Date r9 = r6.orderCreatedDate
        L_0x000d:
            r3 = r9
            r7 = r12 & 4
            if (r7 == 0) goto L_0x0014
            java.lang.String r10 = r6.orderNumber
        L_0x0014:
            r4 = r10
            r7 = r12 & 8
            if (r7 == 0) goto L_0x001b
            java.util.List<kr.co.popone.fitts.model.order.OrderListLineItem> r11 = r6.lineItems
        L_0x001b:
            r5 = r11
            r0 = r6
            kr.co.popone.fitts.model.order.OrderListItem r6 = r0.copy(r1, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.order.OrderListItem.copy$default(kr.co.popone.fitts.model.order.OrderListItem, long, java.util.Date, java.lang.String, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.order.OrderListItem");
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final Date component2() {
        return this.orderCreatedDate;
    }

    @NotNull
    public final String component3() {
        return this.orderNumber;
    }

    @NotNull
    public final List<OrderListLineItem> component4() {
        return this.lineItems;
    }

    @NotNull
    public final OrderListItem copy(long j, @NotNull Date date, @NotNull String str, @NotNull List<OrderListLineItem> list) {
        Intrinsics.checkParameterIsNotNull(date, "orderCreatedDate");
        Intrinsics.checkParameterIsNotNull(str, "orderNumber");
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        OrderListItem orderListItem = new OrderListItem(j, date, str, list);
        return orderListItem;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderListItem) {
                OrderListItem orderListItem = (OrderListItem) obj;
                if (!(this.id == orderListItem.id) || !Intrinsics.areEqual((Object) this.orderCreatedDate, (Object) orderListItem.orderCreatedDate) || !Intrinsics.areEqual((Object) this.orderNumber, (Object) orderListItem.orderNumber) || !Intrinsics.areEqual((Object) this.lineItems, (Object) orderListItem.lineItems)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Date date = this.orderCreatedDate;
        int i2 = 0;
        int hashCode = (i + (date != null ? date.hashCode() : 0)) * 31;
        String str = this.orderNumber;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<OrderListLineItem> list = this.lineItems;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderListItem(id=");
        sb.append(this.id);
        sb.append(", orderCreatedDate=");
        sb.append(this.orderCreatedDate);
        sb.append(", orderNumber=");
        sb.append(this.orderNumber);
        sb.append(", lineItems=");
        sb.append(this.lineItems);
        sb.append(")");
        return sb.toString();
    }

    public OrderListItem(long j, @NotNull Date date, @NotNull String str, @NotNull List<OrderListLineItem> list) {
        Intrinsics.checkParameterIsNotNull(date, "orderCreatedDate");
        Intrinsics.checkParameterIsNotNull(str, "orderNumber");
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        this.id = j;
        this.orderCreatedDate = date;
        this.orderNumber = str;
        this.lineItems = list;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final Date getOrderCreatedDate() {
        return this.orderCreatedDate;
    }

    @NotNull
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    @NotNull
    public final List<OrderListLineItem> getLineItems() {
        return this.lineItems;
    }
}
