package kr.co.popone.fitts.feature.push.order;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderPartCancelFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderPartCancelFragment this$0;

    OrderPartCancelFragment$onViewCreated$2(OrderPartCancelFragment orderPartCancelFragment) {
        this.this$0 = orderPartCancelFragment;
    }

    public final void onClick(View view) {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            OrderDetailActivity.Companion.start(this.this$0.getContext(), arguments.getLong(OrderPartCancelFragment.KEY_ORDER_ID));
        }
    }
}
