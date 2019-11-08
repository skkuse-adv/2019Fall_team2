package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;

final class OrderPaymentCompleteFragment$updateOrderState$1 implements OnClickListener {
    final /* synthetic */ String $schemeAlpha;
    final /* synthetic */ String $schemeBeta;
    final /* synthetic */ OrderPaymentCompleteFragment this$0;

    OrderPaymentCompleteFragment$updateOrderState$1(OrderPaymentCompleteFragment orderPaymentCompleteFragment, String str, String str2) {
        this.this$0 = orderPaymentCompleteFragment;
        this.$schemeAlpha = str;
        this.$schemeBeta = str2;
    }

    public final void onClick(View view) {
        int hashCode = "production".hashCode();
        this.this$0.getViewModel().handleScheme(this.this$0.getActivity(), this.$schemeBeta);
    }
}
