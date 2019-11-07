package kr.co.popone.fitts.viewmodel.exchange.detail;

import io.reactivex.functions.Action;
import kotlin.Unit;

final class ExchangeDetailViewModel$cancelExchange$1 implements Action {
    final /* synthetic */ ExchangeDetailViewModel this$0;

    ExchangeDetailViewModel$cancelExchange$1(ExchangeDetailViewModel exchangeDetailViewModel) {
        this.this$0 = exchangeDetailViewModel;
    }

    public final void run() {
        this.this$0.getCancelCompleteLiveData().setValue(Unit.INSTANCE);
    }
}
