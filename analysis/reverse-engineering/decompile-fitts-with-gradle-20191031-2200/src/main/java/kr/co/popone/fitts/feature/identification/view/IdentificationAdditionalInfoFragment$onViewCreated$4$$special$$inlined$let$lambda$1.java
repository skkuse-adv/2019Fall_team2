package kr.co.popone.fitts.feature.identification.view;

import android.widget.EditText;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.annotations.NotNull;

final class IdentificationAdditionalInfoFragment$onViewCreated$4$$special$$inlined$let$lambda$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ TextViewAfterTextChangeEvent $it$inlined;
    final /* synthetic */ IdentificationAdditionalInfoFragment$onViewCreated$4 this$0;

    IdentificationAdditionalInfoFragment$onViewCreated$4$$special$$inlined$let$lambda$1(IdentificationAdditionalInfoFragment$onViewCreated$4 identificationAdditionalInfoFragment$onViewCreated$4, TextViewAfterTextChangeEvent textViewAfterTextChangeEvent) {
        this.this$0 = identificationAdditionalInfoFragment$onViewCreated$4;
        this.$it$inlined = textViewAfterTextChangeEvent;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "first");
        this.$it$inlined.view().setText(str);
        ((EditText) this.this$0.this$0._$_findCachedViewById(C0010R$id.editSsnSecond)).setSelection(1);
    }
}
