package kr.co.popone.fitts.model.product;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.datamodel.social.feed.FeedItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Product implements Parcelable, FeedItem {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @SerializedName("discount_percentage")
    @Nullable
    private final Double discountRate;
    private final long id;
    @SerializedName("is_in_wish_list")
    private boolean isInWishList;
    @SerializedName("mobile_link_url")
    @Nullable
    private final String mobileLinkUrl;
    @SerializedName("origin_price")
    private final long originPrice;
    @SerializedName("sales_price")
    private final long salesPrice;
    @SerializedName("image_url")
    @NotNull
    private final String shopImageUrl;
    @SerializedName("link_url")
    @NotNull
    private final String shopLinkUrl;
    @SerializedName("state")
    @NotNull
    private final String state;
    @SerializedName("title")
    @NotNull
    private final String title;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            Product product = new Product(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null, parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readInt() != 0);
            return product;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new Product[i];
        }
    }

    @NotNull
    public static /* synthetic */ Product copy$default(Product product, long j, String str, String str2, String str3, long j2, Double d, String str4, String str5, long j3, boolean z, int i, Object obj) {
        Product product2 = product;
        int i2 = i;
        return product.copy((i2 & 1) != 0 ? product2.id : j, (i2 & 2) != 0 ? product2.title : str, (i2 & 4) != 0 ? product2.shopImageUrl : str2, (i2 & 8) != 0 ? product2.shopLinkUrl : str3, (i2 & 16) != 0 ? product2.originPrice : j2, (i2 & 32) != 0 ? product2.discountRate : d, (i2 & 64) != 0 ? product2.state : str4, (i2 & 128) != 0 ? product2.mobileLinkUrl : str5, (i2 & 256) != 0 ? product2.salesPrice : j3, (i2 & 512) != 0 ? product2.isInWishList : z);
    }

    public final long component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.isInWishList;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.shopImageUrl;
    }

    @NotNull
    public final String component4() {
        return this.shopLinkUrl;
    }

    public final long component5() {
        return this.originPrice;
    }

    @Nullable
    public final Double component6() {
        return this.discountRate;
    }

    @NotNull
    public final String component7() {
        return this.state;
    }

    @Nullable
    public final String component8() {
        return this.mobileLinkUrl;
    }

    public final long component9() {
        return this.salesPrice;
    }

    @NotNull
    public final Product copy(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, long j2, @Nullable Double d, @NotNull String str4, @Nullable String str5, long j3, boolean z) {
        String str6 = str;
        Intrinsics.checkParameterIsNotNull(str6, "title");
        String str7 = str2;
        Intrinsics.checkParameterIsNotNull(str7, "shopImageUrl");
        String str8 = str3;
        Intrinsics.checkParameterIsNotNull(str8, "shopLinkUrl");
        String str9 = str4;
        Intrinsics.checkParameterIsNotNull(str9, ServerProtocol.DIALOG_PARAM_STATE);
        Product product = new Product(j, str6, str7, str8, j2, d, str9, str5, j3, z);
        return product;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Product) {
                Product product = (Product) obj;
                if ((this.id == product.id) && Intrinsics.areEqual((Object) this.title, (Object) product.title) && Intrinsics.areEqual((Object) this.shopImageUrl, (Object) product.shopImageUrl) && Intrinsics.areEqual((Object) this.shopLinkUrl, (Object) product.shopLinkUrl)) {
                    if ((this.originPrice == product.originPrice) && Intrinsics.areEqual((Object) this.discountRate, (Object) product.discountRate) && Intrinsics.areEqual((Object) this.state, (Object) product.state) && Intrinsics.areEqual((Object) this.mobileLinkUrl, (Object) product.mobileLinkUrl)) {
                        if (this.salesPrice == product.salesPrice) {
                            if (this.isInWishList == product.isInWishList) {
                                return true;
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
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.title;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.shopImageUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.shopLinkUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        long j2 = this.originPrice;
        int i3 = (hashCode3 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        Double d = this.discountRate;
        int hashCode4 = (i3 + (d != null ? d.hashCode() : 0)) * 31;
        String str4 = this.state;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mobileLinkUrl;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i4 = (hashCode5 + i2) * 31;
        long j3 = this.salesPrice;
        int i5 = (i4 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        boolean z = this.isInWishList;
        if (z) {
            z = true;
        }
        return i5 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product(id=");
        sb.append(this.id);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", shopImageUrl=");
        sb.append(this.shopImageUrl);
        sb.append(", shopLinkUrl=");
        sb.append(this.shopLinkUrl);
        sb.append(", originPrice=");
        sb.append(this.originPrice);
        sb.append(", discountRate=");
        sb.append(this.discountRate);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", mobileLinkUrl=");
        sb.append(this.mobileLinkUrl);
        sb.append(", salesPrice=");
        sb.append(this.salesPrice);
        sb.append(", isInWishList=");
        sb.append(this.isInWishList);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.shopImageUrl);
        parcel.writeString(this.shopLinkUrl);
        parcel.writeLong(this.originPrice);
        Double d = this.discountRate;
        if (d != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.state);
        parcel.writeString(this.mobileLinkUrl);
        parcel.writeLong(this.salesPrice);
        parcel.writeInt(this.isInWishList ? 1 : 0);
    }

    public Product(long j, @NotNull String str, @NotNull String str2, @NotNull String str3, long j2, @Nullable Double d, @NotNull String str4, @Nullable String str5, long j3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, "shopImageUrl");
        Intrinsics.checkParameterIsNotNull(str3, "shopLinkUrl");
        Intrinsics.checkParameterIsNotNull(str4, ServerProtocol.DIALOG_PARAM_STATE);
        this.id = j;
        this.title = str;
        this.shopImageUrl = str2;
        this.shopLinkUrl = str3;
        this.originPrice = j2;
        this.discountRate = d;
        this.state = str4;
        this.mobileLinkUrl = str5;
        this.salesPrice = j3;
        this.isInWishList = z;
    }

    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getShopImageUrl() {
        return this.shopImageUrl;
    }

    @NotNull
    public final String getShopLinkUrl() {
        return this.shopLinkUrl;
    }

    public final long getOriginPrice() {
        return this.originPrice;
    }

    @Nullable
    public final Double getDiscountRate() {
        return this.discountRate;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    @Nullable
    public final String getMobileLinkUrl() {
        return this.mobileLinkUrl;
    }

    public final long getSalesPrice() {
        return this.salesPrice;
    }

    public final boolean isInWishList() {
        return this.isInWishList;
    }

    public final void setInWishList(boolean z) {
        this.isInWishList = z;
    }

    public final boolean isEmptyProduct() {
        if (this.shopImageUrl.length() == 0) {
            return true;
        }
        return this.shopLinkUrl.length() == 0;
    }

    public final boolean isDiscount() {
        Double d = this.discountRate;
        return d != null && d.doubleValue() > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }
}
