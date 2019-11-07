package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class OrderReservationCancelFragment$onViewCreated$7<T> implements Observer<Throwable> {
    final /* synthetic */ OrderReservationCancelFragment this$0;

    OrderReservationCancelFragment$onViewCreated$7(OrderReservationCancelFragment orderReservationCancelFragment) {
        this.this$0 = orderReservationCancelFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
