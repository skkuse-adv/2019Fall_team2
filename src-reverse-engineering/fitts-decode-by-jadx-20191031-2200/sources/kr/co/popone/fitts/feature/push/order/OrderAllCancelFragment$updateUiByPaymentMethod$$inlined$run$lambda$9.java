package kr.co.popone.fitts.feature.push.order;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import kotlin.Unit;

final class OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$9<T> implements Observer<Unit> {
    final /* synthetic */ OrderAllCancelFragment this$0;

    OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$9(OrderAllCancelFragment orderAllCancelFragment) {
        this.this$0 = orderAllCancelFragment;
    }

    public final void onChanged(Unit unit) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
