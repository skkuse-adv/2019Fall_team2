package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class PaymentCancelMisPriceFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ PaymentCancelMisPriceFragment this$0;

    PaymentCancelMisPriceFragment$onViewCreated$1(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
        this.this$0 = paymentCancelMisPriceFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
