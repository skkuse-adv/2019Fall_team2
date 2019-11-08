package kr.co.popone.fitts.feature.intro.join;

import android.widget.TextView;
import io.reactivex.functions.Consumer;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;

final class JoinActivity$onCreate$2<T> implements Consumer<CharSequence> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$2(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(CharSequence charSequence) {
        String str = "passwordTextView";
        String str2 = "";
        if (Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=[\\S]+$).{8,25}$").matcher(charSequence).matches()) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.passwordTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            textView.setText(str2);
            this.this$0.password = charSequence.toString();
            this.this$0.passwordObservable.onNext(charSequence.toString());
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(charSequence, "editPassword");
        if (charSequence.length() > 0) {
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.passwordTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView2, str);
            textView2.setText("8자 이상의 영어.숫자 조합");
            this.this$0.password = str2;
            this.this$0.passwordObservable.onNext(str2);
            return;
        }
        TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.passwordTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView3, str);
        textView3.setText(str2);
        this.this$0.password = str2;
        this.this$0.passwordObservable.onNext(str2);
    }
}
