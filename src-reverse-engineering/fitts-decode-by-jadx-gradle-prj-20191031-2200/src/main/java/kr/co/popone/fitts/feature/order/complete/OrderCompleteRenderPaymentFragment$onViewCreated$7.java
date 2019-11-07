package kr.co.popone.fitts.feature.order.complete;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class OrderCompleteRenderPaymentFragment$onViewCreated$7<T> implements Observer<Throwable> {
    final /* synthetic */ OrderCompleteRenderPaymentFragment this$0;

    OrderCompleteRenderPaymentFragment$onViewCreated$7(OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment) {
        this.this$0 = orderCompleteRenderPaymentFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
