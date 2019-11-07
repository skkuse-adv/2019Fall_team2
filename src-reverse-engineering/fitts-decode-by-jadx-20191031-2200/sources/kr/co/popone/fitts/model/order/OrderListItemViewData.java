package kr.co.popone.fitts.model.order;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.StoreContact;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderListItemViewData {
    @NotNull
    private final List<OrderListDetailViewData> orderListDetails;
    private final int productPrice;
    private final int salesPrice;
    private final int shippingPrice;
    @NotNull
    private final StoreContact storeContact;
    @NotNull
    private final String storeName;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.order.OrderListDetailViewData>, for r10v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.order.OrderListItemViewData copy$default(kr.co.popone.fitts.model.order.OrderListItemViewData r4, java.lang.String r5, int r6, int r7, int r8, kr.co.popone.fitts.model.store.StoreContact r9, java.util.List<kr.co.popone.fitts.model.order.OrderListDetailViewData> r10, int r11, java.lang.Object r12) {
        /*
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            java.lang.String r5 = r4.storeName
        L_0x0006:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000c
            int r6 = r4.productPrice
        L_0x000c:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0013
            int r7 = r4.shippingPrice
        L_0x0013:
            r0 = r7
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001a
            int r8 = r4.salesPrice
        L_0x001a:
            r1 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0021
            kr.co.popone.fitts.model.store.StoreContact r9 = r4.storeContact
        L_0x0021:
            r2 = r9
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            java.util.List<kr.co.popone.fitts.model.order.OrderListDetailViewData> r10 = r4.orderListDetails
        L_0x0028:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            kr.co.popone.fitts.model.order.OrderListItemViewData r4 = r6.copy(r7, r8, r9, r10, r11, r12)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.order.OrderListItemViewData.copy$default(kr.co.popone.fitts.model.order.OrderListItemViewData, java.lang.String, int, int, int, kr.co.popone.fitts.model.store.StoreContact, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.order.OrderListItemViewData");
    }

    @NotNull
    public final String component1() {
        return this.storeName;
    }

    public final int component2() {
        return this.productPrice;
    }

    public final int component3() {
        return this.shippingPrice;
    }

    public final int component4() {
        return this.salesPrice;
    }

    @NotNull
    public final StoreContact component5() {
        return this.storeContact;
    }

    @NotNull
    public final List<OrderListDetailViewData> component6() {
        return this.orderListDetails;
    }

    @NotNull
    public final OrderListItemViewData copy(@NotNull String str, int i, int i2, int i3, @NotNull StoreContact storeContact2, @NotNull List<OrderListDetailViewData> list) {
        Intrinsics.checkParameterIsNotNull(str, "storeName");
        Intrinsics.checkParameterIsNotNull(storeContact2, "storeContact");
        Intrinsics.checkParameterIsNotNull(list, "orderListDetails");
        OrderListItemViewData orderListItemViewData = new OrderListItemViewData(str, i, i2, i3, storeContact2, list);
        return orderListItemViewData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderListItemViewData) {
                OrderListItemViewData orderListItemViewData = (OrderListItemViewData) obj;
                if (Intrinsics.areEqual((Object) this.storeName, (Object) orderListItemViewData.storeName)) {
                    if (this.productPrice == orderListItemViewData.productPrice) {
                        if (this.shippingPrice == orderListItemViewData.shippingPrice) {
                            if (!(this.salesPrice == orderListItemViewData.salesPrice) || !Intrinsics.areEqual((Object) this.storeContact, (Object) orderListItemViewData.storeContact) || !Intrinsics.areEqual((Object) this.orderListDetails, (Object) orderListItemViewData.orderListDetails)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.storeName;
        int i = 0;
        int hashCode = (((((((str != null ? str.hashCode() : 0) * 31) + this.productPrice) * 31) + this.shippingPrice) * 31) + this.salesPrice) * 31;
        StoreContact storeContact2 = this.storeContact;
        int hashCode2 = (hashCode + (storeContact2 != null ? storeContact2.hashCode() : 0)) * 31;
        List<OrderListDetailViewData> list = this.orderListDetails;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderListItemViewData(storeName=");
        sb.append(this.storeName);
        sb.append(", productPrice=");
        sb.append(this.productPrice);
        sb.append(", shippingPrice=");
        sb.append(this.shippingPrice);
        sb.append(", salesPrice=");
        sb.append(this.salesPrice);
        sb.append(", storeContact=");
        sb.append(this.storeContact);
        sb.append(", orderListDetails=");
        sb.append(this.orderListDetails);
        sb.append(")");
        return sb.toString();
    }

    public OrderListItemViewData(@NotNull String str, int i, int i2, int i3, @NotNull StoreContact storeContact2, @NotNull List<OrderListDetailViewData> list) {
        Intrinsics.checkParameterIsNotNull(str, "storeName");
        Intrinsics.checkParameterIsNotNull(storeContact2, "storeContact");
        Intrinsics.checkParameterIsNotNull(list, "orderListDetails");
        this.storeName = str;
        this.productPrice = i;
        this.shippingPrice = i2;
        this.salesPrice = i3;
        this.storeContact = storeContact2;
        this.orderListDetails = list;
    }

    @NotNull
    public final String getStoreName() {
        return this.storeName;
    }

    public final int getProductPrice() {
        return this.productPrice;
    }

    public final int getShippingPrice() {
        return this.shippingPrice;
    }

    public final int getSalesPrice() {
        return this.salesPrice;
    }

    @NotNull
    public final StoreContact getStoreContact() {
        return this.storeContact;
    }

    @NotNull
    public final List<OrderListDetailViewData> getOrderListDetails() {
        return this.orderListDetails;
    }
}
