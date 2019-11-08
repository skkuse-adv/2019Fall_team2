package kr.co.popone.fitts.feature.intro.login;

import android.widget.ImageButton;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0008R$drawable;
import kr.co.popone.fitts.C0010R$id;

final class LoginActivity$onCreate$6<T> implements Consumer<Boolean> {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onCreate$6(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void accept(Boolean bool) {
        ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C0010R$id.button_login);
        Intrinsics.checkExpressionValueIsNotNull(imageButton, "button_login");
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        imageButton.setEnabled(bool.booleanValue());
        ((ImageButton) this.this$0._$_findCachedViewById(C0010R$id.button_login)).setImageResource(bool.booleanValue() ? C0008R$drawable.button_next_p : C0008R$drawable.button_next);
    }
}
