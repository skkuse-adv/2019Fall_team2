package kr.co.popone.fitts.model.cart;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartLineItemViewData implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private int lineItemOrderPrice;
    private int lineItemProductPrice;
    private int lineItemShippingPrice;
    @NotNull
    private final List<CartVariantsItem> productVariants;
    private final long storeId;
    @NotNull
    private final String storeTitle;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            long readLong = parcel.readLong();
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt4);
            while (readInt4 != 0) {
                arrayList.add((CartVariantsItem) CartVariantsItem.CREATOR.createFromParcel(parcel));
                readInt4--;
            }
            CartLineItemViewData cartLineItemViewData = new CartLineItemViewData(readLong, readString, readInt, readInt2, readInt3, arrayList);
            return cartLineItemViewData;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new CartLineItemViewData[i];
        }
    }

    @NotNull
    public static /* synthetic */ CartLineItemViewData copy$default(CartLineItemViewData cartLineItemViewData, long j, String str, int i, int i2, int i3, List list, int i4, Object obj) {
        CartLineItemViewData cartLineItemViewData2 = cartLineItemViewData;
        return cartLineItemViewData.copy((i4 & 1) != 0 ? cartLineItemViewData2.storeId : j, (i4 & 2) != 0 ? cartLineItemViewData2.storeTitle : str, (i4 & 4) != 0 ? cartLineItemViewData2.lineItemProductPrice : i, (i4 & 8) != 0 ? cartLineItemViewData2.lineItemShippingPrice : i2, (i4 & 16) != 0 ? cartLineItemViewData2.lineItemOrderPrice : i3, (i4 & 32) != 0 ? cartLineItemViewData2.productVariants : list);
    }

    public final long component1() {
        return this.storeId;
    }

    @NotNull
    public final String component2() {
        return this.storeTitle;
    }

    public final int component3() {
        return this.lineItemProductPrice;
    }

    public final int component4() {
        return this.lineItemShippingPrice;
    }

    public final int component5() {
        return this.lineItemOrderPrice;
    }

    @NotNull
    public final List<CartVariantsItem> component6() {
        return this.productVariants;
    }

    @NotNull
    public final CartLineItemViewData copy(long j, @NotNull String str, int i, int i2, int i3, @NotNull List<CartVariantsItem> list) {
        String str2 = str;
        Intrinsics.checkParameterIsNotNull(str, "storeTitle");
        List<CartVariantsItem> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "productVariants");
        CartLineItemViewData cartLineItemViewData = new CartLineItemViewData(j, str2, i, i2, i3, list2);
        return cartLineItemViewData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartLineItemViewData) {
                CartLineItemViewData cartLineItemViewData = (CartLineItemViewData) obj;
                if ((this.storeId == cartLineItemViewData.storeId) && Intrinsics.areEqual((Object) this.storeTitle, (Object) cartLineItemViewData.storeTitle)) {
                    if (this.lineItemProductPrice == cartLineItemViewData.lineItemProductPrice) {
                        if (this.lineItemShippingPrice == cartLineItemViewData.lineItemShippingPrice) {
                            if (!(this.lineItemOrderPrice == cartLineItemViewData.lineItemOrderPrice) || !Intrinsics.areEqual((Object) this.productVariants, (Object) cartLineItemViewData.productVariants)) {
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
        long j = this.storeId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.storeTitle;
        int i2 = 0;
        int hashCode = (((((((i + (str != null ? str.hashCode() : 0)) * 31) + this.lineItemProductPrice) * 31) + this.lineItemShippingPrice) * 31) + this.lineItemOrderPrice) * 31;
        List<CartVariantsItem> list = this.productVariants;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartLineItemViewData(storeId=");
        sb.append(this.storeId);
        sb.append(", storeTitle=");
        sb.append(this.storeTitle);
        sb.append(", lineItemProductPrice=");
        sb.append(this.lineItemProductPrice);
        sb.append(", lineItemShippingPrice=");
        sb.append(this.lineItemShippingPrice);
        sb.append(", lineItemOrderPrice=");
        sb.append(this.lineItemOrderPrice);
        sb.append(", productVariants=");
        sb.append(this.productVariants);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.storeId);
        parcel.writeString(this.storeTitle);
        parcel.writeInt(this.lineItemProductPrice);
        parcel.writeInt(this.lineItemShippingPrice);
        parcel.writeInt(this.lineItemOrderPrice);
        List<CartVariantsItem> list = this.productVariants;
        parcel.writeInt(list.size());
        for (CartVariantsItem writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public CartLineItemViewData(long j, @NotNull String str, int i, int i2, int i3, @NotNull List<CartVariantsItem> list) {
        Intrinsics.checkParameterIsNotNull(str, "storeTitle");
        Intrinsics.checkParameterIsNotNull(list, "productVariants");
        this.storeId = j;
        this.storeTitle = str;
        this.lineItemProductPrice = i;
        this.lineItemShippingPrice = i2;
        this.lineItemOrderPrice = i3;
        this.productVariants = list;
    }

    public final long getStoreId() {
        return this.storeId;
    }

    @NotNull
    public final String getStoreTitle() {
        return this.storeTitle;
    }

    public final int getLineItemProductPrice() {
        return this.lineItemProductPrice;
    }

    public final void setLineItemProductPrice(int i) {
        this.lineItemProductPrice = i;
    }

    public final int getLineItemShippingPrice() {
        return this.lineItemShippingPrice;
    }

    public final void setLineItemShippingPrice(int i) {
        this.lineItemShippingPrice = i;
    }

    public final int getLineItemOrderPrice() {
        return this.lineItemOrderPrice;
    }

    public final void setLineItemOrderPrice(int i) {
        this.lineItemOrderPrice = i;
    }

    @NotNull
    public final List<CartVariantsItem> getProductVariants() {
        return this.productVariants;
    }
}
