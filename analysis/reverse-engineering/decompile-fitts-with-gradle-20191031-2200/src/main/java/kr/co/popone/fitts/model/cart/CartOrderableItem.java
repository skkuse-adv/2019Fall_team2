package kr.co.popone.fitts.model.cart;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.AdjustmentPolicy;
import kr.co.popone.fitts.model.order.BankAccount;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;
import kr.co.popone.fitts.model.user.UserInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartOrderableItem {
    @SerializedName("bank_accounts")
    @NotNull
    private final List<BankAccount> bankAccounts;
    @SerializedName("due_date")
    @NotNull
    private final Date dueDate;
    @SerializedName("points")
    private final int fittsPoint;
    @SerializedName("line_items")
    @NotNull
    private final List<CartLineItem> lineItems;
    @SerializedName("point_adjustment_policy")
    @NotNull
    private final AdjustmentPolicy pointAdjustmentPolicy;
    @SerializedName("total_quantity_of_variants")
    private final int totalProductCount;
    @SerializedName("total_product_price")
    private final int totalProductPrice;
    @SerializedName("total_shipping_price")
    private final int totalShippingPrice;
    @SerializedName("usable_points")
    private final int usablePoints;
    @SerializedName("user_address")
    @NotNull
    private final ShippingAddressResponse userAddress;
    @SerializedName("user_info")
    @NotNull
    private final UserInfo userInfo;

    @NotNull
    public static /* synthetic */ CartOrderableItem copy$default(CartOrderableItem cartOrderableItem, List list, int i, int i2, int i3, UserInfo userInfo2, ShippingAddressResponse shippingAddressResponse, List list2, Date date, AdjustmentPolicy adjustmentPolicy, int i4, int i5, int i6, Object obj) {
        CartOrderableItem cartOrderableItem2 = cartOrderableItem;
        int i7 = i6;
        return cartOrderableItem.copy((i7 & 1) != 0 ? cartOrderableItem2.lineItems : list, (i7 & 2) != 0 ? cartOrderableItem2.totalProductCount : i, (i7 & 4) != 0 ? cartOrderableItem2.totalProductPrice : i2, (i7 & 8) != 0 ? cartOrderableItem2.totalShippingPrice : i3, (i7 & 16) != 0 ? cartOrderableItem2.userInfo : userInfo2, (i7 & 32) != 0 ? cartOrderableItem2.userAddress : shippingAddressResponse, (i7 & 64) != 0 ? cartOrderableItem2.bankAccounts : list2, (i7 & 128) != 0 ? cartOrderableItem2.dueDate : date, (i7 & 256) != 0 ? cartOrderableItem2.pointAdjustmentPolicy : adjustmentPolicy, (i7 & 512) != 0 ? cartOrderableItem2.usablePoints : i4, (i7 & 1024) != 0 ? cartOrderableItem2.fittsPoint : i5);
    }

    @NotNull
    public final List<CartLineItem> component1() {
        return this.lineItems;
    }

    public final int component10() {
        return this.usablePoints;
    }

    public final int component11() {
        return this.fittsPoint;
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

    @NotNull
    public final UserInfo component5() {
        return this.userInfo;
    }

    @NotNull
    public final ShippingAddressResponse component6() {
        return this.userAddress;
    }

    @NotNull
    public final List<BankAccount> component7() {
        return this.bankAccounts;
    }

    @NotNull
    public final Date component8() {
        return this.dueDate;
    }

    @NotNull
    public final AdjustmentPolicy component9() {
        return this.pointAdjustmentPolicy;
    }

    @NotNull
    public final CartOrderableItem copy(@NotNull List<CartLineItem> list, int i, int i2, int i3, @NotNull UserInfo userInfo2, @NotNull ShippingAddressResponse shippingAddressResponse, @NotNull List<BankAccount> list2, @NotNull Date date, @NotNull AdjustmentPolicy adjustmentPolicy, int i4, int i5) {
        List<CartLineItem> list3 = list;
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        UserInfo userInfo3 = userInfo2;
        Intrinsics.checkParameterIsNotNull(userInfo3, "userInfo");
        ShippingAddressResponse shippingAddressResponse2 = shippingAddressResponse;
        Intrinsics.checkParameterIsNotNull(shippingAddressResponse2, "userAddress");
        List<BankAccount> list4 = list2;
        Intrinsics.checkParameterIsNotNull(list4, "bankAccounts");
        Date date2 = date;
        Intrinsics.checkParameterIsNotNull(date2, "dueDate");
        AdjustmentPolicy adjustmentPolicy2 = adjustmentPolicy;
        Intrinsics.checkParameterIsNotNull(adjustmentPolicy2, "pointAdjustmentPolicy");
        CartOrderableItem cartOrderableItem = new CartOrderableItem(list3, i, i2, i3, userInfo3, shippingAddressResponse2, list4, date2, adjustmentPolicy2, i4, i5);
        return cartOrderableItem;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartOrderableItem) {
                CartOrderableItem cartOrderableItem = (CartOrderableItem) obj;
                if (Intrinsics.areEqual((Object) this.lineItems, (Object) cartOrderableItem.lineItems)) {
                    if (this.totalProductCount == cartOrderableItem.totalProductCount) {
                        if (this.totalProductPrice == cartOrderableItem.totalProductPrice) {
                            if ((this.totalShippingPrice == cartOrderableItem.totalShippingPrice) && Intrinsics.areEqual((Object) this.userInfo, (Object) cartOrderableItem.userInfo) && Intrinsics.areEqual((Object) this.userAddress, (Object) cartOrderableItem.userAddress) && Intrinsics.areEqual((Object) this.bankAccounts, (Object) cartOrderableItem.bankAccounts) && Intrinsics.areEqual((Object) this.dueDate, (Object) cartOrderableItem.dueDate) && Intrinsics.areEqual((Object) this.pointAdjustmentPolicy, (Object) cartOrderableItem.pointAdjustmentPolicy)) {
                                if (this.usablePoints == cartOrderableItem.usablePoints) {
                                    if (this.fittsPoint == cartOrderableItem.fittsPoint) {
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
        List<CartLineItem> list = this.lineItems;
        int i = 0;
        int hashCode = (((((((list != null ? list.hashCode() : 0) * 31) + this.totalProductCount) * 31) + this.totalProductPrice) * 31) + this.totalShippingPrice) * 31;
        UserInfo userInfo2 = this.userInfo;
        int hashCode2 = (hashCode + (userInfo2 != null ? userInfo2.hashCode() : 0)) * 31;
        ShippingAddressResponse shippingAddressResponse = this.userAddress;
        int hashCode3 = (hashCode2 + (shippingAddressResponse != null ? shippingAddressResponse.hashCode() : 0)) * 31;
        List<BankAccount> list2 = this.bankAccounts;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Date date = this.dueDate;
        int hashCode5 = (hashCode4 + (date != null ? date.hashCode() : 0)) * 31;
        AdjustmentPolicy adjustmentPolicy = this.pointAdjustmentPolicy;
        if (adjustmentPolicy != null) {
            i = adjustmentPolicy.hashCode();
        }
        return ((((hashCode5 + i) * 31) + this.usablePoints) * 31) + this.fittsPoint;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartOrderableItem(lineItems=");
        sb.append(this.lineItems);
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

    public CartOrderableItem(@NotNull List<CartLineItem> list, int i, int i2, int i3, @NotNull UserInfo userInfo2, @NotNull ShippingAddressResponse shippingAddressResponse, @NotNull List<BankAccount> list2, @NotNull Date date, @NotNull AdjustmentPolicy adjustmentPolicy, int i4, int i5) {
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        Intrinsics.checkParameterIsNotNull(userInfo2, "userInfo");
        Intrinsics.checkParameterIsNotNull(shippingAddressResponse, "userAddress");
        Intrinsics.checkParameterIsNotNull(list2, "bankAccounts");
        Intrinsics.checkParameterIsNotNull(date, "dueDate");
        Intrinsics.checkParameterIsNotNull(adjustmentPolicy, "pointAdjustmentPolicy");
        this.lineItems = list;
        this.totalProductCount = i;
        this.totalProductPrice = i2;
        this.totalShippingPrice = i3;
        this.userInfo = userInfo2;
        this.userAddress = shippingAddressResponse;
        this.bankAccounts = list2;
        this.dueDate = date;
        this.pointAdjustmentPolicy = adjustmentPolicy;
        this.usablePoints = i4;
        this.fittsPoint = i5;
    }

    @NotNull
    public final List<CartLineItem> getLineItems() {
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

    @NotNull
    public final UserInfo getUserInfo() {
        return this.userInfo;
    }

    @NotNull
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
