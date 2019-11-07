package kr.co.popone.fitts.feature.push.order;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderShippingCompleteFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderShippingCompleteFragment this$0;

    OrderShippingCompleteFragment$onViewCreated$2(OrderShippingCompleteFragment orderShippingCompleteFragment) {
        this.this$0 = orderShippingCompleteFragment;
    }

    public final void onClick(View view) {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            OrderDetailActivity.Companion.start(this.this$0.getContext(), arguments.getLong(OrderShippingCompleteFragment.KEY_ORDER_ID));
        }
    }
}
