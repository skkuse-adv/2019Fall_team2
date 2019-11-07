package kr.co.popone.fitts.feature.intro.login;

import android.widget.ImageButton;
import android.widget.TextView;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class ResetPasswordActivity$onCreate$2<T> implements Consumer<CharSequence> {
    final /* synthetic */ ResetPasswordActivity this$0;

    ResetPasswordActivity$onCreate$2(ResetPasswordActivity resetPasswordActivity) {
        this.this$0 = resetPasswordActivity;
    }

    public final void accept(CharSequence charSequence) {
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.errorMessageTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView, "errorMessageTextView");
        textView.setVisibility(4);
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.resetPasswordButton);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "resetPasswordButton");
        Intrinsics.checkExpressionValueIsNotNull(charSequence, "it");
        imageButton.setEnabled(!StringsKt__StringsJVMKt.isBlank(charSequence));
    }
}
