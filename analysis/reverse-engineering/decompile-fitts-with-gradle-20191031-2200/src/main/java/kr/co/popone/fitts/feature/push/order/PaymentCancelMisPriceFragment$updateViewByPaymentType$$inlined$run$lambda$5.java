package kr.co.popone.fitts.feature.push.order;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import kotlin.Unit;

final class PaymentCancelMisPriceFragment$updateViewByPaymentType$$inlined$run$lambda$5<T> implements Observer<Unit> {
    final /* synthetic */ PaymentCancelMisPriceFragment this$0;

    PaymentCancelMisPriceFragment$updateViewByPaymentType$$inlined$run$lambda$5(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
        this.this$0 = paymentCancelMisPriceFragment;
    }

    public final void onChanged(Unit unit) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
