package kr.co.popone.fitts.viewmodel.exchange.detail;

import io.reactivex.functions.Consumer;

final class ExchangeDetailViewModel$cancelExchange$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ExchangeDetailViewModel this$0;

    ExchangeDetailViewModel$cancelExchange$2(ExchangeDetailViewModel exchangeDetailViewModel) {
        this.this$0 = exchangeDetailViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
