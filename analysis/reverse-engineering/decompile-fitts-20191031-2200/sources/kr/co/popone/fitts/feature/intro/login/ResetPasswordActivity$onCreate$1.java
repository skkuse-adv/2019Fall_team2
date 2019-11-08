package kr.co.popone.fitts.feature.intro.login;

import android.view.View;
import android.view.View.OnClickListener;
import com.orhanobut.logger.Logger;

final class ResetPasswordActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ ResetPasswordActivity this$0;

    ResetPasswordActivity$onCreate$1(ResetPasswordActivity resetPasswordActivity) {
        this.this$0 = resetPasswordActivity;
    }

    public final void onClick(View view) {
        Logger.d("cancelButton clicked", new Object[0]);
        this.this$0.finish();
    }
}
