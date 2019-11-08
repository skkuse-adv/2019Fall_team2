package kr.co.popone.fitts.feature.payment;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class PaymentModuleActivity$showPaymentCancelDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PaymentModuleActivity this$0;

    PaymentModuleActivity$showPaymentCancelDialog$1(PaymentModuleActivity paymentModuleActivity) {
        this.this$0 = paymentModuleActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.finish();
    }
}
