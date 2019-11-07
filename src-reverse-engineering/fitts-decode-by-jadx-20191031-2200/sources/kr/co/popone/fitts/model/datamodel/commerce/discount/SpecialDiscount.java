package kr.co.popone.fitts.model.datamodel.commerce.discount;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.product.Product;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialDiscount implements Parcelable {
    public static final android.os.Parcelable.Creator CREATOR = new Creator();
    @SerializedName("current_stock")
    private final int currentStock;
    private final long id;
    @SerializedName("limit_stock")
    private final int limitStock;
    @SerializedName("product")
    @Nullable
    private final Product product;
    @SerializedName("special_price")
    private final long specialPrice;
    @SerializedName("supply_price")
    private final long supplyPrice;
    @SerializedName("feed_type")
    @Nullable
    private final Type type;

    public static class Creator implements android.os.Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            SpecialDiscount specialDiscount = new SpecialDiscount(parcel.readLong(), parcel.readLong(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0 ? (Type) Enum.valueOf(Type.class, parcel.readString()) : null, parcel.readInt() != 0 ? (Product) Product.CREATOR.createFromParcel(parcel) : null);
            return specialDiscount;
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new SpecialDiscount[i];
        }
    }

    public enum Type {
        SINGLE,
        GRID
    }

    @NotNull
    public static /* synthetic */ SpecialDiscount copy$default(SpecialDiscount specialDiscount, long j, long j2, long j3, int i, int i2, Type type2, Product product2, int i3, Object obj) {
        SpecialDiscount specialDiscount2 = specialDiscount;
        return specialDiscount.copy((i3 & 1) != 0 ? specialDiscount2.id : j, (i3 & 2) != 0 ? specialDiscount2.specialPrice : j2, (i3 & 4) != 0 ? specialDiscount2.supplyPrice : j3, (i3 & 8) != 0 ? specialDiscount2.limitStock : i, (i3 & 16) != 0 ? specialDiscount2.currentStock : i2, (i3 & 32) != 0 ? specialDiscount2.type : type2, (i3 & 64) != 0 ? specialDiscount2.product : product2);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.specialPrice;
    }

    public final long component3() {
        return this.supplyPrice;
    }

    public final int component4() {
        return this.limitStock;
    }

    public final int component5() {
        return this.currentStock;
    }

    @Nullable
    public final Type component6() {
        return this.type;
    }

    @Nullable
    public final Product component7() {
        return this.product;
    }

    @NotNull
    public final SpecialDiscount copy(long j, long j2, long j3, int i, int i2, @Nullable Type type2, @Nullable Product product2) {
        SpecialDiscount specialDiscount = new SpecialDiscount(j, j2, j3, i, i2, type2, product2);
        return specialDiscount;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SpecialDiscount) {
                SpecialDiscount specialDiscount = (SpecialDiscount) obj;
                if (this.id == specialDiscount.id) {
                    if (this.specialPrice == specialDiscount.specialPrice) {
                        if (this.supplyPrice == specialDiscount.supplyPrice) {
                            if (this.limitStock == specialDiscount.limitStock) {
                                if (!(this.currentStock == specialDiscount.currentStock) || !Intrinsics.areEqual((Object) this.type, (Object) specialDiscount.type) || !Intrinsics.areEqual((Object) this.product, (Object) specialDiscount.product)) {
                                    return false;
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
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.specialPrice;
        int i2 = (i + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.supplyPrice;
        int i3 = (((((i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.limitStock) * 31) + this.currentStock) * 31;
        Type type2 = this.type;
        int i4 = 0;
        int hashCode = (i3 + (type2 != null ? type2.hashCode() : 0)) * 31;
        Product product2 = this.product;
        if (product2 != null) {
            i4 = product2.hashCode();
        }
        return hashCode + i4;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SpecialDiscount(id=");
        sb.append(this.id);
        sb.append(", specialPrice=");
        sb.append(this.specialPrice);
        sb.append(", supplyPrice=");
        sb.append(this.supplyPrice);
        sb.append(", limitStock=");
        sb.append(this.limitStock);
        sb.append(", currentStock=");
        sb.append(this.currentStock);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", product=");
        sb.append(this.product);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeLong(this.id);
        parcel.writeLong(this.specialPrice);
        parcel.writeLong(this.supplyPrice);
        parcel.writeInt(this.limitStock);
        parcel.writeInt(this.currentStock);
        Type type2 = this.type;
        if (type2 != null) {
            parcel.writeInt(1);
            parcel.writeString(type2.name());
        } else {
            parcel.writeInt(0);
        }
        Product product2 = this.product;
        if (product2 != null) {
            parcel.writeInt(1);
            product2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public SpecialDiscount(long j, long j2, long j3, int i, int i2, @Nullable Type type2, @Nullable Product product2) {
        this.id = j;
        this.specialPrice = j2;
        this.supplyPrice = j3;
        this.limitStock = i;
        this.currentStock = i2;
        this.type = type2;
        this.product = product2;
    }

    public final long getId() {
        return this.id;
    }

    public final long getSpecialPrice() {
        return this.specialPrice;
    }

    public final long getSupplyPrice() {
        return this.supplyPrice;
    }

    public final int getLimitStock() {
        return this.limitStock;
    }

    public final int getCurrentStock() {
        return this.currentStock;
    }

    @Nullable
    public final Type getType() {
        return this.type;
    }

    @Nullable
    public final Product getProduct() {
        return this.product;
    }

    @Nullable
    public final String getDiscountPercentage() {
        Product product2 = this.product;
        if (product2 == null) {
            return null;
        }
        double originPrice = (double) product2.getOriginPrice();
        double d = (double) this.specialPrice;
        Double.isNaN(d);
        Double.isNaN(originPrice);
        double d2 = d / originPrice;
        double d3 = (double) 100;
        Double.isNaN(d3);
        double d4 = d2 * d3;
        StringBuilder sb = new StringBuilder();
        sb.append(100 - ((int) d4));
        sb.append('%');
        return sb.toString();
    }
}
