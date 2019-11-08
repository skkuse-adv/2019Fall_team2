package kr.co.popone.fitts.feature.order.complete;

import android.view.View;
import android.view.View.OnClickListener;

final class OrderCompleteRenderReservationFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ OrderCompleteRenderReservationFragment this$0;

    OrderCompleteRenderReservationFragment$onViewCreated$2(OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment) {
        this.this$0 = orderCompleteRenderReservationFragment;
    }

    public final void onClick(View view) {
        this.this$0.getViewModel().handleScheme(this.this$0.getActivity(), "fitts://storeHome?tabName=home");
    }
}
