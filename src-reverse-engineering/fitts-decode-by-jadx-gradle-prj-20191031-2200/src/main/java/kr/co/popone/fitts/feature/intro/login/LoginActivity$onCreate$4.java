package kr.co.popone.fitts.feature.intro.login;

import android.view.View;
import android.view.View.OnClickListener;
import kr.co.popone.fitts.C0001R$anim;

final class LoginActivity$onCreate$4 implements OnClickListener {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onCreate$4(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void onClick(View view) {
        this.this$0.finish();
        this.this$0.overridePendingTransition(C0001R$anim.fade_in, C0001R$anim.slide_down);
    }
}
