package kr.co.popone.fitts.viewmodel.exchange.detail;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.remote.exchange.ExchangeApplyResponse;

final class ExchangeDetailViewModel$getExchangeDetailInfo$3<T> implements Consumer<ExchangeApplyResponse> {
    final /* synthetic */ ExchangeDetailViewModel this$0;

    ExchangeDetailViewModel$getExchangeDetailInfo$3(ExchangeDetailViewModel exchangeDetailViewModel) {
        this.this$0 = exchangeDetailViewModel;
    }

    public final void accept(ExchangeApplyResponse exchangeApplyResponse) {
        this.this$0.getExchangeInfoLiveData().setValue(exchangeApplyResponse);
    }
}
