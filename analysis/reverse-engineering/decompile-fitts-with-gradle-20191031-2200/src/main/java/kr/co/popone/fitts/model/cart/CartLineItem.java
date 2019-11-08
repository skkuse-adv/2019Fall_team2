package kr.co.popone.fitts.model.cart;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartLineItem {
    private final long id;
    @SerializedName("order_price")
    private final int lineItemOrderPrice;
    @SerializedName("shipping_price")
    private final int lineItemShippingTotalPrice;
    @SerializedName("product_price")
    private final int lineItemTotalPrice;
    @SerializedName("line_item_variants")
    @NotNull
    private final List<CartLineItemVariants> lineItemVariants;
    @SerializedName("shop")
    @NotNull
    private final StoreInfo store;

    @NotNull
    public static /* synthetic */ CartLineItem copy$default(CartLineItem cartLineItem, long j, List list, StoreInfo storeInfo, int i, int i2, int i3, int i4, Object obj) {
        CartLineItem cartLineItem2 = cartLineItem;
        return cartLineItem.copy((i4 & 1) != 0 ? cartLineItem2.id : j, (i4 & 2) != 0 ? cartLineItem2.lineItemVariants : list, (i4 & 4) != 0 ? cartLineItem2.store : storeInfo, (i4 & 8) != 0 ? cartLineItem2.lineItemTotalPrice : i, (i4 & 16) != 0 ? cartLineItem2.lineItemShippingTotalPrice : i2, (i4 & 32) != 0 ? cartLineItem2.lineItemOrderPrice : i3);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final List<CartLineItemVariants> component2() {
        return this.lineItemVariants;
    }

    @NotNull
    public final StoreInfo component3() {
        return this.store;
    }

    public final int component4() {
        return this.lineItemTotalPrice;
    }

    public final int component5() {
        return this.lineItemShippingTotalPrice;
    }

    public final int component6() {
        return this.lineItemOrderPrice;
    }

    @NotNull
    public final CartLineItem copy(long j, @NotNull List<CartLineItemVariants> list, @NotNull StoreInfo storeInfo, int i, int i2, int i3) {
        List<CartLineItemVariants> list2 = list;
        Intrinsics.checkParameterIsNotNull(list, "lineItemVariants");
        StoreInfo storeInfo2 = storeInfo;
        Intrinsics.checkParameterIsNotNull(storeInfo, "store");
        CartLineItem cartLineItem = new CartLineItem(j, list2, storeInfo2, i, i2, i3);
        return cartLineItem;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartLineItem) {
                CartLineItem cartLineItem = (CartLineItem) obj;
                if ((this.id == cartLineItem.id) && Intrinsics.areEqual((Object) this.lineItemVariants, (Object) cartLineItem.lineItemVariants) && Intrinsics.areEqual((Object) this.store, (Object) cartLineItem.store)) {
                    if (this.lineItemTotalPrice == cartLineItem.lineItemTotalPrice) {
                        if (this.lineItemShippingTotalPrice == cartLineItem.lineItemShippingTotalPrice) {
                            if (this.lineItemOrderPrice == cartLineItem.lineItemOrderPrice) {
                                return true;
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
        List<CartLineItemVariants> list = this.lineItemVariants;
        int i2 = 0;
        int hashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        StoreInfo storeInfo = this.store;
        if (storeInfo != null) {
            i2 = storeInfo.hashCode();
        }
        return ((((((hashCode + i2) * 31) + this.lineItemTotalPrice) * 31) + this.lineItemShippingTotalPrice) * 31) + this.lineItemOrderPrice;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartLineItem(id=");
        sb.append(this.id);
        sb.append(", lineItemVariants=");
        sb.append(this.lineItemVariants);
        sb.append(", store=");
        sb.append(this.store);
        sb.append(", lineItemTotalPrice=");
        sb.append(this.lineItemTotalPrice);
        sb.append(", lineItemShippingTotalPrice=");
        sb.append(this.lineItemShippingTotalPrice);
        sb.append(", lineItemOrderPrice=");
        sb.append(this.lineItemOrderPrice);
        sb.append(")");
        return sb.toString();
    }

    public CartLineItem(long j, @NotNull List<CartLineItemVariants> list, @NotNull StoreInfo storeInfo, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(list, "lineItemVariants");
        Intrinsics.checkParameterIsNotNull(storeInfo, "store");
        this.id = j;
        this.lineItemVariants = list;
        this.store = storeInfo;
        this.lineItemTotalPrice = i;
        this.lineItemShippingTotalPrice = i2;
        this.lineItemOrderPrice = i3;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final List<CartLineItemVariants> getLineItemVariants() {
        return this.lineItemVariants;
    }

    @NotNull
    public final StoreInfo getStore() {
        return this.store;
    }

    public final int getLineItemTotalPrice() {
        return this.lineItemTotalPrice;
    }

    public final int getLineItemShippingTotalPrice() {
        return this.lineItemShippingTotalPrice;
    }

    public final int getLineItemOrderPrice() {
        return this.lineItemOrderPrice;
    }
}
