package kr.co.popone.fitts.feature.refund;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import kotlin.Unit;

final class RefundApplyCompleteFragment$onViewCreated$6<T> implements Observer<Unit> {
    final /* synthetic */ RefundApplyCompleteFragment this$0;

    RefundApplyCompleteFragment$onViewCreated$6(RefundApplyCompleteFragment refundApplyCompleteFragment) {
        this.this$0 = refundApplyCompleteFragment;
    }

    public final void onChanged(Unit unit) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
