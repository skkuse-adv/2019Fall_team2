package kr.co.popone.fitts.feature.payment;

import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.event.OrderEvent$OrderCompleteEvent;

final class PaymentModuleActivity$onCreate$3<T> implements Consumer<Object> {
    final /* synthetic */ PaymentModuleActivity this$0;

    PaymentModuleActivity$onCreate$3(PaymentModuleActivity paymentModuleActivity) {
        this.this$0 = paymentModuleActivity;
    }

    public final void accept(Object obj) {
        if (obj instanceof OrderEvent$OrderCompleteEvent) {
            this.this$0.finish();
        }
    }
}
