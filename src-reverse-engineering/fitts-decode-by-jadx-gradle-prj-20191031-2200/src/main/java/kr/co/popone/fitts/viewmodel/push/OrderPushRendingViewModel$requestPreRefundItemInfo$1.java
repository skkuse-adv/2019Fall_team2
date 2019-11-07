package kr.co.popone.fitts.viewmodel.push;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;

final class OrderPushRendingViewModel$requestPreRefundItemInfo$1<T> implements Consumer<ExchangeRefundVariant> {
    final /* synthetic */ OrderPushRendingViewModel this$0;

    OrderPushRendingViewModel$requestPreRefundItemInfo$1(OrderPushRendingViewModel orderPushRendingViewModel) {
        this.this$0 = orderPushRendingViewModel;
    }

    public final void accept(ExchangeRefundVariant exchangeRefundVariant) {
        this.this$0.getExchangeRefundLiveData().setValue(exchangeRefundVariant);
    }
}
