package kr.co.popone.fitts.feature.order.complete;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.ContextExtensionKt;
import kr.co.popone.fitts.ui.ToastExtensionKt;

final class OrderCompleteRenderReservationFragment$onViewCreated$1 implements OnClickListener {
    final /* synthetic */ OrderCompleteRenderReservationFragment this$0;

    OrderCompleteRenderReservationFragment$onViewCreated$1(OrderCompleteRenderReservationFragment orderCompleteRenderReservationFragment) {
        this.this$0 = orderCompleteRenderReservationFragment;
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
