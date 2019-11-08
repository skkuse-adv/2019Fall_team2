package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderEvent$OrderRefundEvent {
    private final long variantId;

    @NotNull
    public static /* synthetic */ OrderEvent$OrderRefundEvent copy$default(OrderEvent$OrderRefundEvent orderEvent$OrderRefundEvent, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = orderEvent$OrderRefundEvent.variantId;
        }
        return orderEvent$OrderRefundEvent.copy(j);
    }

    public final long component1() {
        return this.variantId;
    }

    @NotNull
    public final OrderEvent$OrderRefundEvent copy(long j) {
        return new OrderEvent$OrderRefundEvent(j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderEvent$OrderRefundEvent) {
                if (this.variantId == ((OrderEvent$OrderRefundEvent) obj).variantId) {
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
        sb.append("OrderRefundEvent(variantId=");
        sb.append(this.variantId);
        sb.append(")");
        return sb.toString();
    }

    public OrderEvent$OrderRefundEvent(long j) {
        this.variantId = j;
    }

    public final long getVariantId() {
        return this.variantId;
    }
}
