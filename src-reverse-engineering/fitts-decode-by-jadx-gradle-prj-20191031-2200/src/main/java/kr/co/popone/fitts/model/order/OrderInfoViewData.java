package kr.co.popone.fitts.model.order;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.cart.CartEntityExtensionKt;
import kr.co.popone.fitts.model.cart.CartLineItemViewData;
import kr.co.popone.fitts.model.user.UserAPI.ShippingAddressResponse;
import kr.co.popone.fitts.model.user.UserInfo;
import kr.co.popone.fitts.model.view.adjustment.AdjustmentViewData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderInfoViewData implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final List<BankAccount> bankAccount;
    @NotNull
    private final Date dueData;
    @NotNull
    private final List<CartLineItemViewData> lineItems;
    @NotNull
    private final AdjustmentViewData pointAdjustmentPolicy;
    @Nullable
    private final Integer specialDiscountPrice;
    private final int totalProductCount;
    private final int totalProductPrice;
    private final int totalShippingPrice;
    @Nullable
    private final ShippingAddressResponse userAddress;
    @Nullable
    private final UserInfo userInfo;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((CartLineItemViewData) CartLineItemViewData.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            UserInfo userInfo = parcel.readInt() != 0 ? (UserInfo) UserInfo.CREATOR.createFromParcel(parcel) : null;
            ShippingAddressResponse shippingAddressResponse = parcel.readInt() != 0 ? (ShippingAddressResponse) ShippingAddressResponse.CREATOR.createFromParcel(parcel) : null;
            int readInt5 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt5);
            while (readInt5 != 0) {
                arrayList2.add((BankAccount) BankAccount.CREATOR.createFromParcel(parcel));
                readInt5--;
            }
            OrderInfoViewData orderInfoViewData = new OrderInfoViewData(arrayList, valueOf, readInt2, readInt3, readInt4, userInfo, shippingAddressResponse, arrayList2, (Date) parcel.readSerializable(), (AdjustmentViewData) AdjustmentViewData.CREATOR.createFromParcel(parcel));
            return orderInfoViewData;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new OrderInfoViewData[i];
        }
    }

    @NotNull
    public static /* synthetic */ OrderInfoViewData copy$default(OrderInfoViewData orderInfoViewData, List list, Integer num, int i, int i2, int i3, UserInfo userInfo2, ShippingAddressResponse shippingAddressResponse, List list2, Date date, AdjustmentViewData adjustmentViewData, int i4, Object obj) {
        OrderInfoViewData orderInfoViewData2 = orderInfoViewData;
        int i5 = i4;
        return orderInfoViewData.copy((i5 & 1) != 0 ? orderInfoViewData2.lineItems : list, (i5 & 2) != 0 ? orderInfoViewData2.specialDiscountPrice : num, (i5 & 4) != 0 ? orderInfoViewData2.totalProductCount : i, (i5 & 8) != 0 ? orderInfoViewData2.totalProductPrice : i2, (i5 & 16) != 0 ? orderInfoViewData2.totalShippingPrice : i3, (i5 & 32) != 0 ? orderInfoViewData2.userInfo : userInfo2, (i5 & 64) != 0 ? orderInfoViewData2.userAddress : shippingAddressResponse, (i5 & 128) != 0 ? orderInfoViewData2.bankAccount : list2, (i5 & 256) != 0 ? orderInfoViewData2.dueData : date, (i5 & 512) != 0 ? orderInfoViewData2.pointAdjustmentPolicy : adjustmentViewData);
    }

    @NotNull
    public final List<CartLineItemViewData> component1() {
        return this.lineItems;
    }

    @NotNull
    public final AdjustmentViewData component10() {
        return this.pointAdjustmentPolicy;
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
        return this.bankAccount;
    }

    @NotNull
    public final Date component9() {
        return this.dueData;
    }

    @NotNull
    public final OrderInfoViewData copy(@NotNull List<CartLineItemViewData> list, @Nullable Integer num, int i, int i2, int i3, @Nullable UserInfo userInfo2, @Nullable ShippingAddressResponse shippingAddressResponse, @NotNull List<BankAccount> list2, @NotNull Date date, @NotNull AdjustmentViewData adjustmentViewData) {
        List<CartLineItemViewData> list3 = list;
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        List<BankAccount> list4 = list2;
        Intrinsics.checkParameterIsNotNull(list4, "bankAccount");
        Date date2 = date;
        Intrinsics.checkParameterIsNotNull(date2, "dueData");
        AdjustmentViewData adjustmentViewData2 = adjustmentViewData;
        Intrinsics.checkParameterIsNotNull(adjustmentViewData2, "pointAdjustmentPolicy");
        OrderInfoViewData orderInfoViewData = new OrderInfoViewData(list3, num, i, i2, i3, userInfo2, shippingAddressResponse, list4, date2, adjustmentViewData2);
        return orderInfoViewData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderInfoViewData) {
                OrderInfoViewData orderInfoViewData = (OrderInfoViewData) obj;
                if (Intrinsics.areEqual((Object) this.lineItems, (Object) orderInfoViewData.lineItems) && Intrinsics.areEqual((Object) this.specialDiscountPrice, (Object) orderInfoViewData.specialDiscountPrice)) {
                    if (this.totalProductCount == orderInfoViewData.totalProductCount) {
                        if (this.totalProductPrice == orderInfoViewData.totalProductPrice) {
                            if (!(this.totalShippingPrice == orderInfoViewData.totalShippingPrice) || !Intrinsics.areEqual((Object) this.userInfo, (Object) orderInfoViewData.userInfo) || !Intrinsics.areEqual((Object) this.userAddress, (Object) orderInfoViewData.userAddress) || !Intrinsics.areEqual((Object) this.bankAccount, (Object) orderInfoViewData.bankAccount) || !Intrinsics.areEqual((Object) this.dueData, (Object) orderInfoViewData.dueData) || !Intrinsics.areEqual((Object) this.pointAdjustmentPolicy, (Object) orderInfoViewData.pointAdjustmentPolicy)) {
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
        List<CartLineItemViewData> list = this.lineItems;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        Integer num = this.specialDiscountPrice;
        int hashCode2 = (((((((hashCode + (num != null ? num.hashCode() : 0)) * 31) + this.totalProductCount) * 31) + this.totalProductPrice) * 31) + this.totalShippingPrice) * 31;
        UserInfo userInfo2 = this.userInfo;
        int hashCode3 = (hashCode2 + (userInfo2 != null ? userInfo2.hashCode() : 0)) * 31;
        ShippingAddressResponse shippingAddressResponse = this.userAddress;
        int hashCode4 = (hashCode3 + (shippingAddressResponse != null ? shippingAddressResponse.hashCode() : 0)) * 31;
        List<BankAccount> list2 = this.bankAccount;
        int hashCode5 = (hashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Date date = this.dueData;
        int hashCode6 = (hashCode5 + (date != null ? date.hashCode() : 0)) * 31;
        AdjustmentViewData adjustmentViewData = this.pointAdjustmentPolicy;
        if (adjustmentViewData != null) {
            i = adjustmentViewData.hashCode();
        }
        return hashCode6 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderInfoViewData(lineItems=");
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
        sb.append(", bankAccount=");
        sb.append(this.bankAccount);
        sb.append(", dueData=");
        sb.append(this.dueData);
        sb.append(", pointAdjustmentPolicy=");
        sb.append(this.pointAdjustmentPolicy);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        List<CartLineItemViewData> list = this.lineItems;
        parcel.writeInt(list.size());
        for (CartLineItemViewData writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        Integer num = this.specialDiscountPrice;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.totalProductCount);
        parcel.writeInt(this.totalProductPrice);
        parcel.writeInt(this.totalShippingPrice);
        UserInfo userInfo2 = this.userInfo;
        if (userInfo2 != null) {
            parcel.writeInt(1);
            userInfo2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        ShippingAddressResponse shippingAddressResponse = this.userAddress;
        if (shippingAddressResponse != null) {
            parcel.writeInt(1);
            shippingAddressResponse.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        List<BankAccount> list2 = this.bankAccount;
        parcel.writeInt(list2.size());
        for (BankAccount writeToParcel2 : list2) {
            writeToParcel2.writeToParcel(parcel, 0);
        }
        parcel.writeSerializable(this.dueData);
        this.pointAdjustmentPolicy.writeToParcel(parcel, 0);
    }

    public OrderInfoViewData(@NotNull List<CartLineItemViewData> list, @Nullable Integer num, int i, int i2, int i3, @Nullable UserInfo userInfo2, @Nullable ShippingAddressResponse shippingAddressResponse, @NotNull List<BankAccount> list2, @NotNull Date date, @NotNull AdjustmentViewData adjustmentViewData) {
        Intrinsics.checkParameterIsNotNull(list, "lineItems");
        Intrinsics.checkParameterIsNotNull(list2, "bankAccount");
        Intrinsics.checkParameterIsNotNull(date, "dueData");
        Intrinsics.checkParameterIsNotNull(adjustmentViewData, "pointAdjustmentPolicy");
        this.lineItems = list;
        this.specialDiscountPrice = num;
        this.totalProductCount = i;
        this.totalProductPrice = i2;
        this.totalShippingPrice = i3;
        this.userInfo = userInfo2;
        this.userAddress = shippingAddressResponse;
        this.bankAccount = list2;
        this.dueData = date;
        this.pointAdjustmentPolicy = adjustmentViewData;
    }

    @NotNull
    public final List<CartLineItemViewData> getLineItems() {
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
    public final List<BankAccount> getBankAccount() {
        return this.bankAccount;
    }

    @NotNull
    public final Date getDueData() {
        return this.dueData;
    }

    @NotNull
    public final AdjustmentViewData getPointAdjustmentPolicy() {
        return this.pointAdjustmentPolicy;
    }

    @NotNull
    public final String getVariantsJson() {
        return CartEntityExtensionKt.mapToLineItemsJson(this.lineItems);
    }
}
