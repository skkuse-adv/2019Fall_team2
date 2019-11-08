package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderEvent$OrderRefundDetailEvent {
    private final long refundId;
    private final long variantId;

    @NotNull
    public static /* synthetic */ OrderEvent$OrderRefundDetailEvent copy$default(OrderEvent$OrderRefundDetailEvent orderEvent$OrderRefundDetailEvent, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = orderEvent$OrderRefundDetailEvent.variantId;
        }
        if ((i & 2) != 0) {
            j2 = orderEvent$OrderRefundDetailEvent.refundId;
        }
        return orderEvent$OrderRefundDetailEvent.copy(j, j2);
    }

    public final long component1() {
        return this.variantId;
    }

    public final long component2() {
        return this.refundId;
    }

    @NotNull
    public final OrderEvent$OrderRefundDetailEvent copy(long j, long j2) {
        return new OrderEvent$OrderRefundDetailEvent(j, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderEvent$OrderRefundDetailEvent) {
                OrderEvent$OrderRefundDetailEvent orderEvent$OrderRefundDetailEvent = (OrderEvent$OrderRefundDetailEvent) obj;
                if (this.variantId == orderEvent$OrderRefundDetailEvent.variantId) {
                    if (this.refundId == orderEvent$OrderRefundDetailEvent.refundId) {
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
        int i = ((int) (j ^ (j >>> 32))) * 31;
        long j2 = this.refundId;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderRefundDetailEvent(variantId=");
        sb.append(this.variantId);
        sb.append(", refundId=");
        sb.append(this.refundId);
        sb.append(")");
        return sb.toString();
    }

    public OrderEvent$OrderRefundDetailEvent(long j, long j2) {
        this.variantId = j;
        this.refundId = j2;
    }

    public final long getRefundId() {
        return this.refundId;
    }

    public final long getVariantId() {
        return this.variantId;
    }
}
