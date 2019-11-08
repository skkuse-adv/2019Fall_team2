package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class OrderReservationSoldOutFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ OrderReservationSoldOutFragment this$0;

    OrderReservationSoldOutFragment$onViewCreated$1(OrderReservationSoldOutFragment orderReservationSoldOutFragment) {
        this.this$0 = orderReservationSoldOutFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
