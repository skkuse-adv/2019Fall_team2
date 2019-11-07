package kr.co.popone.fitts.viewmodel.refund.apply;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.model.domain.exchange.ExchangeRefundVariant;

final class RefundViewModel$getPreRefundInfo$$inlined$run$lambda$1<T> implements Consumer<ExchangeRefundVariant> {
    final /* synthetic */ RefundViewModel this$0;

    RefundViewModel$getPreRefundInfo$$inlined$run$lambda$1(RefundViewModel refundViewModel) {
        this.this$0 = refundViewModel;
    }

    public final void accept(final ExchangeRefundVariant exchangeRefundVariant) {
        this.this$0.getPreRefundLiveData().setValue(exchangeRefundVariant);
        this.this$0.variantQuantity = new Function0<Integer>() {
            public final int invoke() {
                return exchangeRefundVariant.getQuantity();
            }
        };
    }
}
