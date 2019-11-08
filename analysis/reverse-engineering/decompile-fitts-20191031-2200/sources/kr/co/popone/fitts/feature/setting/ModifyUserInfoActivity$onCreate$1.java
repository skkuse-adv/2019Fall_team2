package kr.co.popone.fitts.feature.setting;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.orhanobut.logger.Logger;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.jvm.internal.Intrinsics;
import kr.co.popone.fitts.C0010R$id;
import kr.co.popone.fitts.model.user.UserAPI;
import kr.co.popone.fitts.model.user.UserAPI.DefaultImpls;

final class ModifyUserInfoActivity$onCreate$1 implements OnClickListener {
    final /* synthetic */ ModifyUserInfoActivity this$0;

    ModifyUserInfoActivity$onCreate$1(ModifyUserInfoActivity modifyUserInfoActivity) {
        this.this$0 = modifyUserInfoActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.checkUserInput() && this.this$0.userInfoRegisterDisposable == null) {
            this.this$0.loadingSubject.onNext(Boolean.valueOf(true));
            ModifyUserInfoActivity modifyUserInfoActivity = this.this$0;
            UserAPI userAPI = modifyUserInfoActivity.getUserAPI();
            EditText editText = (EditText) this.this$0._$_findCachedViewById(C0010R$id.userNameEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText, "userNameEditText");
            String obj = editText.getText().toString();
            EditText editText2 = (EditText) this.this$0._$_findCachedViewById(C0010R$id.userPhoneEditText);
            Intrinsics.checkExpressionValueIsNotNull(editText2, "userPhoneEditText");
            modifyUserInfoActivity.userInfoRegisterDisposable = DefaultImpls.updateAdditionalInfo$default(userAPI, obj, editText2.getText().toString(), null, null, null, null, null, null, 128, null).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action(this) {
                final /* synthetic */ ModifyUserInfoActivity$onCreate$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void run() {
                    Logger.d("success updateAditionalInfo", new Object[0]);
                    this.this$0.this$0.userInfoRegisterDisposable = null;
                    this.this$0.this$0.loadingSubject.onNext(Boolean.valueOf(false));
                    this.this$0.this$0.onBackPressed();
                }
            }, new Consumer<Throwable>(this) {
                final /* synthetic */ ModifyUserInfoActivity$onCreate$1 this$0;

                {
                    this.this$0 = r1;
                }

                public final void accept(Throwable th) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("error ");
                    sb.append(th);
                    Logger.d(sb.toString(), new Object[0]);
                    this.this$0.this$0.userInfoRegisterDisposable = null;
                    this.this$0.this$0.loadingSubject.onNext(Boolean.valueOf(false));
                }
            });
        }
    }
}
