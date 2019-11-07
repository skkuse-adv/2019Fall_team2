package kr.co.popone.fitts.feature.push.order;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderCompleteFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderCompleteFragment this$0;

    OrderCompleteFragment$onViewCreated$2(OrderCompleteFragment orderCompleteFragment) {
        this.this$0 = orderCompleteFragment;
    }

    public final void onClick(View view) {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            OrderDetailActivity.Companion.start(this.this$0.getContext(), arguments.getLong(OrderCompleteFragment.KEY_ORDER_ID));
        }
    }
}
