package kr.co.popone.fitts.feature.push.order;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import kotlin.Unit;

final class OrderCompleteFragment$onViewCreated$7<T> implements Observer<Unit> {
    final /* synthetic */ OrderCompleteFragment this$0;

    OrderCompleteFragment$onViewCreated$7(OrderCompleteFragment orderCompleteFragment) {
        this.this$0 = orderCompleteFragment;
    }

    public final void onChanged(Unit unit) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
