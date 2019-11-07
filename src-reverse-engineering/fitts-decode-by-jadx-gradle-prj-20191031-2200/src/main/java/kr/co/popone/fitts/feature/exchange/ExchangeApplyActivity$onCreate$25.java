package kr.co.popone.fitts.feature.exchange;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class ExchangeApplyActivity$onCreate$25 extends Lambda implements Function0<Long> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$25(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
        super(0);
    }

    public final long invoke() {
        return this.this$0.getIntent().getLongExtra(ExchangeApplyActivity.KEY_ORDER_LINE_ITEM_VARIANT_ID, -1);
    }
}
