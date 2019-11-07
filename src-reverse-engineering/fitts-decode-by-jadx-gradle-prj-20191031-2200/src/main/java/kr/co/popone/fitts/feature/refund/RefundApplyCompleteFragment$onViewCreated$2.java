package kr.co.popone.fitts.feature.refund;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class RefundApplyCompleteFragment$onViewCreated$2 implements OnClickListener {
    final /* synthetic */ RefundApplyCompleteFragment this$0;

    RefundApplyCompleteFragment$onViewCreated$2(RefundApplyCompleteFragment refundApplyCompleteFragment) {
        this.this$0 = refundApplyCompleteFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
