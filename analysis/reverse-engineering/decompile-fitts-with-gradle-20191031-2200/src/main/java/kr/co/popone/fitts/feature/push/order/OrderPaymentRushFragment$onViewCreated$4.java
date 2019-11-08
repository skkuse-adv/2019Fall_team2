package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;

final class OrderPaymentRushFragment$onViewCreated$4 implements OnClickListener {
    final /* synthetic */ OrderPaymentRushFragment this$0;

    OrderPaymentRushFragment$onViewCreated$4(OrderPaymentRushFragment orderPaymentRushFragment) {
        this.this$0 = orderPaymentRushFragment;
    }

    public final void onClick(View view) {
        int hashCode = "production".hashCode();
        this.this$0.getViewModel().handleScheme(this.this$0.getActivity(), this.this$0.SCHEME_BETA);
    }
}
