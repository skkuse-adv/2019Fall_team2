package kr.co.popone.fitts.model.datamodel.commerce.wish;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class WishProduct {
    @SerializedName("is_in_wish_lists")
    private final boolean isWishProduct;

    @NotNull
    public static /* synthetic */ WishProduct copy$default(WishProduct wishProduct, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = wishProduct.isWishProduct;
        }
        return wishProduct.copy(z);
    }

    public final boolean component1() {
        return this.isWishProduct;
    }

    @NotNull
    public final WishProduct copy(boolean z) {
        return new WishProduct(z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof WishProduct) {
                if (this.isWishProduct == ((WishProduct) obj).isWishProduct) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.isWishProduct;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WishProduct(isWishProduct=");
        sb.append(this.isWishProduct);
        sb.append(")");
        return sb.toString();
    }

    public WishProduct(boolean z) {
        this.isWishProduct = z;
    }

    public final boolean isWishProduct() {
        return this.isWishProduct;
    }
}
