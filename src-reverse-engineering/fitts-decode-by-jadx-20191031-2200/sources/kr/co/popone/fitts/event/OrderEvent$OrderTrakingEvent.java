package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderEvent$OrderTrakingEvent {
    private final long variantId;

    @NotNull
    public static /* synthetic */ OrderEvent$OrderTrakingEvent copy$default(OrderEvent$OrderTrakingEvent orderEvent$OrderTrakingEvent, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = orderEvent$OrderTrakingEvent.variantId;
        }
        return orderEvent$OrderTrakingEvent.copy(j);
    }

    public final long component1() {
        return this.variantId;
    }

    @NotNull
    public final OrderEvent$OrderTrakingEvent copy(long j) {
        return new OrderEvent$OrderTrakingEvent(j);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderEvent$OrderTrakingEvent) {
                if (this.variantId == ((OrderEvent$OrderTrakingEvent) obj).variantId) {
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
        sb.append("OrderTrakingEvent(variantId=");
        sb.append(this.variantId);
        sb.append(")");
        return sb.toString();
    }

    public OrderEvent$OrderTrakingEvent(long j) {
        this.variantId = j;
    }

    public final long getVariantId() {
        return this.variantId;
    }
}
