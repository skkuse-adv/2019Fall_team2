package kr.co.popone.fitts.feature.order;

import androidx.lifecycle.Observer;
import kr.co.popone.fitts.feature.payment.PaymentModuleActivity;
import kr.co.popone.fitts.model.domain.payment.PaymentModuleData;

final class OrderActivity$onCreate$23<T> implements Observer<PaymentModuleData> {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$23(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final void onChanged(PaymentModuleData paymentModuleData) {
        PaymentModuleActivity.Companion.start(this.this$0, paymentModuleData);
    }
}
