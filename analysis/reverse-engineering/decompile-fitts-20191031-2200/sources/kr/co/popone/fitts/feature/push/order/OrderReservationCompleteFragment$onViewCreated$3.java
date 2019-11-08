package kr.co.popone.fitts.feature.push.order;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.ui.ToastExtensionKt;

final class OrderReservationCompleteFragment$onViewCreated$3 implements OnClickListener {
    final /* synthetic */ OrderReservationCompleteFragment this$0;

    OrderReservationCompleteFragment$onViewCreated$3(OrderReservationCompleteFragment orderReservationCompleteFragment) {
        this.this$0 = orderReservationCompleteFragment;
    }

    public final void onClick(View view) {
        Context context = this.this$0.getContext();
        if (context != null) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textAccountNumber);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textAccountNumber");
            ContextExtensionKt.textCopy(context, textView.getText().toString());
        }
        ToastExtensionKt.showToast((Fragment) this.this$0, "계좌번호가 복사되었습니다.");
    }
}
