package kr.co.popone.fitts.model.store;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderableOptionViewData {
    private final int additionalPrice;
    private boolean isSingleOption;
    private boolean isSpecialDiscount;
    private int productCount;
    private final long productId;
    @NotNull
    private String productName;
    private final int productPrice;
    @NotNull
    private final String productState;

    @NotNull
    public static /* synthetic */ OrderableOptionViewData copy$default(OrderableOptionViewData orderableOptionViewData, long j, String str, int i, int i2, String str2, int i3, boolean z, boolean z2, int i4, Object obj) {
        OrderableOptionViewData orderableOptionViewData2 = orderableOptionViewData;
        int i5 = i4;
        return orderableOptionViewData.copy((i5 & 1) != 0 ? orderableOptionViewData2.productId : j, (i5 & 2) != 0 ? orderableOptionViewData2.productName : str, (i5 & 4) != 0 ? orderableOptionViewData2.productPrice : i, (i5 & 8) != 0 ? orderableOptionViewData2.additionalPrice : i2, (i5 & 16) != 0 ? orderableOptionViewData2.productState : str2, (i5 & 32) != 0 ? orderableOptionViewData2.productCount : i3, (i5 & 64) != 0 ? orderableOptionViewData2.isSingleOption : z, (i5 & 128) != 0 ? orderableOptionViewData2.isSpecialDiscount : z2);
    }

    public final long component1() {
        return this.productId;
    }

    @NotNull
    public final String component2() {
        return this.productName;
    }

    public final int component3() {
        return this.productPrice;
    }

    public final int component4() {
        return this.additionalPrice;
    }

    @NotNull
    public final String component5() {
        return this.productState;
    }

    public final int component6() {
        return this.productCount;
    }

    public final boolean component7() {
        return this.isSingleOption;
    }

    public final boolean component8() {
        return this.isSpecialDiscount;
    }

    @NotNull
    public final OrderableOptionViewData copy(long j, @NotNull String str, int i, int i2, @NotNull String str2, int i3, boolean z, boolean z2) {
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(str, "productName");
        String str4 = str2;
        Intrinsics.checkParameterIsNotNull(str4, "productState");
        OrderableOptionViewData orderableOptionViewData = new OrderableOptionViewData(j, str3, i, i2, str4, i3, z, z2);
        return orderableOptionViewData;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderableOptionViewData) {
                OrderableOptionViewData orderableOptionViewData = (OrderableOptionViewData) obj;
                if ((this.productId == orderableOptionViewData.productId) && Intrinsics.areEqual((Object) this.productName, (Object) orderableOptionViewData.productName)) {
                    if (this.productPrice == orderableOptionViewData.productPrice) {
                        if ((this.additionalPrice == orderableOptionViewData.additionalPrice) && Intrinsics.areEqual((Object) this.productState, (Object) orderableOptionViewData.productState)) {
                            if (this.productCount == orderableOptionViewData.productCount) {
                                if (this.isSingleOption == orderableOptionViewData.isSingleOption) {
                                    if (this.isSpecialDiscount == orderableOptionViewData.isSpecialDiscount) {
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
        long j = this.productId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.productName;
        int i2 = 0;
        int hashCode = (((((i + (str != null ? str.hashCode() : 0)) * 31) + this.productPrice) * 31) + this.additionalPrice) * 31;
        String str2 = this.productState;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = (((hashCode + i2) * 31) + this.productCount) * 31;
        boolean z = this.isSingleOption;
        if (z) {
            z = true;
        }
        int i4 = (i3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.isSpecialDiscount;
        if (z2) {
            z2 = true;
        }
        return i4 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderableOptionViewData(productId=");
        sb.append(this.productId);
        sb.append(", productName=");
        sb.append(this.productName);
        sb.append(", productPrice=");
        sb.append(this.productPrice);
        sb.append(", additionalPrice=");
        sb.append(this.additionalPrice);
        sb.append(", productState=");
        sb.append(this.productState);
        sb.append(", productCount=");
        sb.append(this.productCount);
        sb.append(", isSingleOption=");
        sb.append(this.isSingleOption);
        sb.append(", isSpecialDiscount=");
        sb.append(this.isSpecialDiscount);
        sb.append(")");
        return sb.toString();
    }

    public OrderableOptionViewData(long j, @NotNull String str, int i, int i2, @NotNull String str2, int i3, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "productName");
        Intrinsics.checkParameterIsNotNull(str2, "productState");
        this.productId = j;
        this.productName = str;
        this.productPrice = i;
        this.additionalPrice = i2;
        this.productState = str2;
        this.productCount = i3;
        this.isSingleOption = z;
        this.isSpecialDiscount = z2;
    }

    public final long getProductId() {
        return this.productId;
    }

    @NotNull
    public final String getProductName() {
        return this.productName;
    }

    public final void setProductName(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.productName = str;
    }

    public final int getProductPrice() {
        return this.productPrice;
    }

    public final int getAdditionalPrice() {
        return this.additionalPrice;
    }

    @NotNull
    public final String getProductState() {
        return this.productState;
    }

    public final int getProductCount() {
        return this.productCount;
    }

    public final void setProductCount(int i) {
        this.productCount = i;
    }

    public final boolean isSingleOption() {
        return this.isSingleOption;
    }

    public final void setSingleOption(boolean z) {
        this.isSingleOption = z;
    }

    public /* synthetic */ OrderableOptionViewData(long j, String str, int i, int i2, String str2, int i3, boolean z, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        int i5 = i4;
        this(j, str, i, i2, str2, (i5 & 32) != 0 ? 1 : i3, (i5 & 64) != 0 ? false : z, (i5 & 128) != 0 ? false : z2);
    }

    public final boolean isSpecialDiscount() {
        return this.isSpecialDiscount;
    }

    public final void setSpecialDiscount(boolean z) {
        this.isSpecialDiscount = z;
    }
}
