package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class PaymentCancelSoldOutFragment$onViewCreated$4<T> implements Observer<Throwable> {
    final /* synthetic */ PaymentCancelSoldOutFragment this$0;

    PaymentCancelSoldOutFragment$onViewCreated$4(PaymentCancelSoldOutFragment paymentCancelSoldOutFragment) {
        this.this$0 = paymentCancelSoldOutFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
