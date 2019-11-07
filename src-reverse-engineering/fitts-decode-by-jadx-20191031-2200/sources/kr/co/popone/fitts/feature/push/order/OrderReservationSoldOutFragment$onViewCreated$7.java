package kr.co.popone.fitts.feature.push.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.base.extension.FragmentExtensionKt;

final class OrderReservationSoldOutFragment$onViewCreated$7<T> implements Observer<Throwable> {
    final /* synthetic */ OrderReservationSoldOutFragment this$0;

    OrderReservationSoldOutFragment$onViewCreated$7(OrderReservationSoldOutFragment orderReservationSoldOutFragment) {
        this.this$0 = orderReservationSoldOutFragment;
    }

    public final void onChanged(Throwable th) {
        FragmentExtensionKt.handleError(this.this$0, th);
    }
}
