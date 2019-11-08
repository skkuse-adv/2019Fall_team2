package kr.co.popone.fitts.feature.exchange;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApplyResponse;

final class ExchangeCompleteFragment$onViewCreated$3<T> implements Observer<ExchangeApplyResponse> {
    final /* synthetic */ ExchangeCompleteFragment this$0;

    ExchangeCompleteFragment$onViewCreated$3(ExchangeCompleteFragment exchangeCompleteFragment) {
        this.this$0 = exchangeCompleteFragment;
    }

    public final void onChanged(ExchangeApplyResponse exchangeApplyResponse) {
        ExchangeCompleteFragment exchangeCompleteFragment = this.this$0;
        if (exchangeApplyResponse == null) {
            Intrinsics.throwNpe();
        }
        exchangeCompleteFragment.updateExchangeDetailUi(exchangeApplyResponse);
    }
}
