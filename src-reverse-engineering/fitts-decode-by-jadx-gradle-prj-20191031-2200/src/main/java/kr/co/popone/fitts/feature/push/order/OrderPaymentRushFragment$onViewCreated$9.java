package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class OrderPaymentRushFragment$onViewCreated$9<T> implements Observer<Throwable> {
    final /* synthetic */ OrderPaymentRushFragment this$0;

    OrderPaymentRushFragment$onViewCreated$9(OrderPaymentRushFragment orderPaymentRushFragment) {
        this.this$0 = orderPaymentRushFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
