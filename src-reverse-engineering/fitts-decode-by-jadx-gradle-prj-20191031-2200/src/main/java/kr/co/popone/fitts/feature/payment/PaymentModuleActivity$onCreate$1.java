package kr.co.popone.fitts.feature.payment;

import android.view.View;
import android.view.View.OnClickListener;

final class PaymentModuleActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ PaymentModuleActivity this$0;

    PaymentModuleActivity$onCreate$1(PaymentModuleActivity paymentModuleActivity) {
        this.this$0 = paymentModuleActivity;
    }

    public final void onClick(View view) {
        this.this$0.showPaymentCancelDialog();
    }
}
