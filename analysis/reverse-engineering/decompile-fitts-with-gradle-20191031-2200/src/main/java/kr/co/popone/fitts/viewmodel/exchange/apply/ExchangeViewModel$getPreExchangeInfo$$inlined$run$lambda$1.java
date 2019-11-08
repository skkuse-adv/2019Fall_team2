package kr.co.popone.fitts.viewmodel.exchange.apply;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;

final class ExchangeViewModel$getPreExchangeInfo$$inlined$run$lambda$1<T> implements Consumer<ExchangeRefundVariant> {
    final /* synthetic */ ExchangeViewModel this$0;

    ExchangeViewModel$getPreExchangeInfo$$inlined$run$lambda$1(ExchangeViewModel exchangeViewModel) {
        this.this$0 = exchangeViewModel;
    }

    public final void accept(final ExchangeRefundVariant exchangeRefundVariant) {
        this.this$0.getPreExchangeLiveData().setValue(exchangeRefundVariant);
        this.this$0.variantQuantity = new Function0<Integer>() {
            public final int invoke() {
                return exchangeRefundVariant.getQuantity();
            }
        };
    }
}
