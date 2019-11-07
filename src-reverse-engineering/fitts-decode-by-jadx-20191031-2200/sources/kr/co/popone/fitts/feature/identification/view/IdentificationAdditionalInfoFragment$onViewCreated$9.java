package kr.co.popone.fitts.feature.identification.view;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.facebook.internal.ServerProtocol;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.base.extension.KeyboardExtensionKt;
import kr.co.popone.fitts.event.RxBus;
import kr.co.popone.fitts.feature.identification.IdentificationEvent;

final class IdentificationAdditionalInfoFragment$onViewCreated$9<T> implements Consumer<IdentificationEvent> {
    final /* synthetic */ IdentificationAdditionalInfoFragment this$0;

    IdentificationAdditionalInfoFragment$onViewCreated$9(IdentificationAdditionalInfoFragment identificationAdditionalInfoFragment) {
        this.this$0 = identificationAdditionalInfoFragment;
    }

    public final void accept(IdentificationEvent identificationEvent) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.editSsnSecond);
            Intrinsics.checkExpressionValueIsNotNull(editText, "editSsnSecond");
            KeyboardExtensionKt.hideKeyboard((Activity) activity, (View) editText);
        }
        RxBus rxBus = RxBus.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(identificationEvent, ServerProtocol.DIALOG_PARAM_STATE);
        rxBus.post(identificationEvent);
    }
}
