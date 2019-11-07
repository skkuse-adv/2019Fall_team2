package kr.co.popone.fitts.model.domain.push;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum PushRendingState {
    RESERVATION_COMPLETE("booking", null, 2, null),
    RESERVATION_CANCEL_SOLD_OUT(r3, r2),
    RESERVATION_CANCEL_MISPRICE(r3, r4),
    PAYMENT_PRESS("paymentPress", null, 2, null),
    PAYMENT_COMPLETE("paymentDone", null, 2, null),
    PAYMENT_CANCEL_SOLD_OUT(r3, r2),
    PAYMENT_CANCEL_MISPRICE(r3, r4),
    SHIPPING_DONE("shippingDone", null, 2, null),
    DONE("done", null, 2, null),
    ADMIN_CANCEL_ALL_SELLER_FAULT(r4, r2),
    ADMIN_CANCEL_ALL_CUSTOMER_FAULT(r4, r2),
    ADMIN_CANCEL_PARTIAL_SELLER_FAULT(r4, r2),
    ADMIN_CANCEL_PARTIAL_CUSTOMER_FAULT(r4, r2);
    
    @Nullable
    private final String subType;
    @NotNull
    private final String type;

    private PushRendingState(String str, String str2) {
        this.type = str;
        this.subType = str2;
    }

    @Nullable
    public final String getSubType() {
        return this.subType;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }
}
