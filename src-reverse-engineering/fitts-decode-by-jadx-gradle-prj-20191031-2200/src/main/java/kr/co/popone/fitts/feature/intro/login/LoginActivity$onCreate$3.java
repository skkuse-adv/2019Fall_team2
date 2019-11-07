package kr.co.popone.fitts.feature.intro.login;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class LoginActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onCreate$3(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void onClick(View view) {
        LoginActivity loginActivity = this.this$0;
        EditText editText = (EditText) loginActivity._$_findCachedViewById(C0010R$id.email);
        Intrinsics.checkExpressionValueIsNotNull(editText, "email");
        String obj = editText.getText().toString();
        TextInputEditText textInputEditText = (TextInputEditText) this.this$0._$_findCachedViewById(C0010R$id.password);
        Intrinsics.checkExpressionValueIsNotNull(textInputEditText, "password");
        loginActivity.onLogin(obj, String.valueOf(textInputEditText.getText()));
    }
}
