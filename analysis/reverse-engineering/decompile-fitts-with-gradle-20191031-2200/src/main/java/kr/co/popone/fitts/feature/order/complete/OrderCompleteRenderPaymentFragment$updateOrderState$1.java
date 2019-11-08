package kr.co.popone.fitts.feature.order.complete;

import android.view.View;
import android.view.View.OnClickListener;

final class OrderCompleteRenderPaymentFragment$updateOrderState$1 implements OnClickListener {
    final /* synthetic */ String $schemeAlpha;
    final /* synthetic */ String $schemeBeta;
    final /* synthetic */ OrderCompleteRenderPaymentFragment this$0;

    OrderCompleteRenderPaymentFragment$updateOrderState$1(OrderCompleteRenderPaymentFragment orderCompleteRenderPaymentFragment, String str, String str2) {
        this.this$0 = orderCompleteRenderPaymentFragment;
        this.$schemeAlpha = str;
        this.$schemeBeta = str2;
    }

    public final void onClick(View view) {
        int hashCode = "production".hashCode();
        this.this$0.getViewModel().handleScheme(this.this$0.getActivity(), this.$schemeBeta);
    }
}
