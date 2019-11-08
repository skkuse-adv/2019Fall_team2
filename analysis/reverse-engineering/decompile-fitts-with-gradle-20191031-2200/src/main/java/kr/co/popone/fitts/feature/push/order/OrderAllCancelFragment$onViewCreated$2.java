package kr.co.popone.fitts.feature.push.order;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderAllCancelFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderAllCancelFragment this$0;

    OrderAllCancelFragment$onViewCreated$2(OrderAllCancelFragment orderAllCancelFragment) {
        this.this$0 = orderAllCancelFragment;
    }

    public final void onClick(View view) {
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            OrderDetailActivity.Companion.start(this.this$0.getContext(), arguments.getLong(OrderAllCancelFragment.KEY_ORDER_ID));
        }
    }
}
