package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;

final class OrderReservationCompleteFragment$onViewCreated$4 implements OnClickListener {
    final /* synthetic */ OrderReservationCompleteFragment this$0;

    OrderReservationCompleteFragment$onViewCreated$4(OrderReservationCompleteFragment orderReservationCompleteFragment) {
        this.this$0 = orderReservationCompleteFragment;
    }

    public final void onClick(View view) {
        int hashCode = "production".hashCode();
        this.this$0.getViewModel().handleScheme(this.this$0.getActivity(), this.this$0.SCHEME_BETA);
    }
}
