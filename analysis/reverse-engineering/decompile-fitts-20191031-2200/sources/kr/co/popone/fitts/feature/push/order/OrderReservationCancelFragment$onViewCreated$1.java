package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class OrderReservationCancelFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ OrderReservationCancelFragment this$0;

    OrderReservationCancelFragment$onViewCreated$1(OrderReservationCancelFragment orderReservationCancelFragment) {
        this.this$0 = orderReservationCancelFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
