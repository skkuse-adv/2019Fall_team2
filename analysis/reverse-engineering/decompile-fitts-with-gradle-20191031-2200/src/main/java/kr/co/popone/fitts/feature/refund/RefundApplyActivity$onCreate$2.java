package kr.co.popone.fitts.feature.refund;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel;

final class RefundApplyActivity$onCreate$2 implements OnClickListener {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$2(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onClick(View view) {
        RefundViewModel viewModel = this.this$0.getViewModel();
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductCount");
        viewModel.canPlusCount(Integer.parseInt(textView.getText().toString()));
    }
}
