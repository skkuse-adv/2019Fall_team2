package kr.co.popone.fitts.feature.push.order;

import android.view.View;
import android.view.View.OnClickListener;

final class OrderCompleteFragment$updateOrderState$1 implements OnClickListener {
    final /* synthetic */ String $schemeAlpha;
    final /* synthetic */ String $schemeBeta;
    final /* synthetic */ OrderCompleteFragment this$0;

    OrderCompleteFragment$updateOrderState$1(OrderCompleteFragment orderCompleteFragment, String str, String str2) {
        this.this$0 = orderCompleteFragment;
        this.$schemeAlpha = str;
        this.$schemeBeta = str2;
    }

    public final void onClick(View view) {
        int hashCode = "production".hashCode();
        this.this$0.getViewModel().handleScheme(this.this$0.getActivity(), this.$schemeBeta);
    }
}
