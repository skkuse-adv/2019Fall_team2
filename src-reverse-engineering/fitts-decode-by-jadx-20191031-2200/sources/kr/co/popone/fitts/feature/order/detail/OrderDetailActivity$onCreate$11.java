package kr.co.popone.fitts.feature.order.detail;

import android.view.View;
import android.view.View.OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kr.co.popone.fitts.ui.DialogExtensions;
import org.jetbrains.anko.DimensionsKt;

final class OrderDetailActivity$onCreate$11 implements OnClickListener {
    final /* synthetic */ OrderDetailActivity this$0;

    OrderDetailActivity$onCreate$11(OrderDetailActivity orderDetailActivity) {
        this.this$0 = orderDetailActivity;
    }

    public final void onClick(View view) {
        DialogExtensions.showConfirmDialog$default(DialogExtensions.INSTANCE, this.this$0, "정말 취소하시겠어요?", "확인 시 바로 주문이 취소됩니다.", new Function0<Unit>(this) {
            final /* synthetic */ OrderDetailActivity$onCreate$11 this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.this$0.getViewModel().cancelOrder();
            }
        }, null, null, null, 0, DimensionsKt.HDPI, null);
    }
}
