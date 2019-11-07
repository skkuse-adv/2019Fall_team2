package kr.co.popone.fitts.model.cart;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartLineItemEntity {
    @SerializedName("line_items")
    @NotNull
    private final List<CartLineItem> lineItems;
    @SerializedName("special_discount_price")
    @Nullable
    private final Integer specialDiscountPrice;
    @SerializedName("total_order_price")
    private final int totalOrderPrice;
    @SerializedName("total_quantity_of_variants")
    private final int totalProductCount;
    @SerializedName("total_product_price")
    private final int totalProductPrice;
    @SerializedName("total_shipping_price")
    private final int totalShippingPrice;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.cart.CartLineItem>, for r5v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.cart.CartLineItemEntity copy$default(kr.co.popone.fitts.model.cart.CartLineItemEntity r4, java.util.List<kr.co.popone.fitts.model.cart.CartLineItem> r5, java.lang.Integer r6, int r7, int r8, int r9, int r10, int r11, java.lang.Object r12) {
        /*
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            java.util.List<kr.co.popone.fitts.model.cart.CartLineItem> r5 = r4.lineItems
        L_0x0006:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000c
            java.lang.Integer r6 = r4.specialDiscountPrice
        L_0x000c:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0013
            int r7 = r4.totalProductCount
        L_0x0013:
            r0 = r7
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001a
            int r8 = r4.totalProductPrice
        L_0x001a:
            r1 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0021
            int r9 = r4.totalShippingPrice
        L_0x0021:
            r2 = r9
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            int r10 = r4.totalOrderPrice
        L_0x0028:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            kr.co.popone.fitts.model.cart.CartLineItemEntity r4 = r6.copy(r7, r8, r9, r10, r11, r12)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.cart.CartLineItemEntity.copy$default(kr.co.popone.fitts.model.cart.CartLineItemEntity, java.util.List, java.lang.Integer, int, int, int, int, int, java.lang.Object):kr.co.popone.fitts.model.cart.CartLineItemEntity");
    }

    @NotNull
    public final List<CartLineItem> component1() {
        return this.lineItems;
    }

    @Nullable
    public final Integer component2() {
        return this.specialDiscountPrice;
    }

    public final int component3() {
        return this.totalProductCount;
    }

    public final int component4() {
        return this.totalProductPrice;
    }

    public final int component5() {
        return this.totalShippingPrice;
    }

    public final int component6() {
        return this.totalOrderPrice;
    }

    @NotNull
    public final CartLineItemEntity copy(@NotNull List<CartLineItem> list, @Nullable Integer num, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        CartLineItemEntity cartLineItemEntity = new CartLineItemEntity(list, num, i, i2, i3, i4);
        return cartLineItemEntity;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartLineItemEntity) {
                CartLineItemEntity cartLineItemEntity = (CartLineItemEntity) obj;
                if (Intrinsics.areEqual((Object) this.lineItems, (Object) cartLineItemEntity.lineItems) && Intrinsics.areEqual((Object) this.specialDiscountPrice, (Object) cartLineItemEntity.specialDiscountPrice)) {
                    if (this.totalProductCount == cartLineItemEntity.totalProductCount) {
                        if (this.totalProductPrice == cartLineItemEntity.totalProductPrice) {
                            if (this.totalShippingPrice == cartLineItemEntity.totalShippingPrice) {
                                if (this.totalOrderPrice == cartLineItemEntity.totalOrderPrice) {
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
        List<CartLineItem> list = this.lineItems;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Integer num = this.specialDiscountPrice;
        if (num != null) {
            i = num.hashCode();
        }
        return ((((((((hashCode + i) * 31) + this.totalProductCount) * 31) + this.totalProductPrice) * 31) + this.totalShippingPrice) * 31) + this.totalOrderPrice;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartLineItemEntity(lineItems=");
        sb.append(this.lineItems);
        sb.append(", specialDiscountPrice=");
        sb.append(this.specialDiscountPrice);
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

    public CartLineItemEntity(@NotNull List<CartLineItem> list, @Nullable Integer num, int i, int i2, int i3, int i4) {
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        this.lineItems = list;
        this.specialDiscountPrice = num;
        this.totalProductCount = i;
        this.totalProductPrice = i2;
        this.totalShippingPrice = i3;
        this.totalOrderPrice = i4;
    }

    @NotNull
    public final List<CartLineItem> getLineItems() {
        return this.lineItems;
    }

    @Nullable
    public final Integer getSpecialDiscountPrice() {
        return this.specialDiscountPrice;
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
