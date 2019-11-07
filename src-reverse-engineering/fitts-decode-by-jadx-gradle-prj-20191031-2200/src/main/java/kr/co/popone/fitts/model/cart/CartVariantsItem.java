package kr.co.popone.fitts.model.cart;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.commerce.discount.SpecialDiscount;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartVariantsItem implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @NotNull
    private final String coverImageUrl;
    private boolean isCheckedOption;
    private final boolean isSoldOut;
    private final long lineItemId;
    private final int originPrice;
    private int productCount;
    @NotNull
    private final String productName;
    @NotNull
    private final String productOption;
    @Nullable
    private final Integer saleRate;
    private final int salesPrice;
    @Nullable
    private final SpecialDiscount specialDiscountInfo;
    @Nullable
    private final String storeLinkUrl;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkParameterIsNotNull(parcel2, "in");
            long readLong = parcel.readLong();
            boolean z = parcel.readInt() != 0;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            SpecialDiscount specialDiscount = null;
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                specialDiscount = (SpecialDiscount) SpecialDiscount.CREATOR.createFromParcel(parcel2);
            }
            CartVariantsItem cartVariantsItem = new CartVariantsItem(readLong, z, readString, readString2, readString3, readInt, readInt2, valueOf, readString4, specialDiscount, parcel.readInt(), parcel.readInt() != 0);
            return cartVariantsItem;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new CartVariantsItem[i];
        }
    }

    @NotNull
    public static /* synthetic */ CartVariantsItem copy$default(CartVariantsItem cartVariantsItem, long j, boolean z, String str, String str2, String str3, int i, int i2, Integer num, String str4, SpecialDiscount specialDiscount, int i3, boolean z2, int i4, Object obj) {
        CartVariantsItem cartVariantsItem2 = cartVariantsItem;
        int i5 = i4;
        return cartVariantsItem.copy((i5 & 1) != 0 ? cartVariantsItem2.lineItemId : j, (i5 & 2) != 0 ? cartVariantsItem2.isSoldOut : z, (i5 & 4) != 0 ? cartVariantsItem2.coverImageUrl : str, (i5 & 8) != 0 ? cartVariantsItem2.storeLinkUrl : str2, (i5 & 16) != 0 ? cartVariantsItem2.productName : str3, (i5 & 32) != 0 ? cartVariantsItem2.originPrice : i, (i5 & 64) != 0 ? cartVariantsItem2.salesPrice : i2, (i5 & 128) != 0 ? cartVariantsItem2.saleRate : num, (i5 & 256) != 0 ? cartVariantsItem2.productOption : str4, (i5 & 512) != 0 ? cartVariantsItem2.specialDiscountInfo : specialDiscount, (i5 & 1024) != 0 ? cartVariantsItem2.productCount : i3, (i5 & 2048) != 0 ? cartVariantsItem2.isCheckedOption : z2);
    }

    public final long component1() {
        return this.lineItemId;
    }

    @Nullable
    public final SpecialDiscount component10() {
        return this.specialDiscountInfo;
    }

    public final int component11() {
        return this.productCount;
    }

    public final boolean component12() {
        return this.isCheckedOption;
    }

    public final boolean component2() {
        return this.isSoldOut;
    }

    @NotNull
    public final String component3() {
        return this.coverImageUrl;
    }

    @Nullable
    public final String component4() {
        return this.storeLinkUrl;
    }

    @NotNull
    public final String component5() {
        return this.productName;
    }

    public final int component6() {
        return this.originPrice;
    }

    public final int component7() {
        return this.salesPrice;
    }

    @Nullable
    public final Integer component8() {
        return this.saleRate;
    }

    @NotNull
    public final String component9() {
        return this.productOption;
    }

    @NotNull
    public final CartVariantsItem copy(long j, boolean z, @NotNull String str, @Nullable String str2, @NotNull String str3, int i, int i2, @Nullable Integer num, @NotNull String str4, @Nullable SpecialDiscount specialDiscount, int i3, boolean z2) {
        String str5 = str;
        Intrinsics.checkParameterIsNotNull(str5, "coverImageUrl");
        String str6 = str3;
        Intrinsics.checkParameterIsNotNull(str6, "productName");
        String str7 = str4;
        Intrinsics.checkParameterIsNotNull(str7, "productOption");
        CartVariantsItem cartVariantsItem = new CartVariantsItem(j, z, str5, str2, str6, i, i2, num, str7, specialDiscount, i3, z2);
        return cartVariantsItem;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartVariantsItem) {
                CartVariantsItem cartVariantsItem = (CartVariantsItem) obj;
                if (this.lineItemId == cartVariantsItem.lineItemId) {
                    if ((this.isSoldOut == cartVariantsItem.isSoldOut) && Intrinsics.areEqual((Object) this.coverImageUrl, (Object) cartVariantsItem.coverImageUrl) && Intrinsics.areEqual((Object) this.storeLinkUrl, (Object) cartVariantsItem.storeLinkUrl) && Intrinsics.areEqual((Object) this.productName, (Object) cartVariantsItem.productName)) {
                        if (this.originPrice == cartVariantsItem.originPrice) {
                            if ((this.salesPrice == cartVariantsItem.salesPrice) && Intrinsics.areEqual((Object) this.saleRate, (Object) cartVariantsItem.saleRate) && Intrinsics.areEqual((Object) this.productOption, (Object) cartVariantsItem.productOption) && Intrinsics.areEqual((Object) this.specialDiscountInfo, (Object) cartVariantsItem.specialDiscountInfo)) {
                                if (this.productCount == cartVariantsItem.productCount) {
                                    if (this.isCheckedOption == cartVariantsItem.isCheckedOption) {
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
        long j = this.lineItemId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z = this.isSoldOut;
        if (z) {
            z = true;
        }
        int i2 = (i + (z ? 1 : 0)) * 31;
        String str = this.coverImageUrl;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.storeLinkUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.productName;
        int hashCode3 = (((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.originPrice) * 31) + this.salesPrice) * 31;
        Integer num = this.saleRate;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        String str4 = this.productOption;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        SpecialDiscount specialDiscount = this.specialDiscountInfo;
        if (specialDiscount != null) {
            i3 = specialDiscount.hashCode();
        }
        int i4 = (((hashCode5 + i3) * 31) + this.productCount) * 31;
        boolean z2 = this.isCheckedOption;
        if (z2) {
            z2 = true;
        }
        return i4 + (z2 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CartVariantsItem(lineItemId=");
        sb.append(this.lineItemId);
        sb.append(", isSoldOut=");
        sb.append(this.isSoldOut);
        sb.append(", coverImageUrl=");
        sb.append(this.coverImageUrl);
        sb.append(", storeLinkUrl=");
        sb.append(this.storeLinkUrl);
        sb.append(", productName=");
        sb.append(this.productName);
        sb.append(", originPrice=");
        sb.append(this.originPrice);
        sb.append(", salesPrice=");
        sb.append(this.salesPrice);
        sb.append(", saleRate=");
        sb.append(this.saleRate);
        sb.append(", productOption=");
        sb.append(this.productOption);
        sb.append(", specialDiscountInfo=");
        sb.append(this.specialDiscountInfo);
        sb.append(", productCount=");
        sb.append(this.productCount);
        sb.append(", isCheckedOption=");
        sb.append(this.isCheckedOption);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.lineItemId);
        parcel.writeInt(this.isSoldOut ? 1 : 0);
        parcel.writeString(this.coverImageUrl);
        parcel.writeString(this.storeLinkUrl);
        parcel.writeString(this.productName);
        parcel.writeInt(this.originPrice);
        parcel.writeInt(this.salesPrice);
        Integer num = this.saleRate;
        if (num != null) {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.productOption);
        SpecialDiscount specialDiscount = this.specialDiscountInfo;
        if (specialDiscount != null) {
            parcel.writeInt(1);
            specialDiscount.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.productCount);
        parcel.writeInt(this.isCheckedOption ? 1 : 0);
    }

    public CartVariantsItem(long j, boolean z, @NotNull String str, @Nullable String str2, @NotNull String str3, int i, int i2, @Nullable Integer num, @NotNull String str4, @Nullable SpecialDiscount specialDiscount, int i3, boolean z2) {
        Intrinsics.checkParameterIsNotNull(str, "coverImageUrl");
        Intrinsics.checkParameterIsNotNull(str3, "productName");
        Intrinsics.checkParameterIsNotNull(str4, "productOption");
        this.lineItemId = j;
        this.isSoldOut = z;
        this.coverImageUrl = str;
        this.storeLinkUrl = str2;
        this.productName = str3;
        this.originPrice = i;
        this.salesPrice = i2;
        this.saleRate = num;
        this.productOption = str4;
        this.specialDiscountInfo = specialDiscount;
        this.productCount = i3;
        this.isCheckedOption = z2;
    }

    public final long getLineItemId() {
        return this.lineItemId;
    }

    public final boolean isSoldOut() {
        return this.isSoldOut;
    }

    @NotNull
    public final String getCoverImageUrl() {
        return this.coverImageUrl;
    }

    @Nullable
    public final String getStoreLinkUrl() {
        return this.storeLinkUrl;
    }

    @NotNull
    public final String getProductName() {
        return this.productName;
    }

    public final int getOriginPrice() {
        return this.originPrice;
    }

    public final int getSalesPrice() {
        return this.salesPrice;
    }

    @Nullable
    public final Integer getSaleRate() {
        return this.saleRate;
    }

    @NotNull
    public final String getProductOption() {
        return this.productOption;
    }

    @Nullable
    public final SpecialDiscount getSpecialDiscountInfo() {
        return this.specialDiscountInfo;
    }

    public final int getProductCount() {
        return this.productCount;
    }

    public final void setProductCount(int i) {
        this.productCount = i;
    }

    public final boolean isCheckedOption() {
        return this.isCheckedOption;
    }

    public final void setCheckedOption(boolean z) {
        this.isCheckedOption = z;
    }
}
