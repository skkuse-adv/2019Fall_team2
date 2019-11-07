package kr.co.popone.fitts.feature.order.complete;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.feature.order.detail.OrderDetailActivity;

final class OrderCompleteRenderReservationFragment$onViewCreated$3 implements OnClickListener {
    final /* synthetic */ OrderCompleteRenderReservationFragment this$0;

    OrderCompleteRenderReservationFragment$onViewCreated$3(OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment) {
        this.this$0 = orderCompleteRenderReservationFragment;
    }

    public final void onClick(View view) {
        OrderDetailActivity.Companion.start(this.this$0.getContext(), ((Number) this.this$0.getViewModel().getGetOrderId().invoke()).longValue());
    }
}
