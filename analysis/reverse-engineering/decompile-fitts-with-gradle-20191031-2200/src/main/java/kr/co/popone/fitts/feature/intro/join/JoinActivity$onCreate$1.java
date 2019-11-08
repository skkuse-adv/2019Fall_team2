package kr.co.popone.fitts.feature.intro.join;

import android.util.Patterns;
import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.user.UserAPI.EmailAvailable;
import kr.co.popone.fitts.utils.Snackbar;

final class JoinActivity$onCreate$1<T> implements Consumer<CharSequence> {
    final /* synthetic */ JoinActivity this$0;

    JoinActivity$onCreate$1(JoinActivity joinActivity) {
        this.this$0 = joinActivity;
    }

    public final void accept(CharSequence charSequence) {
        if (Patterns.EMAIL_ADDRESS.matcher(charSequence.toString()).matches()) {
            Disposable access$getEmailDuplicationCheckRequest$p = this.this$0.emailDuplicationCheckRequest;
            if (access$getEmailDuplicationCheckRequest$p != null) {
                access$getEmailDuplicationCheckRequest$p.dispose();
            }
            JoinActivity joinActivity = this.this$0;
            joinActivity.emailDuplicationCheckRequest = joinActivity.getUserAPI$app_productionFittsRelease().requestEmailAvailable(charSequence.toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<EmailAvailable>(this) {
                final /* synthetic */ JoinActivity$onCreate$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(EmailAvailable emailAvailable) {
                    this.this$0.this$0.emailDuplicationCheckRequest = null;
                    String str = "emailTextView";
                    String str2 = "";
                    if (!emailAvailable.is_available()) {
                        TextView textView = (TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.emailTextView);
                        Intrinsics.checkExpressionValueIsNotNull(textView, str);
                        textView.setText("이미 사용중인 이메일");
                        this.this$0.this$0.setEmail(str2);
                        this.this$0.this$0.emailObservable.onNext(str2);
                        return;
                    }
                    TextView textView2 = (TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.emailTextView);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, str);
                    textView2.setText(str2);
                    this.this$0.this$0.setEmail(emailAvailable.getEmail());
                    this.this$0.this$0.emailObservable.onNext(emailAvailable.getEmail());
                }
            }, new Consumer<Throwable>(this) {
                final /* synthetic */ JoinActivity$onCreate$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(Throwable th) {
                    this.this$0.this$0.emailDuplicationCheckRequest = null;
                    Logger.e(th.toString(), new Object[0]);
                    Snackbar.Companion.showMessage(this.this$0.this$0, "죄송합니다.\n서비스가 잠시 지연되고 있습니다.\n잠시 후 다시 이용해주세요.");
                }
            });
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(charSequence, "editEmail");
        String str = "emailTextView";
        String str2 = "";
        if (charSequence.length() > 0) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.emailTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, str);
            textView.setText("이메일 형식 오류");
            this.this$0.setEmail(str2);
            this.this$0.emailObservable.onNext(str2);
            return;
        }
        TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C0010R$id.emailTextView);
        Intrinsics.checkExpressionValueIsNotNull(textView2, str);
        textView2.setText(str2);
        this.this$0.setEmail(str2);
        this.this$0.emailObservable.onNext(str2);
    }
}
