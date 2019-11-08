package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class PaymentCancelSoldOutFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ PaymentCancelSoldOutFragment this$0;

    PaymentCancelSoldOutFragment$onViewCreated$1(PaymentCancelSoldOutFragment paymentCancelSoldOutFragment) {
        this.this$0 = paymentCancelSoldOutFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
