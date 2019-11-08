package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class OrderShippingCompleteFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ OrderShippingCompleteFragment this$0;

    OrderShippingCompleteFragment$onViewCreated$1(OrderShippingCompleteFragment orderShippingCompleteFragment) {
        this.this$0 = orderShippingCompleteFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
