package kr.co.popone.fitts.feature.exchange;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.ui.custom.ExchangeReasonSelector;
import kr.co.popone.fitts.viewmodel.exchange.apply.ExchangeViewModel;

final class ExchangeApplyActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ ExchangeApplyActivity this$0;

    ExchangeApplyActivity$onCreate$4(ExchangeApplyActivity exchangeApplyActivity) {
        this.this$0 = exchangeApplyActivity;
    }

    public final void onClick(View view) {
        ExchangeViewModel viewModel = this.this$0.getViewModel();
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textProductCount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textProductCount");
        int parseInt = Integer.parseInt(textView.getText().toString());
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editOption);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editOption");
        String obj = editText.getText().toString();
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountHolder);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "editAccountHolder");
        String obj2 = editText2.getText().toString();
        EditText editText3 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editAccountNumber);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "editAccountNumber");
        String obj3 = editText3.getText().toString();
        EditText editText4 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editBankName);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "editBankName");
        String obj4 = editText4.getText().toString();
        String exchangeReason = ((ExchangeReasonSelector) this.this$0._$_findCachedViewById(C0010R$id.selectorExchangeReason)).getExchangeReason();
        EditText editText5 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editDetailReason);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "editDetailReason");
        viewModel.checkValidation(parseInt, obj, obj2, obj3, obj4, exchangeReason, editText5.getText().toString(), this.this$0.isRadioButtonChecked());
    }
}
