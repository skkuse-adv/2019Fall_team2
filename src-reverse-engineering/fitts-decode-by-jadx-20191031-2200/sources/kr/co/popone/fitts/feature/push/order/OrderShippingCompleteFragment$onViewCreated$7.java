package kr.co.popone.fitts.feature.push.order;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import kotlin.Unit;

final class OrderShippingCompleteFragment$onViewCreated$7<T> implements Observer<Unit> {
    final /* synthetic */ OrderShippingCompleteFragment this$0;

    OrderShippingCompleteFragment$onViewCreated$7(OrderShippingCompleteFragment orderShippingCompleteFragment) {
        this.this$0 = orderShippingCompleteFragment;
    }

    public final void onChanged(Unit unit) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
