package kr.co.popone.fitts.feature.order;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.viewmodel.order.OrderViewModel;

final class OrderActivity$onCreate$27 implements OnClickListener {
    final /* synthetic */ OrderActivity this$0;

    OrderActivity$onCreate$27(OrderActivity orderActivity) {
        this.this$0 = orderActivity;
    }

    public final void onClick(View view) {
        OrderViewModel viewModel = this.this$0.getViewModel();
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editUseName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "editUseName");
        String obj = editText.getText().toString();
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editUserContact);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "editUserContact");
        String obj2 = editText2.getText().toString();
        EditText editText3 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editUserEmail);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "editUserEmail");
        String obj3 = editText3.getText().toString();
        EditText editText4 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingPersonEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "shippingPersonEditText");
        String obj4 = editText4.getText().toString();
        EditText editText5 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingContactEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "shippingContactEditText");
        String obj5 = editText5.getText().toString();
        EditText editText6 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.address1EditText);
        Intrinsics.checkExpressionValueIsNotNull(editText6, "address1EditText");
        String obj6 = editText6.getText().toString();
        EditText editText7 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.address2EditText);
        Intrinsics.checkExpressionValueIsNotNull(editText7, "address2EditText");
        String obj7 = editText7.getText().toString();
        EditText editText8 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingMemoEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText8, "shippingMemoEditText");
        String obj8 = editText8.getText().toString();
        EditText editText9 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editPayedUser);
        Intrinsics.checkExpressionValueIsNotNull(editText9, "editPayedUser");
        viewModel.makeOrder(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, editText9.getText().toString(), this.this$0.getTaxDeductionType(), this.this$0.getTaxDeductionValue());
    }
}
