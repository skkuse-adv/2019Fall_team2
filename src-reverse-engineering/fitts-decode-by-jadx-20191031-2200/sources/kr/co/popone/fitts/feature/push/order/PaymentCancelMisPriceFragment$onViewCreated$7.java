package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class PaymentCancelMisPriceFragment$onViewCreated$7<T> implements Observer<Throwable> {
    final /* synthetic */ PaymentCancelMisPriceFragment this$0;

    PaymentCancelMisPriceFragment$onViewCreated$7(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
        this.this$0 = paymentCancelMisPriceFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
