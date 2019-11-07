package kr.co.popone.fitts.feature.intro.login;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.ui.DialogExtensions;

final class ResetPasswordActivity$onCreate$3 implements OnClickListener {
    final /* synthetic */ ResetPasswordActivity this$0;

    ResetPasswordActivity$onCreate$3(ResetPasswordActivity resetPasswordActivity) {
        this.this$0 = resetPasswordActivity;
    }

    public final void onClick(View view) {
        Logger.d("resetPasswordButton clicked", new Object[0]);
        if (this.this$0.resetPasswordRequest == null) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C0010R$id.errorMessageTextView);
            Intrinsics.checkExpressionValueIsNotNull(textView, "errorMessageTextView");
            textView.setVisibility(4);
            ResetPasswordActivity resetPasswordActivity = this.this$0;
            UserAPI userAPI$app_productionFittsRelease = resetPasswordActivity.getUserAPI$app_productionFittsRelease();
            EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.userIDEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText, "userIDEditText");
            resetPasswordActivity.resetPasswordRequest = userAPI$app_productionFittsRelease.resetPassword(editText.getText().toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action(this) {
                final /* synthetic */ ResetPasswordActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    this.this$0.this$0.resetPasswordRequest = null;
                    this.this$0.this$0.requestObservable.onNext(Boolean.valueOf(false));
                    DialogExtensions.INSTANCE.showMessageDialog(this.this$0.this$0, "이메일을 확인해주세요", "가입 시 입력한 이메일 주소로 이메일을 보냈습니다 이메일의 링크를 클릭하여 비밀번호를 재설정해주세요.", new Function0<Unit>(this) {
                        final /* synthetic */ AnonymousClass1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        public final void invoke() {
                            this.this$0.this$0.this$0.finish();
                        }
                    }, "확인");
                }
            }, new Consumer<Throwable>(this) {
                final /* synthetic */ ResetPasswordActivity$onCreate$3 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(Throwable th) {
                    this.this$0.this$0.resetPasswordRequest = null;
                    this.this$0.this$0.requestObservable.onNext(Boolean.valueOf(false));
                    StringBuilder sb = new StringBuilder();
                    sb.append("resetPasswordRequest error (");
                    sb.append(th);
                    sb.append(')');
                    Logger.d(sb.toString(), new Object[0]);
                    TextView textView = (TextView) this.this$0.this$0._$_findCachedViewById(C0010R$id.errorMessageTextView);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "errorMessageTextView");
                    textView.setVisibility(0);
                }
            });
            this.this$0.requestObservable.onNext(Boolean.valueOf(true));
        }
    }
}
