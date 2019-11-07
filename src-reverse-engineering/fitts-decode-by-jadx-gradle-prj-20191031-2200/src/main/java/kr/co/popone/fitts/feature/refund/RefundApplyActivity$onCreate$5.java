package kr.co.popone.fitts.feature.refund;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.base.extension.ActivityExtensionKt;
import kr.co.popone.fitts.utils.ActivityAnimationType;

final class RefundApplyActivity$onCreate$5 implements OnClickListener {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$5(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onClick(View view) {
        ActivityExtensionKt.finishWithAnimation(this.this$0, ActivityAnimationType.SLIDE_LTOR);
    }
}
