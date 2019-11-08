package kr.co.popone.fitts.feature.push.order;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderReservationCancelFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderReservationCancelFragment this$0;

    OrderReservationCancelFragment$onViewCreated$2(OrderReservationCancelFragment orderReservationCancelFragment) {
        this.this$0 = orderReservationCancelFragment;
    }

    public final void onClick(View view) {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            OrderDetailActivity.Companion.start(this.this$0.getContext(), arguments.getLong(OrderReservationCancelFragment.KEY_ORDER_ID));
        }
    }
}
