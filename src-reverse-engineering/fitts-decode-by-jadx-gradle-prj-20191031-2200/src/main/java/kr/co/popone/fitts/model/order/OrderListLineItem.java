package kr.co.popone.fitts.model.order;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderListLineItem {
    private final long id;
    @SerializedName("line_item_variants")
    @NotNull
    private final List<OrderListLineItemVariant> lineItemVariants;
    @SerializedName("order_price")
    private final int orderPrice;
    @SerializedName("product_price")
    private final int productPrice;
    @SerializedName("shipping_price")
    private final int shippingPrice;
    @SerializedName("shop")
    @NotNull
    private final StoreInfo store;

    @NotNull
    public static /* synthetic */ OrderListLineItem copy$default(OrderListLineItem orderListLineItem, long j, StoreInfo storeInfo, int i, int i2, int i3, List list, int i4, Object obj) {
        OrderListLineItem orderListLineItem2 = orderListLineItem;
        return orderListLineItem.copy((i4 & 1) != 0 ? orderListLineItem2.id : j, (i4 & 2) != 0 ? orderListLineItem2.store : storeInfo, (i4 & 4) != 0 ? orderListLineItem2.productPrice : i, (i4 & 8) != 0 ? orderListLineItem2.shippingPrice : i2, (i4 & 16) != 0 ? orderListLineItem2.orderPrice : i3, (i4 & 32) != 0 ? orderListLineItem2.lineItemVariants : list);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final StoreInfo component2() {
        return this.store;
    }

    public final int component3() {
        return this.productPrice;
    }

    public final int component4() {
        return this.shippingPrice;
    }

    public final int component5() {
        return this.orderPrice;
    }

    @NotNull
    public final List<OrderListLineItemVariant> component6() {
        return this.lineItemVariants;
    }

    @NotNull
    public final OrderListLineItem copy(long j, @NotNull StoreInfo storeInfo, int i, int i2, int i3, @NotNull List<OrderListLineItemVariant> list) {
        StoreInfo storeInfo2 = storeInfo;
        Intrinsics.checkParameterIsNotNull(storeInfo, "store");
        List<OrderListLineItemVariant> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "lineItemVariants");
        OrderListLineItem orderListLineItem = new OrderListLineItem(j, storeInfo2, i, i2, i3, list2);
        return orderListLineItem;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderListLineItem) {
                OrderListLineItem orderListLineItem = (OrderListLineItem) obj;
                if ((this.id == orderListLineItem.id) && Intrinsics.areEqual((Object) this.store, (Object) orderListLineItem.store)) {
                    if (this.productPrice == orderListLineItem.productPrice) {
                        if (this.shippingPrice == orderListLineItem.shippingPrice) {
                            if (!(this.orderPrice == orderListLineItem.orderPrice) || !Intrinsics.areEqual((Object) this.lineItemVariants, (Object) orderListLineItem.lineItemVariants)) {
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
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        StoreInfo storeInfo = this.store;
        int i2 = 0;
        int hashCode = (((((((i + (storeInfo != null ? storeInfo.hashCode() : 0)) * 31) + this.productPrice) * 31) + this.shippingPrice) * 31) + this.orderPrice) * 31;
        List<OrderListLineItemVariant> list = this.lineItemVariants;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderListLineItem(id=");
        sb.append(this.id);
        sb.append(", store=");
        sb.append(this.store);
        sb.append(", productPrice=");
        sb.append(this.productPrice);
        sb.append(", shippingPrice=");
        sb.append(this.shippingPrice);
        sb.append(", orderPrice=");
        sb.append(this.orderPrice);
        sb.append(", lineItemVariants=");
        sb.append(this.lineItemVariants);
        sb.append(")");
        return sb.toString();
    }

    public OrderListLineItem(long j, @NotNull StoreInfo storeInfo, int i, int i2, int i3, @NotNull List<OrderListLineItemVariant> list) {
        Intrinsics.checkParameterIsNotNull(storeInfo, "store");
        Intrinsics.checkParameterIsNotNull(list, "lineItemVariants");
        this.id = j;
        this.store = storeInfo;
        this.productPrice = i;
        this.shippingPrice = i2;
        this.orderPrice = i3;
        this.lineItemVariants = list;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final StoreInfo getStore() {
        return this.store;
    }

    public final int getProductPrice() {
        return this.productPrice;
    }

    public final int getShippingPrice() {
        return this.shippingPrice;
    }

    public final int getOrderPrice() {
        return this.orderPrice;
    }

    @NotNull
    public final List<OrderListLineItemVariant> getLineItemVariants() {
        return this.lineItemVariants;
    }
}
