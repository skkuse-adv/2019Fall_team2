package kr.co.popone.fitts.feature.refund;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.custom.ExchangeReasonSelector;
import kr.co.popone.fitts.viewmodel.refund.apply.RefundViewModel;

final class RefundApplyActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ RefundApplyActivity this$0;

    RefundApplyActivity$onCreate$4(RefundApplyActivity refundApplyActivity) {
        this.this$0 = refundApplyActivity;
    }

    public final void onClick(View view) {
        RefundViewModel viewModel = this.this$0.getViewModel();
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductCount");
        int parseInt = Integer.parseInt(textView.getText().toString());
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountHolder);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editAccountHolder");
        String obj = editText.getText().toString();
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountNumber);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "editAccountNumber");
        String obj2 = editText2.getText().toString();
        EditText editText3 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editBankName);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "editBankName");
        String obj3 = editText3.getText().toString();
        String exchangeReason = ((ExchangeReasonSelector) this.this$0._$_findCachedViewById(C0010R$id.selectorReason)).getExchangeReason();
        EditText editText4 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editDetailReason);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "editDetailReason");
        viewModel.checkValidation(parseInt, obj, obj2, obj3, exchangeReason, editText4.getText().toString(), this.this$0.isRadioButtonChecked());
    }
}
