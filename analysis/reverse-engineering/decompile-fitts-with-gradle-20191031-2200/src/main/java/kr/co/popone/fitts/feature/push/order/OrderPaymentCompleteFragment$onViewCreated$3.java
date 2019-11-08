package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;

final class OrderPaymentCompleteFragment$onViewCreated$3 implements OnClickListener {
    final /* synthetic */ OrderPaymentCompleteFragment this$0;

    OrderPaymentCompleteFragment$onViewCreated$3(OrderPaymentCompleteFragment orderPaymentCompleteFragment) {
        this.this$0 = orderPaymentCompleteFragment;
    }

    public final void onClick(View view) {
        this.this$0.getViewModel().handleScheme(this.this$0.getActivity(), "fitts://collection/303?type=mixed");
    }
}
