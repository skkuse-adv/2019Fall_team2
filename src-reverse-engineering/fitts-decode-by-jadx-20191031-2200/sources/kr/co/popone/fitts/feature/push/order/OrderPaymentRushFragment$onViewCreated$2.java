package kr.co.popone.fitts.feature.push.order;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderPaymentRushFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderPaymentRushFragment this$0;

    OrderPaymentRushFragment$onViewCreated$2(OrderPaymentRushFragment orderPaymentRushFragment) {
        this.this$0 = orderPaymentRushFragment;
    }

    public final void onClick(View view) {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            OrderDetailActivity.Companion.start(this.this$0.getContext(), arguments.getLong(OrderPaymentRushFragment.KEY_ORDER_ID));
        }
    }
}
