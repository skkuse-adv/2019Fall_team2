package kr.co.popone.fitts.feature.event;

import android.widget.Button;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class AppliableEventApplyActivity$onCreate$11<T> implements Consumer<Boolean> {
    final /* synthetic */ AppliableEventApplyActivity this$0;

    AppliableEventApplyActivity$onCreate$11(AppliableEventApplyActivity appliableEventApplyActivity) {
        this.this$0 = appliableEventApplyActivity;
    }

    public final void accept(Boolean bool) {
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.eventApplyConfirmButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "eventApplyConfirmButton");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        button.setEnabled(bool.booleanValue());
    }
}
