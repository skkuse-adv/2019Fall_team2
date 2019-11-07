package kr.co.popone.fitts.feature.refund;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.model.remote.refund.RefundApplyResponse;

final class RefundCompleteActivity$onCreate$2<T> implements Observer<RefundApplyResponse> {
    final /* synthetic */ RefundCompleteActivity this$0;

    RefundCompleteActivity$onCreate$2(RefundCompleteActivity refundCompleteActivity) {
        this.this$0 = refundCompleteActivity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        if (r2 != null) goto L_0x000d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(kr.co.popone.fitts.model.remote.refund.RefundApplyResponse r2) {
        /*
            r1 = this;
            kr.co.popone.fitts.feature.refund.RefundCompleteActivity r0 = r1.this$0
            if (r2 == 0) goto L_0x000b
            java.lang.String r2 = r2.getState()
            if (r2 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            java.lang.String r2 = ""
        L_0x000d:
            r0.transactionFragment(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kr.co.popone.fitts.feature.refund.RefundCompleteActivity$onCreate$2.onChanged(kr.co.popone.fitts.model.remote.refund.RefundApplyResponse):void");
    }
}
