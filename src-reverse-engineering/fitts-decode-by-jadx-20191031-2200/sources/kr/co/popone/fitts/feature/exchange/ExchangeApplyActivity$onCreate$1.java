package kr.co.popone.fitts.feature.exchange;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ExchangeApplyActivity$onCreate$1 extends Lambda implements Function0<String> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$1(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
        super(0);
    }

    public final String invoke() {
        return this.this$0.getIntent().getStringExtra(ExchangeApplyActivity.KEY_PAYMENT_METHOD);
    }
}
