package kr.co.popone.fitts.feature.event;

import android.widget.Button;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class AppliableEventWinnerInputActivity$onCreate$6<T> implements Consumer<Boolean> {
    final /* synthetic */ AppliableEventWinnerInputActivity this$0;

    AppliableEventWinnerInputActivity$onCreate$6(AppliableEventWinnerInputActivity appliableEventWinnerInputActivity) {
        this.this$0 = appliableEventWinnerInputActivity;
    }

    public final void accept(Boolean bool) {
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.termsAgreeButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "termsAgreeButton");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        button.setEnabled(bool.booleanValue());
    }
}
