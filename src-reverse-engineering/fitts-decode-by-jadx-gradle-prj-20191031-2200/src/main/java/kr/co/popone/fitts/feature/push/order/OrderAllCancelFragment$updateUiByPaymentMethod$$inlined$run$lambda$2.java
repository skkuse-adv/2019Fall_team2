package kr.co.popone.fitts.feature.push.order;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0006R$color;
import kr.co.popone.fitts.C0010R$id;

final class OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$2<T> implements Consumer<Boolean> {
    final /* synthetic */ OrderAllCancelFragment this$0;

    OrderAllCancelFragment$updateUiByPaymentMethod$$inlined$run$lambda$2(OrderAllCancelFragment orderAllCancelFragment) {
        this.this$0 = orderAllCancelFragment;
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
