package kr.co.popone.fitts.feature.push.order;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderReservationCompleteFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderReservationCompleteFragment this$0;

    OrderReservationCompleteFragment$onViewCreated$2(OrderReservationCompleteFragment orderReservationCompleteFragment) {
        this.this$0 = orderReservationCompleteFragment;
    }

    public final void onClick(View view) {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            OrderDetailActivity.Companion.start(this.this$0.getContext(), arguments.getLong(OrderReservationCompleteFragment.KEY_ORDER_ID));
        }
    }
}
