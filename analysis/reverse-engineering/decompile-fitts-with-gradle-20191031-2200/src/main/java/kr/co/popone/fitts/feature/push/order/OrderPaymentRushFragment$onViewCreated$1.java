package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;

final class OrderPaymentRushFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ OrderPaymentRushFragment this$0;

    OrderPaymentRushFragment$onViewCreated$1(OrderPaymentRushFragment orderPaymentRushFragment) {
        this.this$0 = orderPaymentRushFragment;
    }

    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
