package kr.co.popone.fitts.viewmodel.exchange.apply;

import io.reactivex.functions.Consumer;

final class ExchangeViewModel$getPreExchangeInfo$$inlined$run$lambda$2<T> implements Consumer<Throwable> {
    final /* synthetic */ ExchangeViewModel this$0;

    ExchangeViewModel$getPreExchangeInfo$$inlined$run$lambda$2(ExchangeViewModel exchangeViewModel) {
        this.this$0 = exchangeViewModel;
    }

    public final void accept(Throwable th) {
        this.this$0.getErrorLiveData().setValue(th);
    }
}
