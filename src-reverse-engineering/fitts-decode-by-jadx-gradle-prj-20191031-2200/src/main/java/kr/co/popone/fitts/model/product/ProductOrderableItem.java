package kr.co.popone.fitts.model.product;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartLineItem;
import kr.co.popone.fitts.model.datamodel.commerce.AdjustmentPolicy;
import kr.co.popone.fitts.model.order.BankAccount;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;
import kr.co.popone.fitts.model.user.UserInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProductOrderableItem {
    @SerializedName("bank_accounts")
    @NotNull
    private final List<BankAccount> bankAccounts;
    @SerializedName("due_date")
    @NotNull
    private final Date dueDate;
    @SerializedName("points")
    private final int fittsPoint;
    @SerializedName("line_item")
    @NotNull
    private final CartLineItem lineItems;
    @SerializedName("point_adjustment_policy")
    @NotNull
    private final AdjustmentPolicy pointAdjustmentPolicy;
    @SerializedName("special_discount_price")
    @Nullable
    private final Integer specialDiscountPrice;
    @SerializedName("total_quantity_of_variants")
    private final int totalProductCount;
    @SerializedName("total_product_price")
    private final int totalProductPrice;
    @SerializedName("total_shipping_price")
    private final int totalShippingPrice;
    @SerializedName("usable_points")
    private final int usablePoints;
    @SerializedName("user_address")
    @Nullable
    private final ShippingAddressResponse userAddress;
    @SerializedName("user_info")
    @Nullable
    private final UserInfo userInfo;

    @NotNull
    public static /* synthetic */ ProductOrderableItem copy$default(ProductOrderableItem productOrderableItem, CartLineItem cartLineItem, Integer num, int i, int i2, int i3, UserInfo userInfo2, ShippingAddressResponse shippingAddressResponse, List list, Date date, AdjustmentPolicy adjustmentPolicy, int i4, int i5, int i6, Object obj) {
        ProductOrderableItem productOrderableItem2 = productOrderableItem;
        int i7 = i6;
        return productOrderableItem.copy((i7 & 1) != 0 ? productOrderableItem2.lineItems : cartLineItem, (i7 & 2) != 0 ? productOrderableItem2.specialDiscountPrice : num, (i7 & 4) != 0 ? productOrderableItem2.totalProductCount : i, (i7 & 8) != 0 ? productOrderableItem2.totalProductPrice : i2, (i7 & 16) != 0 ? productOrderableItem2.totalShippingPrice : i3, (i7 & 32) != 0 ? productOrderableItem2.userInfo : userInfo2, (i7 & 64) != 0 ? productOrderableItem2.userAddress : shippingAddressResponse, (i7 & 128) != 0 ? productOrderableItem2.bankAccounts : list, (i7 & 256) != 0 ? productOrderableItem2.dueDate : date, (i7 & 512) != 0 ? productOrderableItem2.pointAdjustmentPolicy : adjustmentPolicy, (i7 & 1024) != 0 ? productOrderableItem2.usablePoints : i4, (i7 & 2048) != 0 ? productOrderableItem2.fittsPoint : i5);
    }

    @NotNull
    public final CartLineItem component1() {
        return this.lineItems;
    }

    @NotNull
    public final AdjustmentPolicy component10() {
        return this.pointAdjustmentPolicy;
    }

    public final int component11() {
        return this.usablePoints;
    }

    public final int component12() {
        return this.fittsPoint;
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

    @Nullable
    public final UserInfo component6() {
        return this.userInfo;
    }

    @Nullable
    public final ShippingAddressResponse component7() {
        return this.userAddress;
    }

    @NotNull
    public final List<BankAccount> component8() {
        return this.bankAccounts;
    }

    @NotNull
    public final Date component9() {
        return this.dueDate;
    }

    @NotNull
    public final ProductOrderableItem copy(@NotNull CartLineItem cartLineItem, @Nullable Integer num, int i, int i2, int i3, @Nullable UserInfo userInfo2, @Nullable ShippingAddressResponse shippingAddressResponse, @NotNull List<BankAccount> list, @NotNull Date date, @NotNull AdjustmentPolicy adjustmentPolicy, int i4, int i5) {
        CartLineItem cartLineItem2 = cartLineItem;
        Intrinsics.checkParameterIsNotNull(cartLineItem, "lineItems");
        List<BankAccount> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "bankAccounts");
        Date date2 = date;
        Intrinsics.checkParameterIsNotNull(date2, "dueDate");
        AdjustmentPolicy adjustmentPolicy2 = adjustmentPolicy;
        Intrinsics.checkParameterIsNotNull(adjustmentPolicy2, "pointAdjustmentPolicy");
        ProductOrderableItem productOrderableItem = new ProductOrderableItem(cartLineItem2, num, i, i2, i3, userInfo2, shippingAddressResponse, list2, date2, adjustmentPolicy2, i4, i5);
        return productOrderableItem;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ProductOrderableItem) {
                ProductOrderableItem productOrderableItem = (ProductOrderableItem) obj;
                if (Intrinsics.areEqual((Object) this.lineItems, (Object) productOrderableItem.lineItems) && Intrinsics.areEqual((Object) this.specialDiscountPrice, (Object) productOrderableItem.specialDiscountPrice)) {
                    if (this.totalProductCount == productOrderableItem.totalProductCount) {
                        if (this.totalProductPrice == productOrderableItem.totalProductPrice) {
                            if ((this.totalShippingPrice == productOrderableItem.totalShippingPrice) && Intrinsics.areEqual((Object) this.userInfo, (Object) productOrderableItem.userInfo) && Intrinsics.areEqual((Object) this.userAddress, (Object) productOrderableItem.userAddress) && Intrinsics.areEqual((Object) this.bankAccounts, (Object) productOrderableItem.bankAccounts) && Intrinsics.areEqual((Object) this.dueDate, (Object) productOrderableItem.dueDate) && Intrinsics.areEqual((Object) this.pointAdjustmentPolicy, (Object) productOrderableItem.pointAdjustmentPolicy)) {
                                if (this.usablePoints == productOrderableItem.usablePoints) {
                                    if (this.fittsPoint == productOrderableItem.fittsPoint) {
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
        CartLineItem cartLineItem = this.lineItems;
        int i = 0;
        int hashCode = (cartLineItem != null ? cartLineItem.hashCode() : 0) * 31;
        Integer num = this.specialDiscountPrice;
        int hashCode2 = (((((((hashCode + (num != null ? num.hashCode() : 0)) * 31) + this.totalProductCount) * 31) + this.totalProductPrice) * 31) + this.totalShippingPrice) * 31;
        UserInfo userInfo2 = this.userInfo;
        int hashCode3 = (hashCode2 + (userInfo2 != null ? userInfo2.hashCode() : 0)) * 31;
        ShippingAddressResponse shippingAddressResponse = this.userAddress;
        int hashCode4 = (hashCode3 + (shippingAddressResponse != null ? shippingAddressResponse.hashCode() : 0)) * 31;
        List<BankAccount> list = this.bankAccounts;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        Date date = this.dueDate;
        int hashCode6 = (hashCode5 + (date != null ? date.hashCode() : 0)) * 31;
        AdjustmentPolicy adjustmentPolicy = this.pointAdjustmentPolicy;
        if (adjustmentPolicy != null) {
            i = adjustmentPolicy.hashCode();
        }
        return ((((hashCode6 + i) * 31) + this.usablePoints) * 31) + this.fittsPoint;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductOrderableItem(lineItems=");
        sb.append(this.lineItems);
        sb.append(", specialDiscountPrice=");
        sb.append(this.specialDiscountPrice);
        sb.append(", totalProductCount=");
        sb.append(this.totalProductCount);
        sb.append(", totalProductPrice=");
        sb.append(this.totalProductPrice);
        sb.append(", totalShippingPrice=");
        sb.append(this.totalShippingPrice);
        sb.append(", userInfo=");
        sb.append(this.userInfo);
        sb.append(", userAddress=");
        sb.append(this.userAddress);
        sb.append(", bankAccounts=");
        sb.append(this.bankAccounts);
        sb.append(", dueDate=");
        sb.append(this.dueDate);
        sb.append(", pointAdjustmentPolicy=");
        sb.append(this.pointAdjustmentPolicy);
        sb.append(", usablePoints=");
        sb.append(this.usablePoints);
        sb.append(", fittsPoint=");
        sb.append(this.fittsPoint);
        sb.append(")");
        return sb.toString();
    }

    public ProductOrderableItem(@NotNull CartLineItem cartLineItem, @Nullable Integer num, int i, int i2, int i3, @Nullable UserInfo userInfo2, @Nullable ShippingAddressResponse shippingAddressResponse, @NotNull List<BankAccount> list, @NotNull Date date, @NotNull AdjustmentPolicy adjustmentPolicy, int i4, int i5) {
        Intrinsics.checkParameterIsNotNull(cartLineItem, "lineItems");
        Intrinsics.checkParameterIsNotNull(list, "bankAccounts");
        Intrinsics.checkParameterIsNotNull(date, "dueDate");
        Intrinsics.checkParameterIsNotNull(adjustmentPolicy, "pointAdjustmentPolicy");
        this.lineItems = cartLineItem;
        this.specialDiscountPrice = num;
        this.totalProductCount = i;
        this.totalProductPrice = i2;
        this.totalShippingPrice = i3;
        this.userInfo = userInfo2;
        this.userAddress = shippingAddressResponse;
        this.bankAccounts = list;
        this.dueDate = date;
        this.pointAdjustmentPolicy = adjustmentPolicy;
        this.usablePoints = i4;
        this.fittsPoint = i5;
    }

    @NotNull
    public final CartLineItem getLineItems() {
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

    @Nullable
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    @Nullable
    public final ShippingAddressResponse getUserAddress() {
        return this.userAddress;
    }

    @NotNull
    public final List<BankAccount> getBankAccounts() {
        return this.bankAccounts;
    }

    @NotNull
    public final Date getDueDate() {
        return this.dueDate;
    }

    @NotNull
    public final AdjustmentPolicy getPointAdjustmentPolicy() {
        return this.pointAdjustmentPolicy;
    }

    public final int getUsablePoints() {
        return this.usablePoints;
    }

    public final int getFittsPoint() {
        return this.fittsPoint;
    }
}
