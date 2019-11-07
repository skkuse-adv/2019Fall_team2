package kr.co.popone.fitts.feature.event;

import android.widget.Button;
import android.widget.EditText;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class AppliableEventWinnerInputActivity$onCreate$4<T> implements Consumer<Boolean> {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$onCreate$4(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public final void accept(Boolean bool) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingPersonEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "shippingPersonEditText");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        editText.setEnabled(bool.booleanValue());
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingContactEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "shippingContactEditText");
        editText2.setEnabled(bool.booleanValue());
        EditText editText3 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.address1EditText);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "address1EditText");
        editText3.setEnabled(bool.booleanValue());
        EditText editText4 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.address2EditText);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "address2EditText");
        editText4.setEnabled(bool.booleanValue());
        EditText editText5 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.shippingMemoEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText5, "shippingMemoEditText");
        editText5.setEnabled(bool.booleanValue());
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.searchAddressButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "searchAddressButton");
        button.setEnabled(bool.booleanValue());
        Button button2 = (Button) this.this$0._$_findCachedViewById(C0010R$id.termsAgreeButton);
        Intrinsics.checkExpressionValueIsNotNull(button2, "termsAgreeButton");
        button2.setEnabled(bool.booleanValue());
    }
}
