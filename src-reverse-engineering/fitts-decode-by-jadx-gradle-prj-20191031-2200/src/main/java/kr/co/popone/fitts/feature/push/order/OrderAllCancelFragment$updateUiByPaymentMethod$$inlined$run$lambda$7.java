package kr.co.popone.fitts.feature.push.order;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import kotlin.Unit;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$7<T> implements Observer<Unit> {
    final /* synthetic */ OrderAllCancelFragment this$0;

    OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$7(OrderAllCancelFragment orderAllCancelFragment) {
        this.this$0 = orderAllCancelFragment;
    }

    public final void onChanged(Unit unit) {
        Context context = this.this$0.getContext();
        if (context != null) {
            ((TextView) this.this$0._$_findCachedViewById(C0010R$id.textRefundDesc)).setTextColor(ContextCompat.getColor(context, C0006R$color.neon_red));
        }
    }
}
