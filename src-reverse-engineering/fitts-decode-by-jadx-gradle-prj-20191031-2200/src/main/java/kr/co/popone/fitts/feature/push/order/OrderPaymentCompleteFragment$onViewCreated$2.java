package kr.co.popone.fitts.feature.push.order;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderPaymentCompleteFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderPaymentCompleteFragment this$0;

    OrderPaymentCompleteFragment$onViewCreated$2(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
        this.this$0 = orderPaymentCompleteFragment;
    }

    public final void onClick(View view) {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            OrderDetailActivity.Companion.start(this.this$0.getContext(), arguments.getLong(OrderPaymentCompleteFragment.KEY_ORDER_ID));
        }
    }
}
