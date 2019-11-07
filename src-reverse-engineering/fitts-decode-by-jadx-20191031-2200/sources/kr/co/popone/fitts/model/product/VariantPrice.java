package kr.co.popone.fitts.model.product;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VariantPrice {
    private final int quantity;
    private final long variant_id;

    @NotNull
    public static /* synthetic */ VariantPrice copy$default(VariantPrice variantPrice, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = variantPrice.variant_id;
        }
        if ((i2 & 2) != 0) {
            i = variantPrice.quantity;
        }
        return variantPrice.copy(j, i);
    }

    public final long component1() {
        return this.variant_id;
    }

    public final int component2() {
        return this.quantity;
    }

    @NotNull
    public final VariantPrice copy(long j, int i) {
        return new VariantPrice(j, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof VariantPrice) {
                VariantPrice variantPrice = (VariantPrice) obj;
                if (this.variant_id == variantPrice.variant_id) {
                    if (this.quantity == variantPrice.quantity) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.variant_id;
        return (((int) (j ^ (j >>> 32))) * 31) + this.quantity;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VariantPrice(variant_id=");
        sb.append(this.variant_id);
        sb.append(", quantity=");
        sb.append(this.quantity);
        sb.append(")");
        return sb.toString();
    }

    public VariantPrice(long j, int i) {
        this.variant_id = j;
        this.quantity = i;
    }

    public final long getVariant_id() {
        return this.variant_id;
    }

    public final int getQuantity() {
        return this.quantity;
    }
}
