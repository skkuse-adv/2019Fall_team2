package kr.co.popone.fitts.feature.identification.view;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import io.reactivex.functions.Consumer;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.feature.identification.viewmodel.IdentificationAdditionalInfoViewModel.TextValdationColor;

final class IdentificationAdditionalInfoFragment$onViewCreated$8<T> implements Consumer<TextValdationColor> {
    final /* synthetic */ IdentificationAdditionalInfoFragment this$0;

    IdentificationAdditionalInfoFragment$onViewCreated$8(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
        this.this$0 = identificationAdditionalInfoFragment;
    }

    public final void accept(TextValdationColor textValdationColor) {
        Context context = this.this$0.getContext();
        if (context != null) {
            ((TextView) this.this$0._$_findCachedViewById(C0010R$id.textSSN)).setTextColor(ContextCompat.getColor(context, textValdationColor.getColor()));
        }
    }
}
