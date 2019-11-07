package kr.co.popone.fitts.model.order;

import org.jetbrains.annotations.NotNull;

public enum OrderState {
    WAITING("입금대기"),
    DEPOSITED("결제완료"),
    EXPIRED(r2),
    PREPARING("배송준비중"),
    PROCEEDING("배송중"),
    PROCEEDED("배송완료"),
    DONE("구매확정"),
    CANCEL(r2),
    REFUNDING("반품신청"),
    REFUNDED("환불완료"),
    EXCHANGING("교환신청"),
    EXCHANGED("교환완료");
    
    @NotNull
    private final String state;

    private OrderState(String str) {
        this.state = str;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }
}
