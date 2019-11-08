package kr.co.popone.fitts.model.datamodel.commerce;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.IntRange;
import com.google.gson.annotations.SerializedName;
import com.uber.rave.annotation.Validated;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.validation.ValidatorFactoryImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Validated(factory = ValidatorFactoryImpl.class)
public final class Product implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    private final long id;
    @SerializedName("image_url")
    @NotNull
    private final String imageUrl;
    @SerializedName("link_url")
    @NotNull
    private final String linkUrl;
    @Nullable
    private final String name;
    @Nullable
    private final String price;
    @SerializedName("no")
    @NotNull
    private final String productNumber;
    @Nullable
    private final Shop shop;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            Product product = new Product(parcel.readLong(), parcel.readString(), parcel.readInt() != 0 ? (Shop) Shop.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            return product;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new Product[i];
        }
    }

    @NotNull
    public static /* synthetic */ Product copy$default(Product product, long j, String str, Shop shop2, String str2, String str3, String str4, String str5, int i, Object obj) {
        Product product2 = product;
        return product.copy((i & 1) != 0 ? product2.id : j, (i & 2) != 0 ? product2.productNumber : str, (i & 4) != 0 ? product2.shop : shop2, (i & 8) != 0 ? product2.name : str2, (i & 16) != 0 ? product2.price : str3, (i & 32) != 0 ? product2.imageUrl : str4, (i & 64) != 0 ? product2.linkUrl : str5);
    }

    public final long component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.productNumber;
    }

    @Nullable
    public final Shop component3() {
        return this.shop;
    }

    @Nullable
    public final String component4() {
        return this.name;
    }

    @Nullable
    public final String component5() {
        return this.price;
    }

    @NotNull
    public final String component6() {
        return this.imageUrl;
    }

    @NotNull
    public final String component7() {
        return this.linkUrl;
    }

    @NotNull
    public final Product copy(long j, @NotNull String str, @Nullable Shop shop2, @Nullable String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5) {
        String str6 = str;
        Intrinsics.checkParameterIsNotNull(str, "productNumber");
        String str7 = str4;
        Intrinsics.checkParameterIsNotNull(str7, "imageUrl");
        String str8 = str5;
        Intrinsics.checkParameterIsNotNull(str8, "linkUrl");
        Product product = new Product(j, str6, shop2, str2, str3, str7, str8);
        return product;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof Product) {
                Product product = (Product) obj;
                if (!(this.id == product.id) || !Intrinsics.areEqual((Object) this.productNumber, (Object) product.productNumber) || !Intrinsics.areEqual((Object) this.shop, (Object) product.shop) || !Intrinsics.areEqual((Object) this.name, (Object) product.name) || !Intrinsics.areEqual((Object) this.price, (Object) product.price) || !Intrinsics.areEqual((Object) this.imageUrl, (Object) product.imageUrl) || !Intrinsics.areEqual((Object) this.linkUrl, (Object) product.linkUrl)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.productNumber;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Shop shop2 = this.shop;
        int hashCode2 = (hashCode + (shop2 != null ? shop2.hashCode() : 0)) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.price;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imageUrl;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.linkUrl;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode5 + i2;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product(id=");
        sb.append(this.id);
        sb.append(", productNumber=");
        sb.append(this.productNumber);
        sb.append(", shop=");
        sb.append(this.shop);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", imageUrl=");
        sb.append(this.imageUrl);
        sb.append(", linkUrl=");
        sb.append(this.linkUrl);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeString(this.productNumber);
        Shop shop2 = this.shop;
        if (shop2 != null) {
            parcel.writeInt(1);
            shop2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.name);
        parcel.writeString(this.price);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.linkUrl);
    }

    public Product(long j, @NotNull String str, @Nullable Shop shop2, @Nullable String str2, @Nullable String str3, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkParameterIsNotNull(str, "productNumber");
        Intrinsics.checkParameterIsNotNull(str4, "imageUrl");
        Intrinsics.checkParameterIsNotNull(str5, "linkUrl");
        this.id = j;
        this.productNumber = str;
        this.shop = shop2;
        this.name = str2;
        this.price = str3;
        this.imageUrl = str4;
        this.linkUrl = str5;
    }

    @IntRange(from = 1)
    public final long getId() {
        return this.id;
    }

    @NotNull
    public final String getProductNumber() {
        return this.productNumber;
    }

    @Nullable
    public final Shop getShop() {
        return this.shop;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPrice() {
        return this.price;
    }

    @NotNull
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @NotNull
    public final String getLinkUrl() {
        return this.linkUrl;
    }
}
