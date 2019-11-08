package kr.co.popone.fitts.model.domain.refund;

import kr.co.popone.fitts.C0010R$id;

public enum RefundInvalidViewState {
    BANK_ACCOUNT(C0010R$id.textBankInfo),
    EXCHANGE_REASON(C0010R$id.textRefundReason),
    EXCHANGE_DETAIL_REASON(C0010R$id.textRefundDetailReason),
    AGREEMENT_FAILED(C0010R$id.textAgreeWithTerms);
    
    private final int viewId;

    private RefundInvalidViewState(int i) {
        this.viewId = i;
    }

    public final int getViewId() {
        return this.viewId;
    }
}
