package kr.co.popone.fitts.model.product;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class PreOrderVariant {
    private final long variant_id;

    @NotNull
    public static /* synthetic */ PreOrderVariant copy$default(PreOrderVariant preOrderVariant, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = preOrderVariant.variant_id;
        }
        return preOrderVariant.copy(j);
    }

    public final long component1() {
        return this.variant_id;
    }

    @NotNull
    public final PreOrderVariant copy(long j) {
        return new PreOrderVariant(j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PreOrderVariant) {
                if (this.variant_id == ((PreOrderVariant) obj).variant_id) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.variant_id;
        return (int) (j ^ (j >>> 32));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PreOrderVariant(variant_id=");
        sb.append(this.variant_id);
        sb.append(")");
        return sb.toString();
    }

    public PreOrderVariant(long j) {
        this.variant_id = j;
    }

    public final long getVariant_id() {
        return this.variant_id;
    }
}
