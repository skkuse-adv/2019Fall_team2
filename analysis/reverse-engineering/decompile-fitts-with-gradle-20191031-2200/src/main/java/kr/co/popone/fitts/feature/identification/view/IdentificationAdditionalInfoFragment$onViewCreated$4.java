package kr.co.popone.fitts.feature.identification.view;

import android.text.Editable;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import io.reactivex.functions.Consumer;

final class IdentificationAdditionalInfoFragment$onViewCreated$4<T> implements Consumer<TextViewAfterTextChangeEvent> {
    final /* synthetic */ IdentificationAdditionalInfoFragment this$0;

    IdentificationAdditionalInfoFragment$onViewCreated$4(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
        this.this$0 = identificationAdditionalInfoFragment;
    }

    public final void accept(TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
        Editable editable = textViewAfterTextChangeEvent.editable();
        if (editable != null && editable.length() < 1) {
            this.this$0.getViewModel().ssnStartString(new IdentificationAdditionalInfoFragment$onViewCreated$4$$special$$inlined$let$lambda$1(this, textViewAfterTextChangeEvent));
        }
    }
}
