package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CartEvent$VariantsEditEvent {
    private final int count;
    private final long variantId;

    @NotNull
    public static /* synthetic */ CartEvent$VariantsEditEvent copy$default(CartEvent$VariantsEditEvent cartEvent$VariantsEditEvent, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = cartEvent$VariantsEditEvent.variantId;
        }
        if ((i2 & 2) != 0) {
            i = cartEvent$VariantsEditEvent.count;
        }
        return cartEvent$VariantsEditEvent.copy(j, i);
    }

    public final long component1() {
        return this.variantId;
    }

    public final int component2() {
        return this.count;
    }

    @NotNull
    public final CartEvent$VariantsEditEvent copy(long j, int i) {
        return new CartEvent$VariantsEditEvent(j, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CartEvent$VariantsEditEvent) {
                CartEvent$VariantsEditEvent cartEvent$VariantsEditEvent = (CartEvent$VariantsEditEvent) obj;
                if (this.variantId == cartEvent$VariantsEditEvent.variantId) {
                    if (this.count == cartEvent$VariantsEditEvent.count) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.variantId;
        return (((int) (j ^ (j >>> 32))) * 31) + this.count;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VariantsEditEvent(variantId=");
        sb.append(this.variantId);
        sb.append(", count=");
        sb.append(this.count);
        sb.append(")");
        return sb.toString();
    }

    public CartEvent$VariantsEditEvent(long j, int i) {
        this.variantId = j;
        this.count = i;
    }

    public final int getCount() {
        return this.count;
    }

    public final long getVariantId() {
        return this.variantId;
    }
}
