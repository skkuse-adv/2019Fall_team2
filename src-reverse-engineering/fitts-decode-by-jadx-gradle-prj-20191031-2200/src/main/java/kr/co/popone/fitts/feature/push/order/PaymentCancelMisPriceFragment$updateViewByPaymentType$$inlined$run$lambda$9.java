package kr.co.popone.fitts.feature.push.order;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class PaymentCancelMisPriceFragment$updateViewByPaymentType$$inlined$run$lambda$9<T> implements Consumer<Boolean> {
    final /* synthetic */ PaymentCancelMisPriceFragment this$0;

    PaymentCancelMisPriceFragment$updateViewByPaymentType$$inlined$run$lambda$9(PaymentCancelMisPriceFragment paymentCancelMisPriceFragment) {
        this.this$0 = paymentCancelMisPriceFragment;
    }

    public final void accept(Boolean bool) {
        int i;
        Context context = this.this$0.getContext();
        if (context != null) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textRefundDesc);
            Intrinsics.checkExpressionValueIsNotNull(bool, "isValid");
            if (bool.booleanValue()) {
                i = ContextCompat.getColor(context, C0006R$color.gray6);
            } else {
                i = ContextCompat.getColor(context, C0006R$color.neon_red);
            }
            textView.setTextColor(i);
        }
    }
}
