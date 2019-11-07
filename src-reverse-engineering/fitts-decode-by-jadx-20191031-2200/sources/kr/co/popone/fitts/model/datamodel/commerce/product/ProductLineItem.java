package kr.co.popone.fitts.model.datamodel.commerce.product;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductLineItem {
    @SerializedName("line_items")
    @NotNull
    private final List<Object> lineItems;
    @SerializedName("total_membership_discount_price")
    private final int membershipDiscountPrice;
    @SerializedName("total_quantity_of_variants")
    private final int variantsCount;
    @SerializedName("total_order_price")
    private final int variantsOrderPrice;
    @SerializedName("total_shipping_price")
    private final int variantsShippingPrice;
    @SerializedName("total_product_price")
    private final int variantsTotalPrice;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<java.lang.Object>, for r5v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem copy$default(kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem r4, java.util.List<java.lang.Object> r5, int r6, int r7, int r8, int r9, int r10, int r11, java.lang.Object r12) {
        /*
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            java.util.List<java.lang.Object> r5 = r4.lineItems
        L_0x0006:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000c
            int r6 = r4.variantsCount
        L_0x000c:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0013
            int r7 = r4.variantsTotalPrice
        L_0x0013:
            r0 = r7
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001a
            int r8 = r4.variantsOrderPrice
        L_0x001a:
            r1 = r8
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0021
            int r9 = r4.variantsShippingPrice
        L_0x0021:
            r2 = r9
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            int r10 = r4.membershipDiscountPrice
        L_0x0028:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem r4 = r6.copy(r7, r8, r9, r10, r11, r12)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem.copy$default(kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem, java.util.List, int, int, int, int, int, int, java.lang.Object):kr.co.popone.fitts.model.datamodel.commerce.product.ProductLineItem");
    }

    @NotNull
    public final List<Object> component1() {
        return this.lineItems;
    }

    public final int component2() {
        return this.variantsCount;
    }

    public final int component3() {
        return this.variantsTotalPrice;
    }

    public final int component4() {
        return this.variantsOrderPrice;
    }

    public final int component5() {
        return this.variantsShippingPrice;
    }

    public final int component6() {
        return this.membershipDiscountPrice;
    }

    @NotNull
    public final ProductLineItem copy(@NotNull List<Object> list, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        ProductLineItem productLineItem = new ProductLineItem(list, i, i2, i3, i4, i5);
        return productLineItem;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ProductLineItem) {
                ProductLineItem productLineItem = (ProductLineItem) obj;
                if (Intrinsics.areEqual((Object) this.lineItems, (Object) productLineItem.lineItems)) {
                    if (this.variantsCount == productLineItem.variantsCount) {
                        if (this.variantsTotalPrice == productLineItem.variantsTotalPrice) {
                            if (this.variantsOrderPrice == productLineItem.variantsOrderPrice) {
                                if (this.variantsShippingPrice == productLineItem.variantsShippingPrice) {
                                    if (this.membershipDiscountPrice == productLineItem.membershipDiscountPrice) {
                                        return true;
                                    }
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
        List<Object> list = this.lineItems;
        return ((((((((((list != null ? list.hashCode() : 0) * 31) + this.variantsCount) * 31) + this.variantsTotalPrice) * 31) + this.variantsOrderPrice) * 31) + this.variantsShippingPrice) * 31) + this.membershipDiscountPrice;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductLineItem(lineItems=");
        sb.append(this.lineItems);
        sb.append(", variantsCount=");
        sb.append(this.variantsCount);
        sb.append(", variantsTotalPrice=");
        sb.append(this.variantsTotalPrice);
        sb.append(", variantsOrderPrice=");
        sb.append(this.variantsOrderPrice);
        sb.append(", variantsShippingPrice=");
        sb.append(this.variantsShippingPrice);
        sb.append(", membershipDiscountPrice=");
        sb.append(this.membershipDiscountPrice);
        sb.append(")");
        return sb.toString();
    }

    public ProductLineItem(@NotNull List<Object> list, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        this.lineItems = list;
        this.variantsCount = i;
        this.variantsTotalPrice = i2;
        this.variantsOrderPrice = i3;
        this.variantsShippingPrice = i4;
        this.membershipDiscountPrice = i5;
    }

    @NotNull
    public final List<Object> getLineItems() {
        return this.lineItems;
    }

    public final int getVariantsCount() {
        return this.variantsCount;
    }

    public final int getVariantsTotalPrice() {
        return this.variantsTotalPrice;
    }

    public final int getVariantsOrderPrice() {
        return this.variantsOrderPrice;
    }

    public final int getVariantsShippingPrice() {
        return this.variantsShippingPrice;
    }

    public final int getMembershipDiscountPrice() {
        return this.membershipDiscountPrice;
    }
}
