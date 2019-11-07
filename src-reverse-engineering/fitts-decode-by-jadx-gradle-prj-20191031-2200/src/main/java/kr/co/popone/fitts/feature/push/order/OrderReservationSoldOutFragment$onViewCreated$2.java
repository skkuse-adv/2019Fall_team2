package kr.co.popone.fitts.feature.push.order;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderReservationSoldOutFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderReservationSoldOutFragment this$0;

    OrderReservationSoldOutFragment$onViewCreated$2(OrderReservationSoldOutFragment orderReservationSoldOutFragment) {
        this.this$0 = orderReservationSoldOutFragment;
    }

    public final void onClick(View view) {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            OrderDetailActivity.Companion.start(this.this$0.getContext(), arguments.getLong(OrderReservationSoldOutFragment.KEY_ORDER_ID));
        }
    }
}
