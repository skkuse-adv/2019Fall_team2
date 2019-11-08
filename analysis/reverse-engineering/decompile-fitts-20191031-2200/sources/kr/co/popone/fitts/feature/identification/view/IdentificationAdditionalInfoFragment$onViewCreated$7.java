package kr.co.popone.fitts.feature.identification.view;

import android.widget.EditText;
import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.identification.model.IdentificationViewData;

final class IdentificationAdditionalInfoFragment$onViewCreated$7<T> implements Consumer<IdentificationViewData> {
    final /* synthetic */ IdentificationAdditionalInfoFragment this$0;

    IdentificationAdditionalInfoFragment$onViewCreated$7(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
        this.this$0 = identificationAdditionalInfoFragment;
    }

    public final void accept(IdentificationViewData identificationViewData) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textSsnFirst);
        if (textView != null) {
            textView.setText(identificationViewData.getSsnFirst());
        }
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editSsnSecond);
        if (editText != null) {
            editText.setText(identificationViewData.getSsnSecond());
        }
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editSsnSecond);
        if (editText2 != null) {
            editText2.setSelection(1);
        }
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textName);
        if (textView2 != null) {
            textView2.setText(identificationViewData.getName());
        }
        TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.textContact);
        if (textView3 != null) {
            textView3.setText(identificationViewData.getContact());
        }
    }
}
