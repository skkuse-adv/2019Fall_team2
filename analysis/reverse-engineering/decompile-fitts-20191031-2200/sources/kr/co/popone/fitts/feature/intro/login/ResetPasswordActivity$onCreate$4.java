package kr.co.popone.fitts.feature.intro.login;

import android.widget.EditText;
import android.widget.ProgressBar;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class ResetPasswordActivity$onCreate$4<T> implements Consumer<Boolean> {
    final /* synthetic */ ResetPasswordActivity this$0;

    ResetPasswordActivity$onCreate$4(ResetPasswordActivity resetPasswordActivity) {
        this.this$0 = resetPasswordActivity;
    }

    public final void accept(Boolean bool) {
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.userIDEditText);
        Intrinsics.checkExpressionValueIsNotNull(editText, "userIDEditText");
        editText.setEnabled(!bool.booleanValue());
        ProgressBar progressBar = (ProgressBar) this.this$0._$_findCachedViewById(C0010R$id.progressBar);
        Intrinsics.checkExpressionValueIsNotNull(progressBar, "progressBar");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        progressBar.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
