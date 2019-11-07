package kr.co.popone.fitts.model.cart;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartPriceItemEntity {
    @SerializedName("line_items")
    @NotNull
    private final List<CartPriceLineItem> lineItems;
    @SerializedName("total_order_price")
    private final int totalOrderPrice;
    @SerializedName("total_quantity_of_variants")
    private final int totalProductCount;
    @SerializedName("total_product_price")
    private final int totalProductPrice;
    @SerializedName("total_shipping_price")
    private final int totalShippingPrice;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.cart.CartPriceLineItem>, for r4v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.cart.CartPriceItemEntity copy$default(kr.co.popone.fitts.model.cart.CartPriceItemEntity r3, java.util.List<kr.co.popone.fitts.model.cart.CartPriceLineItem> r4, int r5, int r6, int r7, int r8, int r9, java.lang.Object r10) {
        /*
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            java.util.List<kr.co.popone.fitts.model.cart.CartPriceLineItem> r4 = r3.lineItems
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            int r5 = r3.totalProductCount
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            int r6 = r3.totalProductPrice
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            int r7 = r3.totalShippingPrice
        L_0x001a:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            int r8 = r3.totalOrderPrice
        L_0x0021:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            kr.co.popone.fitts.model.cart.CartPriceItemEntity r3 = r5.copy(r6, r7, r8, r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.cart.CartPriceItemEntity.copy$default(kr.co.popone.fitts.model.cart.CartPriceItemEntity, java.util.List, int, int, int, int, int, java.lang.Object):kr.co.popone.fitts.model.cart.CartPriceItemEntity");
    }

    @NotNull
    public final List<CartPriceLineItem> component1() {
        return this.lineItems;
    }

    public final int component2() {
        return this.totalProductCount;
    }

    public final int component3() {
        return this.totalProductPrice;
    }

    public final int component4() {
        return this.totalShippingPrice;
    }

    public final int component5() {
        return this.totalOrderPrice;
    }

    @NotNull
    public final CartPriceItemEntity copy(@NotNull List<CartPriceLineItem> list, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        CartPriceItemEntity cartPriceItemEntity = new CartPriceItemEntity(list, i, i2, i3, i4);
        return cartPriceItemEntity;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartPriceItemEntity) {
                CartPriceItemEntity cartPriceItemEntity = (CartPriceItemEntity) obj;
                if (Intrinsics.areEqual((Object) this.lineItems, (Object) cartPriceItemEntity.lineItems)) {
                    if (this.totalProductCount == cartPriceItemEntity.totalProductCount) {
                        if (this.totalProductPrice == cartPriceItemEntity.totalProductPrice) {
                            if (this.totalShippingPrice == cartPriceItemEntity.totalShippingPrice) {
                                if (this.totalOrderPrice == cartPriceItemEntity.totalOrderPrice) {
                                    return true;
                                }
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
        List<CartPriceLineItem> list = this.lineItems;
        return ((((((((list != null ? list.hashCode() : 0) * 31) + this.totalProductCount) * 31) + this.totalProductPrice) * 31) + this.totalShippingPrice) * 31) + this.totalOrderPrice;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartPriceItemEntity(lineItems=");
        sb.append(this.lineItems);
        sb.append(", totalProductCount=");
        sb.append(this.totalProductCount);
        sb.append(", totalProductPrice=");
        sb.append(this.totalProductPrice);
        sb.append(", totalShippingPrice=");
        sb.append(this.totalShippingPrice);
        sb.append(", totalOrderPrice=");
        sb.append(this.totalOrderPrice);
        sb.append(")");
        return sb.toString();
    }

    public CartPriceItemEntity(@NotNull List<CartPriceLineItem> list, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        this.lineItems = list;
        this.totalProductCount = i;
        this.totalProductPrice = i2;
        this.totalShippingPrice = i3;
        this.totalOrderPrice = i4;
    }

    @NotNull
    public final List<CartPriceLineItem> getLineItems() {
        return this.lineItems;
    }

    public final int getTotalProductCount() {
        return this.totalProductCount;
    }

    public final int getTotalProductPrice() {
        return this.totalProductPrice;
    }

    public final int getTotalShippingPrice() {
        return this.totalShippingPrice;
    }

    public final int getTotalOrderPrice() {
        return this.totalOrderPrice;
    }
}
