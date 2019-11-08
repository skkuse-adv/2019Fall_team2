package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class OrderPaymentCompleteFragment$onViewCreated$9<T> implements Observer<Throwable> {
    final /* synthetic */ OrderPaymentCompleteFragment this$0;

    OrderPaymentCompleteFragment$onViewCreated$9(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
        this.this$0 = orderPaymentCompleteFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
