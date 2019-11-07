package kr.co.popone.fitts.feature.refund;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class RefundCompleteFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ RefundCompleteFragment this$0;

    RefundCompleteFragment$onViewCreated$1(RefundCompleteFragment refundCompleteFragment) {
        this.this$0 = refundCompleteFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
