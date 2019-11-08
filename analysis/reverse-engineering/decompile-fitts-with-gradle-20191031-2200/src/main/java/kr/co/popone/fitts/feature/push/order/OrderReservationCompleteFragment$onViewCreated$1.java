package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class OrderReservationCompleteFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ OrderReservationCompleteFragment this$0;

    OrderReservationCompleteFragment$onViewCreated$1(OrderReservationCompleteFragment orderReservationCompleteFragment) {
        this.this$0 = orderReservationCompleteFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
