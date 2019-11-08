package kr.co.popone.fitts.feature.push.order;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import kotlin.Unit;

final class OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$5<T> implements Observer<Unit> {
    final /* synthetic */ OrderPartCancelFragment this$0;

    OrderPartCancelFragment$updateViewByPaymentType$$inlined$run$lambda$5(OrderPartCancelFragment orderPartCancelFragment) {
        this.this$0 = orderPartCancelFragment;
    }

    public final void onChanged(Unit unit) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
