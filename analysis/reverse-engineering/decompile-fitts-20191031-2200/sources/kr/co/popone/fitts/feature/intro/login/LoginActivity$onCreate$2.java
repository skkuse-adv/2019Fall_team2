package kr.co.popone.fitts.feature.intro.login;

import android.widget.ScrollView;
import com.google.android.material.textfield.TextInputEditText;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import org.jetbrains.anko.DimensionsKt;

final class LoginActivity$onCreate$2<T> implements Consumer<Boolean> {
    final /* synthetic */ LoginActivity this$0;

    LoginActivity$onCreate$2(LoginActivity loginActivity) {
        this.this$0 = loginActivity;
    }

    public final void accept(Boolean bool) {
        Intrinsics.checkExpressionValueIsNotNull(bool, "it");
        if (bool.booleanValue()) {
            ((TextInputEditText) this.this$0._$_findCachedViewById(C0010R$id.password)).post(new Runnable(this) {
                final /* synthetic */ LoginActivity$onCreate$2 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    ((ScrollView) this.this$0.this$0._$_findCachedViewById(C0010R$id.scrollView)).smoothScrollTo(0, DimensionsKt.XHDPI);
                }
            });
        }
    }
}