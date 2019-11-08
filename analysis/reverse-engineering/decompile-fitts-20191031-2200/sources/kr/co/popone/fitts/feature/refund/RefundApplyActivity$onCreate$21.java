package kr.co.popone.fitts.feature.refund;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;

final class RefundApplyActivity$onCreate$21<T> implements Observer<ExchangeRefundVariant> {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$21(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onChanged(ExchangeRefundVariant exchangeRefundVariant) {
        RefundApplyActivity refundApplyActivity = this.this$0;
        if (exchangeRefundVariant == null) {
            Intrinsics.throwNpe();
        }
        refundApplyActivity.updatePreExchangeUi(exchangeRefundVariant);
    }
}
