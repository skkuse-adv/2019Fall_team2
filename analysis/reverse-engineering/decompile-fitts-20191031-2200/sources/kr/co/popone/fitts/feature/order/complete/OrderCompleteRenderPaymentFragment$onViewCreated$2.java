package kr.co.popone.fitts.feature.order.complete;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderCompleteRenderPaymentFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderCompleteRenderPaymentFragment this$0;

    OrderCompleteRenderPaymentFragment$onViewCreated$2(OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment) {
        this.this$0 = orderCompleteRenderPaymentFragment;
    }

    public final void onClick(View view) {
        OrderDetailActivity.Companion.start(this.this$0.getContext(), ((Number) this.this$0.getViewModel().getGetOrderId().invoke()).longValue());
    }
}
