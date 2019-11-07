package kr.co.popone.fitts.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class OrderEvent$OrderExchangeDetailEvent {
    private final long exchangeId;
    private final long variantId;

    @NotNull
    public static /* synthetic */ OrderEvent$OrderExchangeDetailEvent copy$default(OrderEvent$OrderExchangeDetailEvent orderEvent$OrderExchangeDetailEvent, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = orderEvent$OrderExchangeDetailEvent.variantId;
        }
        if ((i & 2) != 0) {
            j2 = orderEvent$OrderExchangeDetailEvent.exchangeId;
        }
        return orderEvent$OrderExchangeDetailEvent.copy(j, j2);
    }

    public final long component1() {
        return this.variantId;
    }

    public final long component2() {
        return this.exchangeId;
    }

    @NotNull
    public final OrderEvent$OrderExchangeDetailEvent copy(long j, long j2) {
        return new OrderEvent$OrderExchangeDetailEvent(j, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof OrderEvent$OrderExchangeDetailEvent) {
                OrderEvent$OrderExchangeDetailEvent orderEvent$OrderExchangeDetailEvent = (OrderEvent$OrderExchangeDetailEvent) obj;
                if (this.variantId == orderEvent$OrderExchangeDetailEvent.variantId) {
                    if (this.exchangeId == orderEvent$OrderExchangeDetailEvent.exchangeId) {
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
        long j2 = this.exchangeId;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderExchangeDetailEvent(variantId=");
        sb.append(this.variantId);
        sb.append(", exchangeId=");
        sb.append(this.exchangeId);
        sb.append(")");
        return sb.toString();
    }

    public OrderEvent$OrderExchangeDetailEvent(long j, long j2) {
        this.variantId = j;
        this.exchangeId = j2;
    }

    public final long getExchangeId() {
        return this.exchangeId;
    }

    public final long getVariantId() {
        return this.variantId;
    }
}
