package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartEvent$VariantsRemoveEvent {
    private final long variantId;

    @NotNull
    public static /* synthetic */ CartEvent$VariantsRemoveEvent copy$default(CartEvent$VariantsRemoveEvent cartEvent$VariantsRemoveEvent, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = cartEvent$VariantsRemoveEvent.variantId;
        }
        return cartEvent$VariantsRemoveEvent.copy(j);
    }

    public final long component1() {
        return this.variantId;
    }

    @NotNull
    public final CartEvent$VariantsRemoveEvent copy(long j) {
        return new CartEvent$VariantsRemoveEvent(j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartEvent$VariantsRemoveEvent) {
                if (this.variantId == ((CartEvent$VariantsRemoveEvent) obj).variantId) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.variantId;
        return (int) (j ^ (j >>> 32));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VariantsRemoveEvent(variantId=");
        sb.append(this.variantId);
        sb.append(")");
        return sb.toString();
    }

    public CartEvent$VariantsRemoveEvent(long j) {
        this.variantId = j;
    }

    public final long getVariantId() {
        return this.variantId;
    }
}
