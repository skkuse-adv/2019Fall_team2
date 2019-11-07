package kr.co.popone.fitts.model.cart;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartLineItemsDomain {
    @NotNull
    private final List<CartLineItemViewData> cartLineItemViewDatas;
    private int totalOrderPrice;
    private int totalProductCount;
    private int totalProductPrice;
    private int totalShippingPrice;

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.util.List, code=java.util.List<kr.co.popone.fitts.model.cart.CartLineItemViewData>, for r8v0, types: [java.util.List] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ kr.co.popone.fitts.model.cart.CartLineItemsDomain copy$default(kr.co.popone.fitts.model.cart.CartLineItemsDomain r3, int r4, int r5, int r6, int r7, java.util.List<kr.co.popone.fitts.model.cart.CartLineItemViewData> r8, int r9, java.lang.Object r10) {
        /*
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            int r4 = r3.totalProductCount
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            int r5 = r3.totalProductPrice
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            int r6 = r3.totalShippingPrice
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            int r7 = r3.totalOrderPrice
        L_0x001a:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            java.util.List<kr.co.popone.fitts.model.cart.CartLineItemViewData> r8 = r3.cartLineItemViewDatas
        L_0x0021:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            kr.co.popone.fitts.model.cart.CartLineItemsDomain r3 = r5.copy(r6, r7, r8, r9, r10)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.model.cart.CartLineItemsDomain.copy$default(kr.co.popone.fitts.model.cart.CartLineItemsDomain, int, int, int, int, java.util.List, int, java.lang.Object):kr.co.popone.fitts.model.cart.CartLineItemsDomain");
    }

    public final int component1() {
        return this.totalProductCount;
    }

    public final int component2() {
        return this.totalProductPrice;
    }

    public final int component3() {
        return this.totalShippingPrice;
    }

    public final int component4() {
        return this.totalOrderPrice;
    }

    @NotNull
    public final List<CartLineItemViewData> component5() {
        return this.cartLineItemViewDatas;
    }

    @NotNull
    public final CartLineItemsDomain copy(int i, int i2, int i3, int i4, @NotNull List<CartLineItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "cartLineItemViewDatas");
        CartLineItemsDomain cartLineItemsDomain = new CartLineItemsDomain(i, i2, i3, i4, list);
        return cartLineItemsDomain;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartLineItemsDomain) {
                CartLineItemsDomain cartLineItemsDomain = (CartLineItemsDomain) obj;
                if (this.totalProductCount == cartLineItemsDomain.totalProductCount) {
                    if (this.totalProductPrice == cartLineItemsDomain.totalProductPrice) {
                        if (this.totalShippingPrice == cartLineItemsDomain.totalShippingPrice) {
                            if (!(this.totalOrderPrice == cartLineItemsDomain.totalOrderPrice) || !Intrinsics.areEqual((Object) this.cartLineItemViewDatas, (Object) cartLineItemsDomain.cartLineItemViewDatas)) {
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
        int i = ((((((this.totalProductCount * 31) + this.totalProductPrice) * 31) + this.totalShippingPrice) * 31) + this.totalOrderPrice) * 31;
        List<CartLineItemViewData> list = this.cartLineItemViewDatas;
        return i + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartLineItemsDomain(totalProductCount=");
        sb.append(this.totalProductCount);
        sb.append(", totalProductPrice=");
        sb.append(this.totalProductPrice);
        sb.append(", totalShippingPrice=");
        sb.append(this.totalShippingPrice);
        sb.append(", totalOrderPrice=");
        sb.append(this.totalOrderPrice);
        sb.append(", cartLineItemViewDatas=");
        sb.append(this.cartLineItemViewDatas);
        sb.append(")");
        return sb.toString();
    }

    public CartLineItemsDomain(int i, int i2, int i3, int i4, @NotNull List<CartLineItemViewData> list) {
        Intrinsics.checkParameterIsNotNull(list, "cartLineItemViewDatas");
        this.totalProductCount = i;
        this.totalProductPrice = i2;
        this.totalShippingPrice = i3;
        this.totalOrderPrice = i4;
        this.cartLineItemViewDatas = list;
    }

    public final int getTotalProductCount() {
        return this.totalProductCount;
    }

    public final void setTotalProductCount(int i) {
        this.totalProductCount = i;
    }

    public final int getTotalProductPrice() {
        return this.totalProductPrice;
    }

    public final void setTotalProductPrice(int i) {
        this.totalProductPrice = i;
    }

    public final int getTotalShippingPrice() {
        return this.totalShippingPrice;
    }

    public final void setTotalShippingPrice(int i) {
        this.totalShippingPrice = i;
    }

    public final int getTotalOrderPrice() {
        return this.totalOrderPrice;
    }

    public final void setTotalOrderPrice(int i) {
        this.totalOrderPrice = i;
    }

    @NotNull
    public final List<CartLineItemViewData> getCartLineItemViewDatas() {
        return this.cartLineItemViewDatas;
    }
}
