package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class OrderPaymentCompleteFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ OrderPaymentCompleteFragment this$0;

    OrderPaymentCompleteFragment$onViewCreated$1(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
        this.this$0 = orderPaymentCompleteFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
