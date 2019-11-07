package kr.co.popone.fitts.model.cart;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.store.StoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartPriceLineItem {
    @SerializedName("order_price")
    private final int lineItemOrderPrice;
    @SerializedName("shipping_price")
    private final int lineItemShippingTotalPrice;
    @SerializedName("product_price")
    private final int lineItemTotalPrice;
    @SerializedName("line_item_variants")
    @NotNull
    private final List<Object> lineItemVariants;
    @SerializedName("shop")
    @NotNull
    private final StoreInfo storeInfo;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.Object>, for r5v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.cart.CartPriceLineItem copy$default(kr.co.popone.fitts.model.cart.CartPriceLineItem r3, kr.co.popone.fitts.model.store.StoreInfo r4, java.util.List<java.lang.Object> r5, int r6, int r7, int r8, int r9, java.lang.Object r10) {
        /*
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            kr.co.popone.fitts.model.store.StoreInfo r4 = r3.storeInfo
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            java.util.List<java.lang.Object> r5 = r3.lineItemVariants
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            int r6 = r3.lineItemTotalPrice
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            int r7 = r3.lineItemShippingTotalPrice
        L_0x001a:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            int r8 = r3.lineItemOrderPrice
        L_0x0021:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            kr.co.popone.fitts.model.cart.CartPriceLineItem r3 = r5.copy(r6, r7, r8, r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.cart.CartPriceLineItem.copy$default(kr.co.popone.fitts.model.cart.CartPriceLineItem, kr.co.popone.fitts.model.store.StoreInfo, java.util.List, int, int, int, int, java.lang.Object):kr.co.popone.fitts.model.cart.CartPriceLineItem");
    }

    @NotNull
    public final StoreInfo component1() {
        return this.storeInfo;
    }

    @NotNull
    public final List<Object> component2() {
        return this.lineItemVariants;
    }

    public final int component3() {
        return this.lineItemTotalPrice;
    }

    public final int component4() {
        return this.lineItemShippingTotalPrice;
    }

    public final int component5() {
        return this.lineItemOrderPrice;
    }

    @NotNull
    public final CartPriceLineItem copy(@NotNull StoreInfo storeInfo2, @NotNull List<Object> list, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(storeInfo2, "storeInfo");
        Intrinsics.checkParameterIsNotNull(list, "lineItemVariants");
        CartPriceLineItem cartPriceLineItem = new CartPriceLineItem(storeInfo2, list, i, i2, i3);
        return cartPriceLineItem;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartPriceLineItem) {
                CartPriceLineItem cartPriceLineItem = (CartPriceLineItem) obj;
                if (Intrinsics.areEqual((Object) this.storeInfo, (Object) cartPriceLineItem.storeInfo) && Intrinsics.areEqual((Object) this.lineItemVariants, (Object) cartPriceLineItem.lineItemVariants)) {
                    if (this.lineItemTotalPrice == cartPriceLineItem.lineItemTotalPrice) {
                        if (this.lineItemShippingTotalPrice == cartPriceLineItem.lineItemShippingTotalPrice) {
                            if (this.lineItemOrderPrice == cartPriceLineItem.lineItemOrderPrice) {
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
        StoreInfo storeInfo2 = this.storeInfo;
        int i = 0;
        int hashCode = (storeInfo2 != null ? storeInfo2.hashCode() : 0) * 31;
        List<Object> list = this.lineItemVariants;
        if (list != null) {
            i = list.hashCode();
        }
        return ((((((hashCode + i) * 31) + this.lineItemTotalPrice) * 31) + this.lineItemShippingTotalPrice) * 31) + this.lineItemOrderPrice;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartPriceLineItem(storeInfo=");
        sb.append(this.storeInfo);
        sb.append(", lineItemVariants=");
        sb.append(this.lineItemVariants);
        sb.append(", lineItemTotalPrice=");
        sb.append(this.lineItemTotalPrice);
        sb.append(", lineItemShippingTotalPrice=");
        sb.append(this.lineItemShippingTotalPrice);
        sb.append(", lineItemOrderPrice=");
        sb.append(this.lineItemOrderPrice);
        sb.append(")");
        return sb.toString();
    }

    public CartPriceLineItem(@NotNull StoreInfo storeInfo2, @NotNull List<Object> list, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(storeInfo2, "storeInfo");
        Intrinsics.checkParameterIsNotNull(list, "lineItemVariants");
        this.storeInfo = storeInfo2;
        this.lineItemVariants = list;
        this.lineItemTotalPrice = i;
        this.lineItemShippingTotalPrice = i2;
        this.lineItemOrderPrice = i3;
    }

    @NotNull
    public final StoreInfo getStoreInfo() {
        return this.storeInfo;
    }

    @NotNull
    public final List<Object> getLineItemVariants() {
        return this.lineItemVariants;
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
