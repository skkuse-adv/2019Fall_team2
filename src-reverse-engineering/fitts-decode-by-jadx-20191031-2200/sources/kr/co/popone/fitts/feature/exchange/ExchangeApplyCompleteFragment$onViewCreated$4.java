package kr.co.popone.fitts.feature.exchange;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApplyResponse;

final class ExchangeApplyCompleteFragment$onViewCreated$4<T> implements Observer<ExchangeApplyResponse> {
    final /* synthetic */ ExchangeApplyCompleteFragment this$0;

    ExchangeApplyCompleteFragment$onViewCreated$4(ExchangeApplyCompleteFragment exchangeApplyCompleteFragment) {
        this.this$0 = exchangeApplyCompleteFragment;
    }

    public final void onChanged(ExchangeApplyResponse exchangeApplyResponse) {
        ExchangeApplyCompleteFragment exchangeApplyCompleteFragment = this.this$0;
        if (exchangeApplyResponse == null) {
            Intrinsics.throwNpe();
        }
        exchangeApplyCompleteFragment.updateExchangeDetailUi(exchangeApplyResponse);
    }
}
