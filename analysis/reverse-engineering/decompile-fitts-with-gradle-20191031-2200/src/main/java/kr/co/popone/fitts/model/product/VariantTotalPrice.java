package kr.co.popone.fitts.model.product;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VariantTotalPrice {
    @SerializedName("total_price")
    private final int totalPrice;

    @NotNull
    public static /* synthetic */ VariantTotalPrice copy$default(VariantTotalPrice variantTotalPrice, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = variantTotalPrice.totalPrice;
        }
        return variantTotalPrice.copy(i);
    }

    public final int component1() {
        return this.totalPrice;
    }

    @NotNull
    public final VariantTotalPrice copy(int i) {
        return new VariantTotalPrice(i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof VariantTotalPrice) {
                if (this.totalPrice == ((VariantTotalPrice) obj).totalPrice) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.totalPrice;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VariantTotalPrice(totalPrice=");
        sb.append(this.totalPrice);
        sb.append(")");
        return sb.toString();
    }

    public VariantTotalPrice(int i) {
        this.totalPrice = i;
    }

    public final int getTotalPrice() {
        return this.totalPrice;
    }
}
