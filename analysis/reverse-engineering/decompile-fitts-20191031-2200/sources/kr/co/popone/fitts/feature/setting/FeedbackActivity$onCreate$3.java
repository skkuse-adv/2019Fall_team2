package kr.co.popone.fitts.feature.setting;

import android.widget.Button;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class FeedbackActivity$onCreate$3<T> implements Consumer<CharSequence> {
    final /* synthetic */ FeedbackActivity this$0;

    FeedbackActivity$onCreate$3(FeedbackActivity feedbackActivity) {
        this.this$0 = feedbackActivity;
    }

    public final void accept(CharSequence charSequence) {
        Button button = (Button) this.this$0._$_findCachedViewById(C0010R$id.sendButton);
        Intrinsics.checkExpressionValueIsNotNull(button, "sendButton");
        Intrinsics.checkExpressionValueIsNotNull(charSequence, "it");
        button.setEnabled(!StringsKt__StringsJVMKt.isBlank(charSequence));
    }
}
