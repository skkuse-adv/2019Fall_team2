package kr.co.popone.fitts.model.domain.exchange;

import kr.co.popone.fitts.C0010R$id;

public enum ExchangeInvalidViewState {
    EXCHANGE_OPTION(C0010R$id.textExchangeOption),
    BANK_ACCOUNT(C0010R$id.textBankInfo),
    EXCHANGE_REASON(C0010R$id.textExchangeReason),
    EXCHANGE_DETAIL_REASON(C0010R$id.textExchangeDetailReason),
    AGREEMENT_FAILED(C0010R$id.textAgreeWithTerms);
    
    private final int viewId;

    private ExchangeInvalidViewState(int i) {
        this.viewId = i;
    }

    public final int getViewId() {
        return this.viewId;
    }
}
