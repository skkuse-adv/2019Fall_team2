package kr.co.popone.fitts.feature.order.detail;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class OrderDetailActivity$onCreate$10 implements OnClickListener {
    final /* synthetic */ OrderDetailActivity this$0;

    OrderDetailActivity$onCreate$10(OrderDetailActivity orderDetailActivity) {
        this.this$0 = orderDetailActivity;
    }

    public final void onClick(View view) {
        ActivityExtensionKt.finishWithAnimation(this.this$0, ActivityAnimationType.SLIDE_LTOR);
    }
}
