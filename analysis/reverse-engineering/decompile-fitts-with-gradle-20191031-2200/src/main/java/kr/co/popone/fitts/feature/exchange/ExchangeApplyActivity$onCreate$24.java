package kr.co.popone.fitts.feature.exchange;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;

final class ExchangeApplyActivity$onCreate$24<T> implements Observer<ExchangeRefundVariant> {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$24(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onChanged(ExchangeRefundVariant exchangeRefundVariant) {
        ExchangeApplyActivity exchangeApplyActivity = this.this$0;
        if (exchangeRefundVariant == null) {
            Intrinsics.throwNpe();
        }
        exchangeApplyActivity.updatePreExchangeUi(exchangeRefundVariant);
    }
}
