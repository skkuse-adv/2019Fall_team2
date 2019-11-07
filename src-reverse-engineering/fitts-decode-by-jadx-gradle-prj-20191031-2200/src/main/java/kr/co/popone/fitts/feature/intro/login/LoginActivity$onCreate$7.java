package kr.co.popone.fitts.feature.intro.login;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class LoginActivity$onCreate$7 implements OnClickListener {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onCreate$7(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void onClick(View view) {
        LoginActivity loginActivity = this.this$0;
        loginActivity.startActivity(new Intent(loginActivity, ResetPasswordActivity.class));
    }
}
